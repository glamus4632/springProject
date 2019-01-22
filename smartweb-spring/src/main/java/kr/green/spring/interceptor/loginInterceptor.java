package kr.green.spring.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import kr.green.spring.vo.AccountVo;
//로그인하면 유저 정보를 세션에 저장
public class loginInterceptor extends HandlerInterceptorAdapter{
	@Override
	public void postHandle(//postHandle 처음 접근 시 인터셉트
	    HttpServletRequest request, 
	    HttpServletResponse response, 
	    Object handler, 
	    ModelAndView modelAndView)
	    throws Exception {
	    //ModelMap modelMap = modelAndView.getModelMap();
	    //AccountVo user = (AccountVo)modelMap.get("user");//정보가 있으면 그 정보를 가져오고 없으면 null
		//한줄로
		AccountVo user = (AccountVo)modelAndView.getModelMap().get("user");
	    //"user"는 로그인 리퀘스트 컨트롤러에서 model.addAttribute("user",user)이다.
	    // 즉 user를 저장하여 ${user}를 어디서나 쓸 수 있게 만든거다
	    
		if(user != null) {//유저가 로그인 했으면
	        //HttpSession session = request.getSession();//리퀘스트된 세션(정보)을 저장
	        //session.setAttribute("user", user);
	        //한줄로
	    	request.getSession().setAttribute("user", user);//어트리뷰트 설정
	    	//user가 vo타입이라서 .id, .email등의 사용이 가능해졌다
	    }
	}	
	
}
