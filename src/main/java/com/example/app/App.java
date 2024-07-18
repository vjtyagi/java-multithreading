package com.example.app;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws InterruptedException
    {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run(){
                System.out.println("We are now in thread " + Thread.currentThread().getName());
                System.out.println("Current Thread Priority is " + Thread.currentThread().getPriority());
            }
        });
        thread.setName("New Worker Thread");
        thread.setPriority(Thread.MAX_PRIORITY);
        System.out.println("We are in thread: " + Thread.currentThread().getName()+" before starting a new thread");
        thread.start();
        System.out.println("We are in thread: " + Thread.currentThread().getName()+" after  starting a new thread");
        
        // Makes the current thread suspended for specified amount of time
        // This is way to tell os to schedule other threads that might be waiting
        
    }
}
