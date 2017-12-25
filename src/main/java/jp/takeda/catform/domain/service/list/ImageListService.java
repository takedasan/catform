package jp.takeda.catform.domain.service.list;

import java.time.LocalDateTime;
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
public class ImageListService {

	@Autowired
	ArticleMapper articleMapper;

	@Autowired
	ImageMapper imageMapper;

	public List<ArticleModel> getRecentArticle() {
		LocalDateTime dateTime = LocalDateTime.now().minusDays(3);
		List<ArticleModel> recentArticleList = this.articleMapper.findRecentPost(dateTime);

		return recentArticleList;
	}

	public List<ImageModel> getRelatedImage(ArticleModel article) {
		List<ImageModel> imgaeList = this.imageMapper.findByArticleId(article.getArticleId());

		return imgaeList;
	}

}
