package jp.takeda.catform.batch;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;

import jp.takeda.catform.domain.model.ImageModel;
import jp.takeda.catform.domain.model.setting.ApplicationSetting;

public class ImageItemProcessor implements ItemProcessor<ImageModel, ImageModel> {

	@Autowired
	ApplicationSetting setting;

	@Override
	public ImageModel process(ImageModel input) throws Exception {

		ImageModel model = new ImageModel();
		model.setImageId(input.getImageId());
		model.setArticleId(input.getArticleId());

		// Build image file path
		StringBuilder sb = new StringBuilder();
		sb.append(this.setting.getStaticFolder());
		sb.append(this.setting.getUploadFolder());
		sb.append(input.getImageFileName());
		model.setImageFileName(sb.toString());

		return model;
	}

}
