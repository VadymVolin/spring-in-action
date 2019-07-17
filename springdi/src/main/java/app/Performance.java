package app;

import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import app.habuma.cities.City;
import app.habuma.cities.CityList;
import app.habuma.cities.CityState;
import app.performer.Performer;
import app.performer.exception.PerformerException;

public class Performance {

	public static void main(String[] args) {

//		Main Container like a BeanFactory who have a lot of opportunities
		ApplicationContext ctx = new ClassPathXmlApplicationContext("/beans/idolbeans.xml");
		
//		poets/juggler
		Performer performer = (Performer) ctx.getBean("poeticDuke");
		Performer performer1 = (Performer) ctx.getBean("duke");
		Performer performer2 = (Performer) ctx.getBean("duke1");
		Performer performer3 = (Performer) ctx.getBean("duke2");
		
//		musician
		Performer kenny = (Performer) ctx.getBean("kenny");
		Performer david = (Performer) ctx.getBean("david");
		Performer frank = (Performer) ctx.getBean("frank");
		Performer carl = (Performer) ctx.getBean("carl");
		Performer stevie = (Performer) ctx.getBean("stevie");
		
//		magician
		Performer harry = (Performer) ctx.getBean("harry");
		
		
//		CityList c = (CityList) ctx.getBean("cityList");
////		
//		for (String city : c.getLists()) {
//			System.out.println(city);
//		}
		try {
			
//			performer.perform();
//			performer1.perform();
//			performer2.perform();
//			performer3.perform();
			kenny.perform();
			david.perform();
			frank.perform();
			carl.perform();
			stevie.perform();
			
			harry.perform();
		} catch (PerformerException e) {
			e.printStackTrace();
		}

	}

}
