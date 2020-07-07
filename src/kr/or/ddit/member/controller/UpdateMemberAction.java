package kr.or.ddit.member.controller;

import sun.print.resources.serviceui;
import kr.or.ddit.member.service.IMemberService;
import kr.or.ddit.member.service.IMemberServiceImpl;
import kr.or.ddit.vo.MemberVO;

import com.opensymphony.xwork2.ModelDriven;

public class UpdateMemberAction implements ModelDriven<MemberVO>{
	private MemberVO memberInfo;
	
	public String execute(){
		// 스트러츠에서는 beanUtils로 받을 수 있지만 beanUtils를 사용하지 않고 struts 방식을 사용한다. 
		IMemberService service = IMemberServiceImpl.getInstance();
		service.updateMemberInfo(this.memberInfo);
		
		return "success";
	}

	@Override
	public MemberVO getModel() {
		//	인터셉터는 선언된 순서를 기초로 실행(순서대로 실행 된다.)
		// 	인터셉터 ModelDriven 역할
		//		클라이언트로부터 전송되는 대량의 쿼리스트링을 VO와 매핑을 하기위해
		//		해당 VO의 인스턴스를 ValueStack에 배치
		// 	인터셉터 params 역할
		//		<action의 default 인터셉터-생략가능)
		//		* 기타 인터셉터와 병행 활용시에는 생략불가 -> 여기서는 생략 불가
		//		ValueStack에 배치된 인스턴스화가 완료되어진 VO를 대상으로
		//		쿼리스트링의 값을 주입
		this.memberInfo = new MemberVO();
		return this.memberInfo;
	}
}
