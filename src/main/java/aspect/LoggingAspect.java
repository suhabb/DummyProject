package aspect;


import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class LoggingAspect {
	
	public static Log LOGGER =  LogFactory.getLog(LoggingAspect.class);
	
	@AfterThrowing(pointcut="allLogging()",throwing="exception" )
	public void LoggingAdvice(JoinPoint joinPoint,Exception exception){
		Object[] argArray = joinPoint.getArgs();
		LOGGER.debug("Method Nam e-"+joinPoint.getSignature().getName()+"\n Method Prams-"+Arrays.toString(argArray)+ExceptionUtils.getMessage(exception));
	}
	
	
	@AfterThrowing(pointcut="allAnnotationLogging()",throwing="exception" )
	public void LoggingAdviceAnnotation(JoinPoint joinPoint, Exception exception){
		Object[] argArray = joinPoint.getArgs();
		LOGGER.debug("Method Name-"+joinPoint.getSignature().getName()+"\n Method Prams-"+Arrays.toString(argArray)+ExceptionUtils.getMessage(exception));
	}
	
	@Pointcut("within(application_service..*) || within(controller..*)")
	public void allLogging(){}
	
	@Pointcut("@annotation(annotation.Loggable)")
	public void allAnnotationLogging(){}
	
}
