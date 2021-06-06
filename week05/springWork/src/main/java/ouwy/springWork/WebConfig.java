package ouwy.springWork;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("ouwy.springWork")
public class WebConfig {

	@Bean
    public Action action() {
        return new Action();
    }
}
