package jp.takeda.catform.domain.model;

import lombok.Data;

@Data
public class ImageModel {

	private int imageId;
	private String imageFileName;
	private int articleId;

}
