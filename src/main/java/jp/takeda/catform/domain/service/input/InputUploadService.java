package jp.takeda.catform.domain.service.input;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jp.takeda.catform.domain.mapper.ArticleMapper;
import jp.takeda.catform.domain.mapper.ImageMapper;
import jp.takeda.catform.domain.model.ArticleModel;
import jp.takeda.catform.domain.model.ImageModel;

@Service
@Transactional
public class InputUploadService {

	@Autowired
	ArticleMapper articleMapper;

	@Autowired
	ImageMapper imageMapper;

	public void save(ArticleModel article, List<ImageModel> imageList) {
		// insert article table
		this.articleMapper.insert(article);

		// insert image table
		for (ImageModel image : imageList) {
			image.setArticleId(article.getArticleId());
			this.imageMapper.insert(image);
		}

	}

}
