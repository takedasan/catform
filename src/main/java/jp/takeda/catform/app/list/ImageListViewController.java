package jp.takeda.catform.app.list;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("list")
public class ImageListViewController {

	@RequestMapping(method = RequestMethod.GET)
	String doGet(Model model) {
		
		
		return "list/image";
	}
}
