package app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import app.performer.Performer;
import app.performer.exception.PerformerException;

public class Performance {

	public static void main(String[] args) {

		ApplicationContext ctx = new ClassPathXmlApplicationContext("/beans/idolbeans.xml");
		Performer performer = (Performer) ctx.getBean("poeticDuke");
		Performer performer1 = (Performer) ctx.getBean("duke");
		Performer performer2 = (Performer) ctx.getBean("duke1");
		Performer performer3 = (Performer) ctx.getBean("duke2");
		Performer kenny = (Performer) ctx.getBean("kenny");

		try {
			performer.perform();
			performer1.perform();
			performer2.perform();
			performer3.perform();
			kenny.perform();
		} catch (PerformerException e) {
			e.printStackTrace();
		}

	}

}
