package app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import app.performer.Performer;
import app.performer.exception.PerformerException;

public class Performance {

	public static void main(String[] args) {
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("/beans/idolbeans.xml");
		Performer performer = (Performer) ctx.getBean("duke");
		
		try {
			performer.perform();
		} catch (PerformerException e) {
			e.printStackTrace();
		}
		
	}
	
}
