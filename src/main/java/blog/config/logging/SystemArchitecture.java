package blog.config.logging;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * Created by alex on 3/29/2015.
 */
//@Aspect
//@Component
public class SystemArchitecture {

    /** Following is the definition for a pointcut to select
     *  all the methods available. So advice will be called
     *  for all the methods.
     */
    private static Logger log = Logger.getLogger(SystemArchitecture.class);
    @Pointcut("within(blog..*)")
    private void selectAll(){}

    @AfterThrowing(pointcut = "selectAll()", throwing = "ex")
    public void AfterThrowingAdvice(Exception ex){
        System.out.println("There has been an exception: " + ex.getStackTrace());
        log.error("error exception", ex);
    }
}
