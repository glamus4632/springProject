package kr.green.spring.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
//로그인하지 않고 list페이지에 접근하는 것을 막음
public class UnauthInterceptor extends HandlerInterceptorAdapter{//authentication = 권한부여
	@Override
	public boolean preHandle(HttpServletRequest request, 
	    HttpServletResponse response, Object handler)
	    throws Exception {
	    //HttpSession session = request.getSession();
		//Object user = session.getAttribute("user");
	    Object user = request.getSession().getAttribute("user");
	    //로그인에 성공하면 컨트롤러에서 user가 add어트리뷰트가 된다
	    //그래서 어트리뷰트에 user가 에드되어 있는지 판단
	    if(user != null) {//유저 정보가 있으면
	    	response.sendRedirect(request.getContextPath()+"/bbs/list");
	    }
	    return true;//정보가 없으면 원래 가려고 한 URI로 간다 return을 false로 하면 가긴 가는데 대신 동작을 안함
	    //컨테이너까지 안가니까
	}
}
