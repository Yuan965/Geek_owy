package ouwy.springWork;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Student {

	@Autowired
	private Action action;
	
    public void action() {
    	action.jump();
    }
}
