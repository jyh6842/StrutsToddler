package kr.or.ddit.member.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import kr.or.ddit.vo.MemberVO;

public interface IMemberDAO {

	public MemberVO memberInfo(Map<String, String> params) throws Exception;

	public List<MemberVO> memberList(Map<String, String> params) throws Exception;

	public void deleteMemberInfo(Map<String, String> params) throws Exception;

	public void updateMemberInfo(MemberVO memberInfo) throws Exception;

	public int insertMember(MemberVO insertMemberInfo) throws Exception; 
	
	public String totalCount(Map<String, String> parmas) throws Exception;
}
