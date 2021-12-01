package cz.vsb.SLI0095_project;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.lang.reflect.Array;
import java.util.Arrays;

@Aspect
@Component
public class LoggingAspect {

    Logger logger = LoggerFactory.getLogger(LoggingAspect.class);


    @Around("execution(* cz.vsb.SLI0095_project.services.*.*(..) )")
    public Object appLogger(ProceedingJoinPoint point) throws Throwable {
        String method = point.getSignature().getName();
        String className = point.getTarget().getClass().toString();
        Object [] argsArray = point.getArgs();
        ObjectMapper mapper = new ObjectMapper();
        logger.info("METHOD INVOKED " + className + " : " + method
              + " ARGUMENTS: " + Arrays.toString(argsArray)
        );
        Object object = point.proceed();
        return object;
    }
}
