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
	
	//mapping ���� ���
	//@RequestMapping(value="", method=RequestMethod.GET), @GetMapping, @PostMapping
	@RequestMapping(value="/test1", method=RequestMethod.GET)
	public String test1(HttpServletRequest request, Model model) {  //home�� String�̱� ������ ��ȯ���� String�� �ȴ�.
		
		//��ſ����� �׻� String���� �Ѿ�ͼ� ������ ����ȯ
		int num = Integer.parseInt(request.getParameter("num"));
		String name = request.getParameter("name");
		
		System.out.println(num + ", " + name);
		
		//���� ���� ���� - Model ��ü�� ������ �����ʹ� View������(jsp)���� ��� �����ϴ�.
		model.addAttribute("username", "�������");  //������.addAttribute("������", "��");
		model.addAttribute("hi", "welcome");
		
		//���� �ּ� ����
		return "home";  //'/WEB-INF/views/home.jsp' �� ViewResolver�� '/WEB-INF/views/'�� ������ ������ �ִ�.
	}
	
	@RequestMapping("/test2")  //test1������ �������� �Է��̰�, GET ����϶��� �ٸ��� �����ϰ� "�ּ�" ó�� �� �� �ִ�.
	public ModelAndView test2(int num, String name) {  //Spring���� �Ű������� ���� �������� �����ϸ� home.jsp�� �ִ� ������ �ڵ����� request�Ǿ� ����ȯ�ȴ�.
		
		System.out.println(num + 10 + "====" + name);
		
		//Model�� View�� ����� ��� ���� Ŭ���� ����Ͽ� ��ȯ�ϱ�
		ModelAndView mav = new ModelAndView();
		mav.addObject("username", "�����"); // ������.addObject("������", "��");
		mav.addObject("hi", "bye");
		
		//View������ ����
		mav.setViewName("home");
		
		return mav;
	}
	
	@GetMapping("/test3")
	public String test3(TestVO vo, Model model) {  //Spring���� vo ������ ���� ���ָ� �ٸ� ���þ��� ���� ����.
		System.out.println(vo.toString());
		
		TestVO obj = new TestVO(); //�����ڸ� ������ �� ���� �Ű��������� �޼ҵ� ���
		obj.setNum(9999);
		obj.setName("�迬��");
		obj.setTel("010-8888-9999");
		
		model.addAttribute("vo", obj);
		
		return "test/view";  //WEB-INF/views/test/view.jsp
	}
	
	// @PostMapping("/order") �Ʒ��� ���� ���. post����� ��û�� �����ϴ� ����. 
	// post����� �ѱ��� encoding ���������� �� ������.
	@RequestMapping(value="/order", method=RequestMethod.POST) 
	public ModelAndView test4(String productName, int price, String opt) {
		
		System.out.println("�ֹ� ��ǰ���� => " + productName + ", " + price + ", " + opt);
		
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("pName", productName + "(" + opt + ")");
		mav.addObject("sales", price*0.9);
		
		mav.setViewName("test/view");
		
		return mav;
	}
}
