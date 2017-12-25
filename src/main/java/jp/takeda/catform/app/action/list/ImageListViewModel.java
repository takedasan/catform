package jp.takeda.catform.app.action.list;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class ImageListViewModel {

	private String title;
	private String postDate;
	private List<String> imageList = new ArrayList<>();

}
