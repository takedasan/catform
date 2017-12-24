package jp.takeda.catform.app.action.input;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import jp.takeda.catform.domain.model.ArticleModel;
import jp.takeda.catform.domain.model.ImageModel;
import jp.takeda.catform.domain.service.input.InputUploadService;

@RestController
@RequestMapping("action/input/post")
public class InputPostActionController {

	@Autowired
	InputUploadService inputUploadService;

	@RequestMapping(method = RequestMethod.POST)
	ResponseEntity<String> doPost(@RequestBody UploadForm body) {
		// save form data
		ArticleModel article = new ArticleModel();
		final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
		final LocalDateTime shootingDate = LocalDateTime.parse(body.getDate(), formatter);
		article.setArticleTitle(body.getTitle());
		article.setPostDateTime(LocalDateTime.now());
		article.setShootingDate(shootingDate.toLocalDate());

		List<ImageModel> imageList = new ArrayList<>();
		for (ImageFileData imageFileName : body.getImageList()) {
			final ImageModel image = new ImageModel();
			image.setImageFileName(imageFileName.getName());
			imageList.add(image);
		}

		inputUploadService.save(article, imageList);

		return new ResponseEntity<>(HttpStatus.OK);
	}
}
