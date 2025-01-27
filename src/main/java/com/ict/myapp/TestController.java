package com.ict.myapp;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestController {  
	
	//mapping 정보 기술
	//@RequestMapping(value="", method=RequestMethod.GET), @GetMapping, @PostMapping
	@RequestMapping(value="/test1", method=RequestMethod.GET)
	public String test1(HttpServletRequest request, Model model) {  //home이 String이기 때문에 반환형이 String이 된다.
		
		//통신에서는 항상 String으로 넘어와서 정수로 형변환
		int num = Integer.parseInt(request.getParameter("num"));
		String name = request.getParameter("name");
		
		System.out.println(num + ", " + name);
		
		//보낼 정보 셋팅 - Model 객체에 설정된 데이터는 View페이지(jsp)에서 사용 가능하다.
		model.addAttribute("username", "세종대왕");  //변수명.addAttribute("변수명", "값");
		model.addAttribute("hi", "welcome");
		
		//보낼 주소 셋팅
		return "home";  //'/WEB-INF/views/home.jsp' 중 ViewResolver가 '/WEB-INF/views/'의 정보를 가지고 있다.
	}
	
	@RequestMapping("/test2")  //test1에서는 정석적인 입력이고, GET 방식일때는 다른건 생략하고 "주소" 처럼 쓸 수 있다.
	public ModelAndView test2(int num, String name) {  //Spring에선 매개변수에 같은 변수명을 정의하면 home.jsp에 있는 변수가 자동으로 request되어 형변환된다.
		
		System.out.println(num + 10 + "====" + name);
		
		//Model과 View의 기능을 모두 가진 클래스 사용하여 반환하기
		ModelAndView mav = new ModelAndView();
		mav.addObject("username", "손흥민"); // 변수명.addObject("변수명", "값");
		mav.addObject("hi", "bye");
		
		//View페이지 셋팅
		mav.setViewName("home");
		
		return mav;
	}
	
	@GetMapping("/test3")
	public String test3(TestVO vo, Model model) {  //Spring에선 vo 변수에 선언만 해주면 다른 셋팅없이 값이 들어간다.
		System.out.println(vo.toString());
		
		TestVO obj = new TestVO(); //생성자를 별도로 안 만들어서 매개변수없는 메소드 사용
		obj.setNum(9999);
		obj.setName("김연아");
		obj.setTel("010-8888-9999");
		
		model.addAttribute("vo", obj);
		
		return "test/view";  //WEB-INF/views/test/view.jsp
	}
	
	// @PostMapping("/order") 아래와 같이 기능. post방식의 요청에 응답하는 수식. 
	// post방식은 한글을 encoding 하지않으면 다 깨진다.
	@RequestMapping(value="/order", method=RequestMethod.POST) 
	public ModelAndView test4(String productName, int price, String opt) {
		
		System.out.println("주문 상품정보 => " + productName + ", " + price + ", " + opt);
		
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("pName", productName + "(" + opt + ")");
		mav.addObject("sales", price*0.9);
		
		mav.setViewName("test/view");
		
		return mav;
	}
}
