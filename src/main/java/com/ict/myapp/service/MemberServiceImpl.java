package com.ict.myapp.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.ict.myapp.dao.MemberDAO;
import com.ict.myapp.vo.MemberVO;

@Service
public class MemberServiceImpl implements MemberService {

	@Inject
	MemberDAO dao;
	@Override //MemberServiceImpl에 마우스올리면 override안된 메소드 확인가능
	public int memberInsert(MemberVO vo) {
		return dao.memberInsert(vo);
	}
	
	@Override
	public MemberVO loginOk(String userid, String userpwd) {
		return dao.loginOk(userid, userpwd);
	}
}
