package com.example.config;

/**
 * Created by Administrator on 2016/7/13.
 */
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;


@Aspect
@Order(-1)// 保证该AOP在@Transactional之前执行
@Configuration
public class DataSourceAspectConfig {

    @Bean
    public DataSourceAspect dataSourceAspect() {
        return new DataSourceAspect();
    }

    @Pointcut("execution(* com.example.service.*.*(..)))")
    public void doService() {
    }

    @Before("doService()")
    public void before(JoinPoint joinPoint) {
        dataSourceAspect().before(joinPoint);
    }

    @Around("doService()")
    public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
        return dataSourceAspect().doAround(pjp);
    }

    @After("doService()")
    public void doAfter(JoinPoint jp) {
        dataSourceAspect().doAfter(jp);
    }

}
