package jp.takeda.catform.app.action.list;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import jp.takeda.catform.domain.model.ArticleModel;
import jp.takeda.catform.domain.model.ImageModel;
import jp.takeda.catform.domain.model.setting.ApplicationSetting;
import jp.takeda.catform.domain.service.list.ImageListService;

@RestController
public class ImageListGetActionController {

	@Autowired
	ImageListService imageListService;

	@Autowired
	ApplicationSetting setting;

	@RequestMapping(path = "action/list/recent", method = RequestMethod.POST)
	ResponseEntity<List<ImageListViewModel>> doRecentPost() {
		List<ArticleModel> articleModelList = this.imageListService.getRecentArticle();

		// create viewModel List
		List<ImageListViewModel> viewModelList = new ArrayList<>();
		for (ArticleModel article : articleModelList) {
			List<ImageModel> imageList = this.imageListService.getRelatedImage(article);
			ImageListViewModel viewModel = new ImageListViewModel();
			viewModel.setTitle(article.getArticleTitle());
			viewModel.setPostDate(article.getPostDateTime().format(DateTimeFormatter.ISO_LOCAL_DATE));

			for (ImageModel image : imageList) {
				viewModel.getImageList().add(this.setting.getUploadFolder() + image.getImageFileName());
			}

			viewModelList.add(viewModel);

			// FIXME remove magic number
			if (viewModelList.size() == 3) {
				break;
			}
		}

		return new ResponseEntity<>(viewModelList, HttpStatus.OK);
	}

}
