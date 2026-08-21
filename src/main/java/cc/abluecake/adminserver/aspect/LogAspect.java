package cc.abluecake.adminserver.aspect;

import cc.abluecake.adminserver.common.Result;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LogAspect {
//    @Before("execution(* cc.abluecake.adminserver.controller.UserController.*(..))")
//    public void before(){
//        System.out.println("开始打印日志");
//    }

    @Around("execution(* cc.abluecake.adminserver.controller.UserController.*(..))")
    public Result around(ProceedingJoinPoint joinPoint){
        System.out.println("在方法执行之前");
        try {
            Result result =(Result) joinPoint.proceed();
            System.out.println(result.toString());
            System.out.println("在方法执行之后");
            return result;
        }catch (Throwable e){
            throw  new RuntimeException(e);
        }
    }
}
