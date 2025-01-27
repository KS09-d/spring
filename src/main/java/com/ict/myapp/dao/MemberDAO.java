package com.ict.myapp.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.ict.myapp.vo.MemberVO;

@Mapper
@Repository
public interface MemberDAO {  //DAO가 Mapper의 역할을 한다.

	//아이디 중복검사
	
	
	//회원등록
	//등록이 됐는지 안됐는지 확인하기 위해 반환을 int로 한 추상메소드 생성
	public int memberInsert(MemberVO vo);   //(MemberVO) = (parameter값)
	
	
	
	//회원수정
	
	
	//회원탈퇴
	
	
	//로그인 (로그아웃은 session만 지우면 되기때문에 여기서 구현할 필요 X)
	public MemberVO loginOk(String userid, String userpwd);
	
	//아이디찾기
	
	
	//비밀번호찾기
}
