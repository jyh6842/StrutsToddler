package kr.or.ddit.member.controller;

import java.util.HashMap;
import java.util.Map;

import kr.or.ddit.member.service.IMemberService;
import kr.or.ddit.member.service.IMemberServiceImpl;
import kr.or.ddit.vo.MemberVO;

public class MemberViewAction {
	//	/StrutsToddler/user/member/memberView.do?mem_id=a001
	private String mem_id;
	
	// request.setAttribute("memberInfo", memberInfo); 이렇게 valueStack에 저장됨
	private MemberVO memberInfo;

	public String memberView(){ // 어제는 execute() 를 했음  memberView()를 execute() 대신해서 썻기 때문에 method에 알려줘야 한다. execute()가 기본값이다. member.xml에 알려준다.
		Map<String, String> params = new HashMap<String, String>();
		params.put("mem_id", this.mem_id);
		
		IMemberService service = IMemberServiceImpl.getInstance();
		this.memberInfo = service.memberInfo(params); /*memberInfo view에 전달 되어야 한다. */
		
		return "success";
	}

	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	
	// getter 는
	// request.setAttribute("memberInfo", memberInfo);
	// 이 역할을 한다. 그래서 el 사용 가능

	public MemberVO getMemberInfo() {
		return memberInfo;
	}
	
	
}
