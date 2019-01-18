package kr.green.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.green.spring.vo.AccountVo;

@Controller
@RequestMapping(value = "/bbs")//bss로 들어오는 애는 여기로 와라
public class boardConroller {
	

	@RequestMapping(value = "/list")// 자동으로 /bbs가 붙는다
	public String listGet() {
		//rapper클래스 Boolean은 boolean을 클래스화 시킨것으로 null값을 사용하기 위해서 래퍼클래스를 쓴다
		
		return "bbs/list";
	}
}
