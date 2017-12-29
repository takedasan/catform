package jp.takeda.catform.domain.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import jp.takeda.catform.domain.model.ImageModel;

@Mapper
public interface ImageMapper {

	@Select("SELECT image_id, image_file_name, article_id FROM image WHERE image_id = #{id}")
	ImageModel findOne(int id);

	@Select("SELECT image_id, image_file_name, article_id FROM image")
	ImageModel findAll();

	@Select("SELECT image_id, image_file_name, article_id FROM image WHERE article_id = #{id}")
	List<ImageModel> findByArticleId(int id);

	@Options(useGeneratedKeys = true, keyProperty = "imageId")
	@Insert("INSERT INTO image (image_file_name, article_id) VALUES (#{imageFileName}, #{articleId})")
	void insert(ImageModel image);

}
