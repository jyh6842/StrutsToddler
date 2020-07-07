package kr.or.ddit.member.dao;

import java.util.List;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.ibatis.factory.SqlMapClientFactory;
import kr.or.ddit.vo.MemberVO;

public class IMemberDAOImpl implements IMemberDAO {
	
	private static IMemberDAO dao = new IMemberDAOImpl();

	private SqlMapClient client;
	
	private IMemberDAOImpl(){
		client = SqlMapClientFactory.getSqlMapClient();
	}
		
	public static IMemberDAO getInstance() {
		return (dao == null) ? dao = new IMemberDAOImpl() : dao;
	}
	
	@Override
	public MemberVO memberInfo(Map<String, String> params) throws Exception {
		return (MemberVO) client.queryForObject("member.memberInfo", params); // Object 타입으로 Upcasting으로 전달하기 때문에 
																			  // 나중에 값을 받아 올때 DownCasting를 해줘야 한다.
	}

	@Override
	public List<MemberVO> memberList(Map<String, String> params) throws Exception {
		return client.queryForList("member.memberList", params);
	}

	@Override
	public void deleteMemberInfo(Map<String, String> params) throws Exception {
		client.update("member.deleteMember", params);
	}

	@Override
	public void updateMemberInfo(MemberVO memberInfo) throws Exception {
		// udpate 쿼리
		// 테이블 생성
		// 프로시저, 펑션을 작성 및 호출
		// 오라클 객체 생성
		// client.update(agr0)
		client.update("member.updateMember", memberInfo);
	}

	@Override
	public int insertMember(MemberVO insertMemberInfo) throws Exception {
		int cnt = 0;
		try {
			Object obj = client.insert("member.insertMember", insertMemberInfo);
			if(obj == null){
				cnt = 1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cnt; 
	}

	@Override
	public String totalCount(Map<String, String> parmas) throws Exception {
		return (String) client.queryForObject("member.totalCount", parmas);
	}

}
