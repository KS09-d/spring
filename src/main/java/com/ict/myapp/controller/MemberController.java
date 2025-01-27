package com.ict.myapp.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ict.myapp.service.MemberService;
import com.ict.myapp.vo.MemberVO;

/* context.xml�� property�� �����ϴ� ������ �����ִ� ��
  ��ü ��ü�� = new ��ü("context�� property ����", "context.xml�� property ����", "context�� property ����"); */

@Controller
public class MemberController {

	//@Autowired ��ü�� ���� �Ʒ� �߻�Ŭ���� ��ü�� ������ �־��ִ� ���
	@Inject //���� @Autowired ������̼ǰ� ���� ���
	MemberService service; //�߻�Ŭ�����̱� ������ '= new'�� �����ʴ´�.
	
	@GetMapping("/member/form")
	public String form() {
		
		return "member/memberForm";  //ȸ������ ���������� jsp���ϸ�
	}
	
	@PostMapping("/member/formOk")
	public ModelAndView formOk(MemberVO vo) {
		
		int result = 0;
	
		try {
			result = service.memberInsert(vo);
			
			//System.out.println(vo.toString()); �ַܼ� �����Ͱ� �Ѿ������ Ȯ��
			//System.out.println(result); �Ϸ�� �÷���ŭ ���ڷ�(ȸ�������� 1�����̱� ������ �Ϸ�Ǹ� 1�� ����)
		} catch(Exception e) {
		
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("member/memberForm");	
		mav.addObject("result", result); //0 : ���� or 1 : ����
		mav.setViewName("member/memberOkResult");
		return mav;
	}
	
	//�α�����
	@GetMapping("/member/login")
	public String login() {
		return "member/login";
	}
	
	//�α���(DB��ȸ)
	@PostMapping("/member/loginOk")
	public ____ loginOk(String userid, String userpwd, HttpSession session) {  //()���� ������ request���ش�.
		
		MemberVO vo = service.loginOk(userid, userpwd);
		
		ModelAndView mav = new ModelAndView();
		
		if(vo != null) { //���̵�� ��й�ȣ�� ��ġ�ϴ� ������ ������ vo�� �����Ͱ� ������� return�ǰ�, 
			
			//�α��� ���� : session�� ���̵�, �̸�, �α��λ��� ���� �� Ȩ���� �̵�
			//session ���ϴ� �� : HttpServletRequest, HttpSession (�ݵ�� �鿣�带 ���ؼ� ���Ѵ�.)
			session.setAttribute("logid", vo.getUserid());
			session.setAttribute("logName", vo.getUsername());
			session.setAttribute("logStatus", "Y");
			
			//�ٸ� ���� �ּҷ� �ٷ� �̵��ϱ� ���ؼ� 'redirect:' �� �ٿ��� �ش� ���� �ּҸ� ȣ���Ѵ�.
			mav.setViewName("redirect:/");
			//mav.setViewName("home"); ���� ȣ���ϸ� home.jsp�� �̵��Ѵ�. homecontroller.java������ ��ɾ� ó���� ������� �������Ѵ�.
			
		} else { //��ġ�ϴ� ������ ������ vo�� null�� ��� ��ü�� �� ���������.
			//�α��� ���� : �α��������� �̵�
			
		}
		
	}
}



