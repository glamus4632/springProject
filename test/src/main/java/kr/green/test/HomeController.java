package kr.green.test;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model, Integer num) {//null값을 받기 위해 int가 아니라 Integer를 써야한다
		//if(num == null) num = 1;
		/*게시판 페이징을 할 때 최초 null값이면 첫페이지로 이동하게 하기 위해 이런식으로 쓴다*/
		model.addAttribute("messege",num);
		
		return "home";
	}
	
}
