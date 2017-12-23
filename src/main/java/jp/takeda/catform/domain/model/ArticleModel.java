package jp.takeda.catform.domain.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.Data;

@Data
public class ArticleModel {

	private int articleId;
	private LocalDateTime postDateTime;
	private String articleTitle;
	private LocalDate shootingDate;

}
