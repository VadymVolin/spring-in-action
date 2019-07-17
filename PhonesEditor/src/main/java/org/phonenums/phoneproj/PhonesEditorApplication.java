package org.phonenums.phoneproj;

import org.phonenums.phoneproj.contact.Contact;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class PhonesEditorApplication {

    public static void main(String[] args) {
        SpringApplication.run(PhonesEditorApplication.class, args);
        ApplicationContext ctx = new ClassPathXmlApplicationContext("phoneEdit.xml");
        Contact contact = (Contact) ctx.getBean("contact");
        Contact contactNew = (Contact) ctx.getBean("contactNew");
        System.out.println(contact.getNumber());
        System.out.println(contactNew.getNumber());
    }

}
