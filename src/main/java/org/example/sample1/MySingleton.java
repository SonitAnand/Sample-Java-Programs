package org.example.sample1;

class Singleton1 {
    //static variable single_instance of type MySingleton
    private static Singleton1 single_instance = null;

    //variable of type String
    public String name;

    //private constructor restricted to this class itself
    private Singleton1() {
        name = "Singleton Class";
    }

    //static method to create instance of MySingleton
    public static Singleton1 getInstance() {
        if (single_instance == null) {
            synchronized (Singleton.class) {
                if (single_instance == null)
                    single_instance = new Singleton1();
            }
        }
        return single_instance;
    }
}

//Driver Class
class MySingleton {
    public static void main(String args[]) {
        Singleton1 sin = Singleton1.getInstance();
        Singleton1 ton = Singleton1.getInstance();

        System.out.println(sin.name);
        System.out.println(ton.name);
    }
}