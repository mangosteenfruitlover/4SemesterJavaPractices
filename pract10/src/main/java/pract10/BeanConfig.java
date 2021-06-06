package pract10;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pract10.programmer.Junior;
import pract10.programmer.Middle;
import pract10.programmer.Programmer;
import pract10.programmer.Senior;

@Configuration
public class BeanConfig {
    @Bean
    public Programmer middle(){
        return new Middle();
    }

    @Bean
    public Programmer senior(){
        return new Senior();
    }

    @Bean
    public Programmer junior(){
        return new Junior();
    }
}
