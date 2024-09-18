package org.example.sample2;

@FunctionalInterface
interface DefaultInterface {
    // static method
    static void hello2() {
        System.out.println("Hello 2, New Static Method Here");
    }

    static void hello4() {
        System.out.println("Hello 4, New Static Method Here");
    }

    // abstract method
    public void square(int a);

    //default method
    default void hello1() {
        System.out.println("Hello 1, New Default Method Here");
    }

    default void hello3() {
        System.out.println("Hello 3, New Default Method Here");
    }
}

public class DefaultStaticMethod implements DefaultInterface {
    public static void main(String[] args) {
        DefaultStaticMethod method = new DefaultStaticMethod();
        method.square(2);
        method.square(4);
        DefaultInterface.hello2();
        DefaultInterface.hello4();
        method.hello1();
        method.hello3();
    }

    // implementation of square abstract method
    public void square(int a) {
        System.out.println(a * a);
    }

    //overridden default method
    public void hello1() {
        System.out.println("Hello 1, New Default Method Here Overridden");
    }

}
