package handler;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextStoppedEvent;

public class ACStopHandler implements ApplicationListener<ContextStoppedEvent>{

	public void onApplicationEvent(ContextStoppedEvent e) {
		System.out.println("Context Stop");
	}
}