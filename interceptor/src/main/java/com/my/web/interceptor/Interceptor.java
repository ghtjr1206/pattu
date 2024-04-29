package com.my.web.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;

//HandlerInterceptor를 반드시 상속받아서 구현해야한다.
//컨트롤러가 발동되는 조건의 url이 들어와야 실행된다. (url이 컨트롤러에 들어가는 중에 잡아챈다.) 사용예시 > 로그인
//적절한 값 => true반환, 컨트롤러로 넘어간다. / 부적절한 값 => false반환, 컨트롤러를 타지 못한다.
public class Interceptor implements HandlerInterceptor{

//	static final String[] EXCLUDE_URL_LIST = { "/login", "/join", "/home" };
	
	@Override
//	pre : 앞에, 맨앞에, 이전에
	//preHandle() : 핸들러 맵퍼가 작동하기 전에 실행되는 메서드
//	HttpServletRequest request,HttpServletResponse response 는 반드시 받아야 한다.
	public boolean preHandle(HttpServletRequest request, 
			HttpServletResponse response, Object handler) 
			throws Exception {
		String reqUrl = request.getRequestURL().toString(); 
		System.out.println("reqUrl: "+reqUrl); 
		
//		로그인체크 제외 리스트 
//		for (String target : EXCLUDE_URL_LIST) { //{ "/login", "/join", "/home" };
//			  
//			if (reqUrl.indexOf(target) > -1) return true;
//		}
		
		// 내가 설정하 session이 있으며 그 객체를 반환하고, 없으면 새로 만들어라.
		HttpSession session = request.getSession();
		String userId = (String)session.getAttribute("userId");
		
		if(userId == null || userId.trim().equals("")) {
			session.invalidate();	
			//페이지 이동
			response.sendRedirect(request.getContextPath() + "/login.do");
			return false;
		}
		
		return true;
	}
}
