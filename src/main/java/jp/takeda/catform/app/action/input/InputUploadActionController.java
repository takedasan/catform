package jp.takeda.catform.app.action.input;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import jp.takeda.catform.domain.model.setting.ApplicationSetting;

@RestController
public class InputUploadActionController {

	@Autowired
	ApplicationSetting setting;

	@RequestMapping(path = "action/input/upload", method = RequestMethod.POST)
	ResponseEntity<String> doUpload(@RequestParam("file") List<MultipartFile> imageList) {

		if (imageList == null || imageList.isEmpty()) {
			return new ResponseEntity<>("no image file", HttpStatus.OK);
		}

		try {
			this.saveUploadedFiles(imageList);
		} catch (IOException e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<>("image file uploaded", HttpStatus.OK);
	}

	private void saveUploadedFiles(List<MultipartFile> files) throws IOException {

		for (MultipartFile file : files) {
			if (file.isEmpty()) {
				continue;
			}

			byte[] bytes = file.getBytes();

			Path path = Paths
					.get(this.setting.getStaticFolder() + this.setting.getUploadFolder() + file.getOriginalFilename());
			Files.write(path, bytes);
		}

	}
}
