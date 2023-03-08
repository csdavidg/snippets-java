package com.example.snippets.cglibproxy;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class ConcreteClassProxy implements MethodInterceptor {

    final private ConcreteClass concreteClass;

    public ConcreteClassProxy(ConcreteClass concreteClass) {
        this.concreteClass = concreteClass;
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("Before " + method.getName());
        Object result = method.invoke(concreteClass, objects);
        System.out.println("After " + method.getName());
        return result;
    }

    public ConcreteClass getConcreteClassUsingProxy() {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(ConcreteClass.class);
        enhancer.setCallback(this);
        return (ConcreteClass) enhancer.create();
    }
}
