package jp.takeda.catform.domain.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import jp.takeda.catform.domain.model.ImageModel;

@Mapper
public interface ImageMapper {

	@Select("SELECT image_id, image_file_name, article_id FROM image WHERE image_id = #{id}")
	ImageModel findOne(int id);

}
