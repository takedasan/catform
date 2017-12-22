package jp.takeda.catform.app.action.input;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("action/input")
public class UploadActionController {

	@RequestMapping(method = RequestMethod.POST)
	String doPost(@RequestBody String body) {
		System.out.println(body);

		return body;
	}
}
