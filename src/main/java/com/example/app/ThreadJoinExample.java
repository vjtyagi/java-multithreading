package com.example.app;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreadJoinExample {
	public static void main(String[] args) throws InterruptedException {
		List<Long> inputNumbers = Arrays.asList(10000000L, 3435L, 35435L, 2324L, 4656L, 23L, 2435L, 5566L);
		List<FactorialThread> threads = new ArrayList<>();
		for(long inputNumber: inputNumbers){
			threads.add(new FactorialThread(inputNumber));
		}
		for(Thread thread: threads){
			thread.setDaemon(true);
			thread.start();
		}
		for(Thread thread: threads){
			// This will make the main thread pause for all these threads to finish
			// only when all threads are finished, execution will move to the results loop
			// thread.join call on first thread pauses the mainthread, When first thread returns it call join on the 2nd thread
			// If by that time 2nd thread is already finished(or terminated due to error) thread.join() will return immediately
			thread.join(2000);
		}
		for(int i = 0; i < inputNumbers.size(); i++) {
			FactorialThread thread = threads.get(i);
			if(thread.isFinished()){
				System.out.println("Factorial of " + inputNumbers.get(i) + " is " + thread.getResult());
			} else {
				System.out.println("The calculation for " + inputNumbers.get(i) + " is still in progress");
			}
		}
		return;
	}
}
