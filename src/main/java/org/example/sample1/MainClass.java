package org.example.sample1;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class MainClass {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, CloneNotSupportedException {

        Singleton singleton1 = Singleton.getInstance();
        Singleton singleton2 = Singleton.getInstance();

        System.out.println(singleton1.hashCode());
        System.out.println(singleton2.hashCode());

        //use reflection to break singleton
        Class<?> refClass = Class.forName("com.radeon.Singleton");
        Constructor<Singleton> constructor = (Constructor<Singleton>) refClass.getDeclaredConstructor();
        constructor.setAccessible(true);
        Singleton singleton3 = constructor.newInstance();
        System.out.println(singleton3.hashCode());

        //use cloneable to break singleton
        Singleton singleton4 = (Singleton) singleton1.clone();
        System.out.println(singleton4.hashCode());
    }
}
