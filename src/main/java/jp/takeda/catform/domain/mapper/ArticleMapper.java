package jp.takeda.catform.domain.mapper;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import jp.takeda.catform.domain.model.ArticleModel;

@Mapper
public interface ArticleMapper {

	@Select("SELECT article_id, post_date_time, article_title, shooting_date FROM article WHERE article_id = #{id}")
	ArticleModel findOne(int id);

	@Insert("INSERT INTO article (post_date_time, article_title, shooting_date) VALUES (#{postDateTime}, #{articleTitle}, #{shootingDate})")
	void insert(@Param("postDateTime") LocalDateTime postDateTime, @Param("articleTitle") String articleTitle,
			@Param("shootingDate") LocalDate shootingDate);

}
