package handler;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextStartedEvent;

public class ACStartHandler implements ApplicationListener<ContextStartedEvent>{

	public void onApplicationEvent(ContextStartedEvent e) {
		System.out.println("Context Start");
	}
}
