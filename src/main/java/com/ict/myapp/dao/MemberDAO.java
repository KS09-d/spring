package com.ict.myapp.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.ict.myapp.vo.MemberVO;

@Mapper
@Repository
public interface MemberDAO {  //DAO�� Mapper�� ������ �Ѵ�.

	//���̵� �ߺ��˻�
	
	
	//ȸ�����
	//����� �ƴ��� �ȵƴ��� Ȯ���ϱ� ���� ��ȯ�� int�� �� �߻�޼ҵ� ����
	public int memberInsert(MemberVO vo);   //(MemberVO) = (parameter��)
	
	
	
	//ȸ������
	
	
	//ȸ��Ż��
	
	
	//�α��� (�α׾ƿ��� session�� ����� �Ǳ⶧���� ���⼭ ������ �ʿ� X)
	public MemberVO loginOk(String userid, String userpwd);
	
	//���̵�ã��
	
	
	//��й�ȣã��
}
