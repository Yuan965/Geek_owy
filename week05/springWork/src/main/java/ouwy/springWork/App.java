package ouwy.springWork;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
	@SuppressWarnings("resource")
	public static void main( String[] args ){
    	ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
    	Action ac = (Action) applicationContext.getBean("action");
    	ac.jump();
    }
}
