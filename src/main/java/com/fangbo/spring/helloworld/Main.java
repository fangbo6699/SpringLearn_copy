package com.fangbo.spring.helloworld;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class Main {

    public static        void main(String[] args) {

//		HelloWorld helloWorld = new HelloWorld();
//		helloWorld.setUser("Tom");
//		helloWorld.hello();

        //1. 创建 Spring 的 IOC 容器
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("file:D:\\Development_Tool\\Java\\IntelliJ IDEA 2018.3.2\\workstations\\SpringLearn\\src\\beans.xml");
        //2. 从 IOC 容器中获取 bean 的实例
        HelloWorld helloWorld = (HelloWorld) ctx.getBean("helloWorld");
        //HelloWorld helloWorld2= ctx.getBean(HelloWorld.class);

        //根据类型来获取 bean 的实例: 要求在  IOC 容器中只有一个与之类型匹配的 bean, 若有多个则会抛出异常.
        //一般情况下, 该方法可用, 因为一般情况下, 在一个 IOC 容器中一个类型对应的 bean 也只有一个.
        //HelloWorld helloWorld1 = ctx.getBean(HelloWorld.class);

        //3. 使用 bean
        helloWorld.hello();

		Car car = (Car) ctx.getBean("car");
		System.out.println(car);
//
		Car car2 = (Car) ctx.getBean("car2");
		System.out.println(car2);

		Person person= (Person) ctx.getBean("person");
        System.out.println(person);

        Person person1=(Person)ctx.getBean("person1");
        System.out.println(person1);


        Person person4=(Person)ctx.getBean("person4");
        System.out.println(person4);

//
//		//4. 测试使用集合属性
//		User user = (User) ctx.getBean("user5");
//		System.out.println(user);
    }

}
