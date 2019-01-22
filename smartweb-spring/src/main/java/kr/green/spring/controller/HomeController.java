package kr.green.spring.controller;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.green.spring.service.AccountService;
import kr.green.spring.vo.AccountVo;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	@Autowired
	AccountService accountService;
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String homeGet(Model model, Boolean signup, Boolean login) {
		Date date = new Date();
		//System.out.print(login);
		model.addAttribute("signup",signup);//아래에서 true가 담긴 signup을 멤버변수로 받아 사용함
		model.addAttribute("login",login);
		return "home";//home.jsp
	}
	//로그인 리퀘스트
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String homePost(String id, String pw, Model model) {
		AccountVo user = accountService.login(id, pw);//id검색과 로그인 되었는지 확인
		
		if(user != null) {
			//System.out.println("로그인 성공");
			model.addAttribute("user",user);
			return "redirect:bbs/list";
		}else{
			//System.out.println("로그인 실패");
			model.addAttribute("login",false);
			return "redirect:/";
			
		}
	}
	//회원가입 리퀘스트
	@RequestMapping(value ="/signup", method=RequestMethod.GET)//같은 value를 사용할 수 없다(method가 같을 때)
	public String signupGet(Model model, Boolean signup) {
		//rapper클래스 Boolean은 boolean을 클래스화 시킨것으로 null값을 사용하기 위해서 래퍼클래스를 쓴다
		model.addAttribute("signup",signup);
		return "signup";//signup.jsp
	}
	
	@RequestMapping(value ="/signup", method=RequestMethod.POST)
	public String signupPost(AccountVo accountVo, Model model) {
		//회원가입
		if(accountService.signup(accountVo)) {
			//System.out.println("회원가입 성공");
			return "redirect:/";
		}
		else {
			//System.out.println("회원가입 실패");
			model.addAttribute("signup",true);
			return "redirect:/signup";
		}
	}

}
