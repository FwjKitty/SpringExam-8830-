package service;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class FilmServiceAspect {

	@Before("execution(* service.impl.FilmServiceImpl.save(*))")
	public void SaveInit() {
		System.out.println("Before Insert Film Data");
	}
	@After("execution(* service.impl.FilmServiceImpl.save(*))")
	public void SaveDestory() {
		System.out.println("After Insert Film Data");
	}
}