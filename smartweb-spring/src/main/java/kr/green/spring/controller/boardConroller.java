package kr.green.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.green.spring.vo.BoardVo;
import kr.green.spring.service.BoardService;
@Controller
@RequestMapping(value = "/bbs")//리다이렉트로 bbs로 들어오는 애는 여기로 와라
public class boardConroller {
	@Autowired
	BoardService boardService;
	//로그인 후 이동할 페이지
	@RequestMapping(value = "/list" , method=RequestMethod.GET)// 자동으로 /bbs가 붙는다
	public String listGet() {	
		return "bbs/list";
	}
	
	//글쓰기 페이지(register)
	@RequestMapping(value = "/register", method=RequestMethod.GET)
	public String registerGet() {		
		return "bbs/register";
	}
	@RequestMapping(value = "/register", method=RequestMethod.POST)
	public String registerPost(BoardVo board) {		
		boardService.register(board);//중복체크 할 필요가 없다.
		//타이틀이나 컨텐츠의 null판단은 프론트에서 할 것임
		return "redirect:/bbs/list";
		//@RequestMapping(value = "/bbs")을 썻으니까 /bbs의 /는 spring
		// /없이 list만 쓰면 앞에 bbs/가 붙어서 작동하고 bbs/list를 하면 bbs/가 붙어서 bbs/bbs/list가 되어버린다
		
	}

}
