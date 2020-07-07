package kr.or.ddit.listener;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class CustomServletRequest implements ServletContextAttributeListener,
		ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// HttpServletRequest GC 되기 직전에 전파된느 이벤트 청취자 리스너
		// 언제 사라짐? 서버의 클라이언트 요청에 따른 응답 처리 완료 시 HttpServletRequest 가 GC 된다.
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		// HttpServletRequest가 인스턴스될때마다 전파되는 이벤트 청취자 리스너
		// 클라이언트 요청이 웹 애플리케이션 서버에 전달될때마다 인스턴스화 처리
	}

	@Override
	public void attributeAdded(ServletContextAttributeEvent arg0) {
		// HttpServletRequest.setAttribute(키, 값) 저장시마다 전파되는 이벤트 청취자
	}

	@Override
	public void attributeRemoved(ServletContextAttributeEvent arg0) {
		// HttpServletRequest.removeAttribute(키) 삭제시마다 전파되는 이벤트 청취자

	}

	@Override
	public void attributeReplaced(ServletContextAttributeEvent arg0) {
		// HttpServletRequest.setAttribute(기존 동일키, 상이값) 갱신시마다 전파되는 이벤트 청취자

	}

}
