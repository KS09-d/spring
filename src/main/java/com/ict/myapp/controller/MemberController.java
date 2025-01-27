package com.ict.myapp.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ict.myapp.service.MemberService;
import com.ict.myapp.vo.MemberVO;

/* context.xml의 property에 기입하는 정보가 전해주는 곳
  객체 객체명 = new 객체("context의 property 정보", "context.xml의 property 정보", "context의 property 정보"); */

@Controller
public class MemberController {

	//@Autowired 객체를 만들어서 아래 추상클래스 객체에 정보를 넣어주는 기능
	@Inject //위의 @Autowired 어노테이션과 같은 기능
	MemberService service; //추상클래스이기 때문에 '= new'를 하지않는다.
	
	@GetMapping("/member/form")
	public String form() {
		
		return "member/memberForm";  //회원가입 뷰페이지의 jsp파일명
	}
	
	@PostMapping("/member/formOk")
	public ModelAndView formOk(MemberVO vo) {
		
		int result = 0;
	
		try {
			result = service.memberInsert(vo);
			
			//System.out.println(vo.toString()); 콘솔로 데이터가 넘어오는지 확인
			//System.out.println(result); 완료된 컬럼만큼 숫자로(회원가입은 1개씩이기 때문에 완료되면 1이 찍힘)
		} catch(Exception e) {
		
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("member/memberForm");	
		mav.addObject("result", result); //0 : 실패 or 1 : 성공
		mav.setViewName("member/memberOkResult");
		return mav;
	}
	
	//로그인폼
	@GetMapping("/member/login")
	public String login() {
		return "member/login";
	}
	
	//로그인(DB조회)
	@PostMapping("/member/loginOk")
	public ____ loginOk(String userid, String userpwd, HttpSession session) {  //()안의 변수를 request해준다.
		
		MemberVO vo = service.loginOk(userid, userpwd);
		
		ModelAndView mav = new ModelAndView();
		
		if(vo != null) { //아이디와 비밀번호가 일치하는 정보가 있으면 vo에 데이터가 담겨져서 return되고, 
			
			//로그인 성공 : session에 아이디, 이름, 로그인상태 저장 후 홈으로 이동
			//session 구하는 법 : HttpServletRequest, HttpSession (반드시 백엔드를 통해서 구한다.)
			session.setAttribute("logid", vo.getUserid());
			session.setAttribute("logName", vo.getUsername());
			session.setAttribute("logStatus", "Y");
			
			//다른 맵핑 주소로 바로 이동하기 위해서 'redirect:' 를 붙여서 해당 맵핑 주소를 호출한다.
			mav.setViewName("redirect:/");
			//mav.setViewName("home"); 으로 호출하면 home.jsp로 이동한다. homecontroller.java에서의 명령어 처리를 순서대로 하지못한다.
			
		} else { //일치하는 정보가 없으면 vo에 null이 담겨 객체가 안 만들어진다.
			//로그인 실패 : 로그인폼으로 이동
			
		}
		
	}
}



