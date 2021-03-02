package com.cisco.prj.client;

@FunctionalInterface
interface Computation {
	int compute(int x, int y);
}

public class LambdaExample {

	public static void main(String[] args) {
		// using Anonymous class
		doTask(new Computation() {
			@Override
			public int compute(int x, int y) {
				return x + y;
			}
		});
		
		doTask((int x, int y) -> {
				return x - y;
			});
		
		// Type inference
		doTask( (x, y) -> x * y); // doTask accepts compute function
	}

	public static void doTask(Computation comp) {
		int x = 10;
		int y = 3;
		System.out.println(comp.compute(x, y));
	}
}
