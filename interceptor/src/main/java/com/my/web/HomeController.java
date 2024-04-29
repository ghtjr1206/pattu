package com.my.web;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {
	
	@RequestMapping(value = { "/home.do", "/home"}, method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, 
				DateFormat.LONG, locale);
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		return "intercept/home";
	}
	
	@RequestMapping(value="/login.do", method=RequestMethod.GET)
	public String login() {
		return "intercept/login";
	}
	
	@RequestMapping(value="/login.do", method=RequestMethod.POST)
	public String loginAction(HttpServletRequest req,
			HttpServletResponse res, HttpSession session) {
		String userId = req.getParameter("userId");

		session.setAttribute("userId", userId);
		return "redirect:/main.do";
	}
	
	@RequestMapping(value="/main.do", method=RequestMethod.GET)
	public String main() {
		return "intercept/main";
	}
	
	@RequestMapping(value="/join.do", method=RequestMethod.GET)
	public String join() {
		return "intercept/join";
	}	
	
	
	//Pathvariable 예제  /pathvar/page/two
	//path에 변수를 담는다 : {var}
	// /pathvar/page/ => path  , two => 변수
	@RequestMapping("/pathvar/page/{var}")
	//{var}와 @PathVariable("var")의 이름이 같아야 한다.
		public String page(@PathVariable("var") String v) {
//		public String page(@PathVariable String var) {
		String returnUrl = "";
		
		if (v.equals("one"))  returnUrl = "pathvar/page1";
		else if (v.equals("two"))  returnUrl = "pathvar/page2";
		
//		@ResponseBody를 적지 않으면 경로로 보내라는 의미.
		return returnUrl;
	}

	/** GET 방식 컨트롤러
	 * @param key1
	 * @param key2
	 */
	
	/*
	 * uri => http://localhost:8090/pathvar/byGet?key1=111&key2=zzz
	 * url패턴의 범위 : 인터넷프로토콜://서버이름(호스트명):포트번호[/컨텍스트패스]/경로....까지
	 * ***쿼리스트링은 url패턴에 포함되지 않는다.
	 * 인터넷프로토콜://서버이름(호스트명):포트번호[/컨텍스트패스]/경로....?쿼리스트링
	 * 
	 * */
	
	
//	"/pathvar/byGet?key1=111&key2=zzz"
	//  "/pathvar/byGet" 쿼리스트링으로 보낸 파라미터: ?key1=111&key2=zzz
	@RequestMapping("/pathvar/byGet")
	public String resultByGet(@RequestParam(value="key1") String k1,
			@RequestParam(value="key2")  String k2, Model model) {
	//	System.out.println("Get key1 : " + key1);
	//	System.out.println("Get key2 : " + key2);
		
		model.addAttribute("key1", k1); // "111"
		model.addAttribute("key2", k2); // "zzz"
		return "pathvar/path";
	}
	
	/** Pathvariable 방식 컨트롤러
	 * @param key1
	 * @param key2
	 */
	

//	"/pathvar/byGet?key1=111&key2=zzz"  => 쿼리스트링방식을 받지 못한다.
	// /pathvar/byPath/qaz/987
	@RequestMapping("/pathvar/byPath/{key1}/{key2}")
	public String resultByPath(@PathVariable String key1, @PathVariable String key2) {
//		el로 @PathVariable로 받은 변수도 가져올 수 있다.
		System.out.println("Path key1 :: " + key1);  //qaz
		System.out.println("Path key2 :: " + key2);  //987
		return "pathvar/path";
	}
	
	/** Pathvariable 방식 컨트롤러
	 * @param key1
	 * @param key2
	 */
	
	//
	// "/pathvar/byPath/key1/123/key2/aza"
	@RequestMapping("/pathvar/byPath/key1/{key1}/key2/{key2}")
	public String resultByPath2(@PathVariable String key1, @PathVariable String key2) {
		System.out.println("Path key1 ::: " + key1);  //123
		System.out.println("Path key2 ::: " + key2);  //aza
		
		return "pathvar/path";
	}
}
