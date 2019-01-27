package com.fangbo.spring.aop01;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * AOP 的 helloWorld
 * 1. 加入 jar 包
 * com.springsource.net.sf.cglib-2.2.0.jar
 * com.springsource.org.aopalliance-1.0.0.jar
 * com.springsource.org.aspectj.weaver-1.6.8.RELEASE.jar
 * spring-aspects-4.0.0.RELEASE.jar
 *
 * 2. 在 Spring 的配置文件中加入 aop 的命名空间。
 *
 * 3. 基于注解的方式来使用 AOP
 * 3.1 在配置文件中配置自动扫描的包: <context:component-scan base-package="com.atguigu.spring.aop"></context:component-scan>
 * 3.2 加入使 AspjectJ 注解起作用的配置: <aop:aspectj-autoproxy></aop:aspectj-autoproxy>
 * 为匹配的类自动生成动态代理对象.
 *
 * 4. 编写切面类:
 * 4.1 一个一般的 Java 类
 * 4.2 在其中添加要额外实现的功能.
 *
 * 5. 配置切面
 * 5.1 切面必须是 IOC 中的 bean: 实际添加了 @Component 注解
 * 5.2 声明是一个切面: 添加 @Aspect
 * 5.3 声明通知: 即额外加入功能对应的方法.
 * 5.3.1 前置通知: @Before("execution(public int com.atguigu.spring.aop.ArithmeticCalculator.*(int, int))")
 * @Before 表示在目标方法执行之前执行 @Before 标记的方法的方法体.
 * @Before 里面的是切入点表达式:
 *
 * 6. 在通知中访问连接细节: 可以在通知方法中添加 JoinPoint 类型的参数, 从中可以访问到方法的签名和方法的参数.
 *
 * 7. @After 表示后置通知: 在方法执行之后执行的代码.
 */

//通过添加 @Aspect 注解声明一个 bean 是一个切面!
@Aspect
@Component
public class LoggingAspect {
	@Pointcut("execution(* *.*(..))")
	public void declareexpression(){

	}


	@Before("declareexpression()")
	public void beforeMethod(JoinPoint joinPoint){
		String methodName = joinPoint.getSignature().getName();
		Object [] args = joinPoint.getArgs();

		System.out.println("The method " + methodName + " begins with " + Arrays.asList(args));
	}

	@After("declareexpression()")
	public void afterMethod(JoinPoint joinPoint){
		String methodName = joinPoint.getSignature().getName();
		System.out.println("The method " + methodName + " ends");
	}

	@AfterReturning(value = "execution(* com.fangbo.spring.aop01.*.*(..))",
	returning = "result")
	public void afterReturning(JoinPoint joinPoint,Object result){
		String methodName = joinPoint.getSignature().getName();
		System.out.println("The method " + methodName + " ends"+result);
	}

	@AfterThrowing(value = "execution(* com.fangbo.spring.aop01.*.*(..))",
			throwing = "e")
	public void afterThrowing(JoinPoint joinPoint,Exception e){
		String methodName = joinPoint.getSignature().getName();
		System.out.println("The method " + methodName + " ends"+e);
	}
//对于环绕通知来说, 连接点的参数类型必须是 ProceedingJoinPoint .
// 它是 JoinPoint 的子接口, 允许控制何时执行, 是否执行连接点
//	相当于动态代理的全过程
	@Around(value = "execution(* com.fangbo.spring.aop01.*.*(..))")
	public void around(ProceedingJoinPoint joinPoint){
		Object result=null;
		String methodName = joinPoint.getSignature().getName();
		try {
//			前置通知
			System.out.println("The method " + methodName + " begins with " + Arrays.asList(joinPoint.getArgs()));
			result=joinPoint.proceed();
//			返回通知
			System.out.println("The method " + methodName + " fanhui with " + Arrays.asList(joinPoint.getArgs())+result);
		} catch (Throwable throwable) {
			throwable.printStackTrace();
//			异常tongzhi
			System.out.println("Throwable"+throwable);
		}
		System.out.println("后置通知");

	}


}