package kr.or.ddit.member.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.member.service.IMemberService;
import kr.or.ddit.member.service.IMemberServiceImpl;
import kr.or.ddit.vo.MemberVO;

import org.apache.struts2.ServletActionContext;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

public class IDCheckAction {
	private String mem_id;
	
	/*아작스 할때 void 반환*/
	public void execute(){
		Map<String, String> params = new HashMap<String, String>();
		params.put("mem_id", this.mem_id);
		
		IMemberService service = IMemberServiceImpl.getInstance();
		MemberVO memberInfo = service.memberInfo(params);
		
		Map<String, String> jsonMap = new HashMap<String, String>();
		if(memberInfo == null){
			jsonMap.put("flag", "true");
		}else{
			jsonMap.put("flag", "false");
		}
		
		ObjectMapper mapper = new ObjectMapper();
		try {
			String jsonData = mapper.writeValueAsString(jsonMap);
			
			/*void 이니까 여기서 직접 출력 버퍼에 저장 해줘야한다.*/
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setCharacterEncoding("UTF-8");
			response.setContentType("application/json; charset=UTF-8");
			
			PrintWriter out = response.getWriter();
			out.println(jsonData);
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	
	
}
