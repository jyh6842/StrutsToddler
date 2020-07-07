package kr.or.ddit.member.controller;

import java.util.HashMap;
import java.util.Map;

import kr.or.ddit.member.service.IMemberService;
import kr.or.ddit.member.service.IMemberServiceImpl;

public class MemberDeleteAction {

	private String mem_id;
	
	public String execute(){
		Map<String, String> params = new HashMap<String, String>();
		params.put("mem_id", this.mem_id);
		
		IMemberService service = IMemberServiceImpl.getInstance();
		service.deleteMemberInfo(params);
		
		return "success";
	}

	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}


	
	
}
