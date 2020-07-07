package kr.or.ddit.member.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.or.ddit.member.service.IMemberService;
import kr.or.ddit.member.service.IMemberServiceImpl;
import kr.or.ddit.vo.MemberVO;

import com.opensymphony.xwork2.Action;
// import com.opensymphony.xwork2.Action; 이것은 선택 사항임 IAction 과 비슷한 역할을 함
public class MemberListAction implements Action {
	// request.setAttribute("memberList",memberList);
	private List<MemberVO> memberList; // memberList 이름으로 el 접급 가능 왜 가능하지?
	
	@Override
	public String execute() throws Exception {
		IMemberService service = IMemberServiceImpl.getInstance();
		Map<String, String> params = new HashMap<String, String>();
		params.put("startCount", "10");
		params.put("endCount", "1");
		this.memberList = service.memberList(params);
		
		return SUCCESS;
	}

	
	public List<MemberVO> getMemberList() {
		return memberList;
	}

}
