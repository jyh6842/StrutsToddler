package kr.or.ddit.file.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;

import org.apache.commons.io.FileUtils;

import kr.or.ddit.global.GlobalConstant;
import kr.or.ddit.vo.MemberVO;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ModelDriven;

public class FileAction implements Action, ModelDriven<MemberVO>{
	// interceptor-ref="fileUpload"
	// 클라이언트로부터 전송되는 폼필드(mem_id, mem_pass, mem_name)와 
	// 전송되는 파일을 MultipartRequestWrapper 자원을 활용 가능한 상태로 만든다.
	
	private MemberVO memberInfo;
	private String fileName;
	
	@Override
	public String execute() throws Exception {
//		MultiPartRequestWrapper wrapper = (MultiPartRequestWrapper) ServletActionContext.getRequest(); // ServletActionContext.getRequest(); 멀티파트 요청이나까
//		String mem_id = wrapper.getParameter("mem_id");
//		String mem_pass = wrapper.getParameter("mem_pass");
//		String mem_name = wrapper.getParameter("mem_name");
//		
//		File[] files = wrapper.getFiles("files"); // 보내주는 form에서 input type file의 name인 files를 의미
//		String[] contentTypes = wrapper.getContentTypes("files");
//		String[] fileNames = wrapper.getFileNames("files");
		// 요 위 3줄을 어떻게 넣어줘야 하나? MemberVO에 추가 해주자
		// VO에 추가하면 위의 3줄을 밑에와 같이 사용할 수 있다.
		List<File> files = this.memberInfo.getFiles();
		List<String> contentTypes = this.memberInfo.getFilesContentType();
		List<String> fileNames = this.memberInfo.getFilesFileName();
		
		for(int i=0; i<files.size(); i++){
			File targetFile = files.get(i);
			if (targetFile.length() > 0) { // file size가 0보다 클때(파일이 존재할때)만 동작
				File saveFile = new File(GlobalConstant.FILE_PATH, fileNames.get(i)); // 여기서 서버에 저장되는 부분, 원래 어디서 해야하는데
				
				FileUtils.copyFile(targetFile, saveFile); // 1번째 인자가 원본파일, 2번째 파일이 대상파일에 쓰여지게 되는 것
				this.fileName = fileNames.get(i);
			}
		}
		
		return SUCCESS;
	}

	@Override
	public MemberVO getModel() {
		this.memberInfo = new MemberVO(); // 여기서 값을 넣어주는 건가? Member에 대한 값은 여기서 넣어줌
		return this.memberInfo; // 여기서 넘겨줘야 전역변수에서 사용할 수 있음 setter 역할을 해주는 것
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	private String contentDisposition;
	private long contentLength;
	private InputStream inputStream;
	
	public String getContentDisposition() {
		return contentDisposition;
	}
	
	public long getContentLength() {
		return contentLength;
	}
	
	public InputStream getInputStream() {
		return inputStream;
	}
	
	public String fileDownload(){
		File downloadFile = new File(GlobalConstant.FILE_PATH, this.fileName);
		this.contentDisposition = "attachment;fileName=" + this.fileName;
		this.contentLength = downloadFile.length();
		
		try {
			this.inputStream = new FileInputStream(downloadFile);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		return "success";
	}
	
	
	
}
