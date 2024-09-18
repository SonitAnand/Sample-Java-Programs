package org.example.sample1;

public class Singleton implements Cloneable {

    private static Singleton instance;

    private Singleton() throws InstantiationException {
        //if (instance != null)
        //throw new InstantiationException("initializing a new object is not allowed");
    }

    public static Singleton getInstance() throws InstantiationException {
        if (instance == null)
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        return instance;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
        //throw new CloneNotSupportedException("cloning this singleton class is not supported");
    }
}
