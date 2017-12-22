package jp.takeda.catform.app.input;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("input")
public class UploadViewController {

	@RequestMapping(method = RequestMethod.GET)
	String doGet(Model model) {
		return "input/upload";
	}
}
