package jp.takeda.catform.domain.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import jp.takeda.catform.domain.model.ArticleModel;

@Mapper
public interface ArticleMapper {

	@Select("SELECT article_id, post_date_time, article_title, shooting_date FROM article WHERE article_id = #{id}")
	ArticleModel findOne(int id);

	@Options(useGeneratedKeys = true, keyProperty = "articleId")
	@Insert("INSERT INTO article (post_date_time, article_title, shooting_date) VALUES (#{postDateTime}, #{articleTitle}, #{shootingDate})")
	void insert(ArticleModel article);

}
