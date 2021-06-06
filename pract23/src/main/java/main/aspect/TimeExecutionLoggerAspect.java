package main.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class TimeExecutionLoggerAspect {
    private long start;

    @Before("allServiceMethods()")
    public void getStartTime() {
        start = System.currentTimeMillis();
    }

    @After("allServiceMethods()")
    public void logExecutionTime() {
        long end = System.currentTimeMillis();
        System.out.println("Service method execution time: ms" + String.valueOf(end - start));
    }

    @Pointcut("within(main.services.*)")
    public void allServiceMethods() {}
}
