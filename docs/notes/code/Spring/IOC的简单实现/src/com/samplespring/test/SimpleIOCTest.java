package com.samplespring.test;


import com.samplespring.entity.Car;
import com.samplespring.entity.Wheel;
import com.samplespring.util.SimpleIOC;

import java.net.URLDecoder;

public class SimpleIOCTest {
    public static void main(String[] args) throws Exception {
        String location = SimpleIOC.class.getClassLoader().getResource("ioc.xml").getFile();
        location = URLDecoder.decode(location, "utf-8");
        SimpleIOC beanFactory = new SimpleIOC(location);
        Wheel wheel = (Wheel) beanFactory.getBean("wheel");
        System.out.println(wheel);

        Car car = (Car) beanFactory.getBean("car");
        System.out.println(car);
    }
}
