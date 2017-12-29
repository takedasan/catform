package jp.takeda.catform.batch;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.batch.MyBatisCursorItemReader;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;

import jp.takeda.catform.domain.model.ImageModel;

@Configuration
@EnableBatchProcessing
public class BatchConfiguration {

	@Autowired
	public JobBuilderFactory jobBuilderFactory;

	@Autowired
	public StepBuilderFactory stepBuilderFactory;

	@Autowired
	private SqlSessionFactory sqlSessionFactory;

	@Bean
	public Job myJob() {
		return jobBuilderFactory.get("myJob") //
				.incrementer(new RunIdIncrementer()) //
				.listener(listener())//
				.flow(step1()) //
				.end() //
				.build();
	}

	@Bean
	public Step step1() {
		return stepBuilderFactory.get("step1") //
				.<ImageModel, ImageModel>chunk(1) //
				.reader(reader()) //
				.processor(processor()) //
				.writer(writer()) //
				.build();
	}

	@Bean
	public MyBatisCursorItemReader<ImageModel> reader() {
		MyBatisCursorItemReader<ImageModel> reader = new MyBatisCursorItemReader<>();
		reader.setSqlSessionFactory(this.sqlSessionFactory);
		reader.setQueryId("jp.takeda.catform.domain.mapper.ImageMapper.findAll");

		return reader;
	}

	@Bean
	public ImageItemProcessor processor() {
		return new ImageItemProcessor();
	}

	@Bean
	public FlatFileItemWriter<ImageModel> writer() {
		FlatFileItemWriter<ImageModel> writer = new FlatFileItemWriter<ImageModel>();
		writer.setResource(new FileSystemResource("E:\\sample-data.csv"));
		writer.setLineAggregator(item -> {
			StringBuilder sb = new StringBuilder();
			sb.append(item.getImageId());
			sb.append(",");
			sb.append(item.getImageFileName());

			return sb.toString();
		});

		return writer;
	}

	@Bean
	public JobExecutionListener listener() {
		return new JobStartEndLIstener();
	}

}
