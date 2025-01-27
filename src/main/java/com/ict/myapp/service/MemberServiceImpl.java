package com.ict.myapp.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.ict.myapp.dao.MemberDAO;
import com.ict.myapp.vo.MemberVO;

@Service
public class MemberServiceImpl implements MemberService {

	@Inject
	MemberDAO dao;
	@Override //MemberServiceImpl�� ���콺�ø��� override�ȵ� �޼ҵ� Ȯ�ΰ���
	public int memberInsert(MemberVO vo) {
		return dao.memberInsert(vo);
	}
	
	@Override
	public MemberVO loginOk(String userid, String userpwd) {
		return dao.loginOk(userid, userpwd);
	}
}
