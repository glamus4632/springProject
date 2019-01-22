package kr.green.spring.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import kr.green.spring.vo.AccountVo;
//로그인한 상태에서 회원가입 페이지 가는것을 막음
public class AuthInterceptor extends HandlerInterceptorAdapter{
	@Override
	public boolean preHandle(HttpServletRequest request, //preHandle jsp로 갈 때 인터셉트
	    HttpServletResponse response, Object handler)
	    throws Exception {
	    //HttpSession session = request.getSession();
		//Object user = session.getAttribute("user");
	    Object user = request.getSession().getAttribute("user");//로그인에 실패하면 null
	    if(user == null) {//유저 정보가 없으면(로그인 안했으면)
	    	response.sendRedirect(request.getContextPath()+"/");//그냥 홈으로 가!
	    }
	    return true;//가던 곳으로 가십쇼(컨트롤러 까지 갑니다)
	}
}
