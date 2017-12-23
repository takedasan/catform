package jp.takeda.catform.app.action.input;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import jp.takeda.catform.domain.service.input.InputUploadService;

@RestController
@RequestMapping("action/input/post")
public class InputPostActionController {

	@Autowired
	InputUploadService inputUploadService;

	@RequestMapping(method = RequestMethod.POST)
	ResponseEntity<String> doPost(@RequestBody UploadForm body) {
		System.out.println(body);
		inputUploadService.save(body);

		return new ResponseEntity<>(HttpStatus.OK);
	}
}
