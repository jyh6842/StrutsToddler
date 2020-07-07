package kr.or.ddit.member.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.member.dao.IMemberDAO;
import kr.or.ddit.member.dao.IMemberDAOImpl;
import kr.or.ddit.vo.MemberVO;

public class IMemberServiceImpl implements IMemberService {
	// 싱글톤 패턴
	private static IMemberService service = new IMemberServiceImpl();
	private IMemberDAO dao;

	private IMemberServiceImpl() {
		dao = IMemberDAOImpl.getInstance();
	}

	public static IMemberService getInstance() {
		return (service == null) ? service = new IMemberServiceImpl() : service;
	}

	@Override
	public MemberVO memberInfo(Map<String, String> params) {
		MemberVO memberInfo = null;
		try {
			 memberInfo = dao.memberInfo(params);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return memberInfo;
	}

	@Override
	public List<MemberVO> memberList(Map<String, String> params) {
		List<MemberVO> memberList = null;
		try {
			memberList = dao.memberList(params);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return memberList;
	}

	@Override
	public void deleteMemberInfo(Map<String, String> params) {
		try {
			dao.deleteMemberInfo(params);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void updateMemberInfo(MemberVO memberInfo) {
		try {
			dao.updateMemberInfo(memberInfo);
		} catch (Exception e) {
			e.printStackTrace(); // 에러를 콘솔 방향으로 출력한다.
		}
	}

	@Override
	public int insertMember(MemberVO insertMemberInfo) {
		int cnt = 0;
		try {
			cnt = dao.insertMember(insertMemberInfo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public String totalCount(Map<String, String> parmas) {
		String totalCount = null;
		try {
			totalCount = dao.totalCount(parmas);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return totalCount;
	}

}
