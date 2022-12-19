package com.skilldistillery.datastructures.queue;

import java.util.Queue;

public class MyQueueTest {

	public static void main(String[] args) {
		Queue qq;
		MyQueue<String> q = new MyQueue<>();
		System.out.println(q);
		System.out.println(q.size());
		
		q.add("Hello");
		System.out.println(q);
		System.out.println(q.size());
		q.add("cat");
		System.out.println(q);
		System.out.println(q.size());
		q.add("dog");
		System.out.println(q);
		System.out.println(q.size());
		q.add("frog");
		System.out.println(q);
		System.out.println(q.size());
		
		String s = q.remove();
		System.out.println(s);
		System.out.println(q);
		System.out.println(q.size());

		q.add("giraffe");
		System.out.println(q);
		System.out.println(q.size());
	}

}
