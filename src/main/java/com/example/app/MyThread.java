package com.example.app;

public class MyThread {
	public static void main(String[] args) throws InterruptedException {
		Thread thread = new Thread(new Runnable(){
			@Override
			public void run(){
				throw new RuntimeException("Intentional Exception");
			}
		});
		thread.setName("Misbehaving thread");
		
		//Catch uncaught exceptions from thread
		
		thread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
			@Override
			public void uncaughtException(Thread t, Throwable e){
				System.out.println("A critical error happended in thread " + t.getName() + " the error is "+ e.getMessage());
			}
		});
		
		thread.start();
	}
}
