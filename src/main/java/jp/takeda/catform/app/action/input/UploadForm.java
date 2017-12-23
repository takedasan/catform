package jp.takeda.catform.app.action.input;

import java.util.List;

import lombok.Data;

@Data
public class UploadForm {

	private String title;
	private String date;
	private List<ImageFileData> imageList;

}
