package jp.takeda.catform.domain.model.setting;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
@ConfigurationProperties(prefix = "app")
public class ApplicationSetting {

	private String staticFolder;
	private String uploadFolder;

}
