package ouwy.springWork;

import org.springframework.beans.factory.annotation.Autowired;

public class Student2 {

    @Autowired
    private Action action;

    public void action() {
    	action.run();
    }
}
