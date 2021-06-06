package pract10;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import pract10.programmer.Junior;
import pract10.programmer.Middle;
import pract10.programmer.Programmer;
import pract10.programmer.Senior;

@SpringBootApplication
public class Application {
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(BeanConfig.class);
		Programmer programmer = context.getBean(Senior.class);
		programmer.doCoding();

		programmer = context.getBean(Junior.class);
		programmer.doCoding();

		programmer = context.getBean(Middle.class);
		programmer.doCoding();
	}
}
