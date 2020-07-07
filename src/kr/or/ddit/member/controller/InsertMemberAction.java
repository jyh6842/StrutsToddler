package kr.or.ddit.member.controller;

import kr.or.ddit.member.service.IMemberService;
import kr.or.ddit.member.service.IMemberServiceImpl;
import kr.or.ddit.vo.MemberVO;

import com.opensymphony.xwork2.ModelDriven;

public class InsertMemberAction implements ModelDriven<MemberVO>{ // modelDriven 은 setter getter이 필요 없다.
	private MemberVO memberInfo;
	
	public String execute(){
		// 스트러츠에서는 beanUtils로 받을 수 있지만 beanUtils를 사용하지 않고 struts 방식을 사용한다.
		IMemberService service = IMemberServiceImpl.getInstance();
		service.insertMember(this.memberInfo); // setter 가 필요 없이 주입된다. modelDriven 이걸 implements 받아서
		
		return "success";
	}
	
	@Override
	public MemberVO getModel() {
		this.memberInfo = new MemberVO();
		return this.memberInfo;
	}

}
