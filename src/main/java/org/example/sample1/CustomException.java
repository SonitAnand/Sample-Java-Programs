package org.example.sample1;

class MyException extends Exception {
    private static final long serialVersionUID = 1L;

    public MyException(String s) {
        super(s);
    }
}

public class CustomException {
    public static void main(String[] args) {
        try {
            //Throw an object of user defined exception
            throw new MyException("Error");
        } catch (MyException ex) {
            System.out.println(ex.getMessage());
        }
    }

}
