package aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class FilmServiceAspect {
	
	@Pointcut("execution(* service.impl.FilmServiceImpl.save(*))")
	public void savePointcut(){}

	@Before("savePointcut()")
	public void SaveInit() {
		System.out.println("Before Insert Film Data");
	}
	@After("savePointcut()")
	public void SaveDestory() {
		System.out.println("After Insert Film Data");
	}
}