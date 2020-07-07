package kr.or.ddit.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import kr.or.ddit.utiles.Log4jInitialize;

public class Log4jInitializeListener implements
		ServletContextAttributeListener, ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent arg0) { // 어플리케이션 돌때 만들어짐
		System.out.println("Application(ServletContext) 최초 인스턴스시 전파되는 이벤트 청취자 콜백 리스너");
		
		Log4jInitialize.init();// log4j 쓸수 있또록 여기 에 넣는다.
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent arg0) { // 어플리케이션이  가비지 컬렉터에 의해서 ServletContextEvent
		System.out.println("Application(ServletContext) GC되기 직전 전파되는 이벤트 청취자 콜백 리스너");
	}

	@Override
	public void attributeAdded(ServletContextAttributeEvent event) { // ServletContextAttributeEvent 이걸 파라미터로 받음
		System.out.println("application.setAttribute(키, 값) 저장시 전파되는 이벤트 청취자 리스너");
		ServletContext application = event.getServletContext();
		
		// application.setAttribute(키, 값)
		String key = event.getName();
		Object value = event.getValue();
		
		
	}

	@Override
	public void attributeRemoved(ServletContextAttributeEvent arg0) {
		System.out.println("application.removeAttribute(키) 삭제시 전파되는 이벤트 청취자 리스너");
	}

	@Override
	public void attributeReplaced(ServletContextAttributeEvent arg0) {
		System.out.println("application.setAttribute(기존 동일키, 상이값) 갱신시 전파되는 이벤트 청취자 리스너");

	}

}
