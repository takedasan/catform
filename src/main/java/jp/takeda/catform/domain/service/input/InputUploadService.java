package jp.takeda.catform.domain.service.input;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jp.takeda.catform.app.action.input.UploadForm;
import jp.takeda.catform.domain.mapper.ArticleMapper;

@Service
@Transactional
public class InputUploadService {

	@Autowired
	ArticleMapper articleMapper;

	public void save(UploadForm form) {
		final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
		final LocalDateTime shootingDate = LocalDateTime.parse(form.getDate(), formatter);

		this.articleMapper.insert(LocalDateTime.now(), form.getTitle(), shootingDate.toLocalDate());
	}

}
