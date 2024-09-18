package org.example.sample1;

import java.util.Random;

class RunnableTest implements Runnable
{
	//Shared object to store result 
    private Object result = null;
	@Override
	public void run() 
	{
		Random generator = new Random(); 
        Integer randomNumber = generator.nextInt(5);
        //As run cannot throw any Exception 
        try
        { 
            Thread.sleep(randomNumber * 1000); 
        } 
        catch (InterruptedException e) 
        { 
            e.printStackTrace(); 
        }
        result = randomNumber; 
        //Wake up threads blocked on the get() method 
        synchronized(this) 
        { 
            notifyAll(); 
        }
	}
	public synchronized Object get() throws InterruptedException 
	{ 
	   while (result == null) 
	      wait(); 
	   return result; 
	} 
}

public class RunnableExample 
{
	public static void main(String[] args) throws Exception 
	{
		RunnableTest[] randomnumbertasks = new RunnableTest[5];
		for(int i=0;i<5;i++)
		{
			randomnumbertasks[i] = new RunnableTest();
			Thread t = new Thread(randomnumbertasks[i]);
			t.start();
		}
		for (int i = 0; i < 5; i++) 
            System.out.println(randomnumbertasks[i].get());
	}

}
