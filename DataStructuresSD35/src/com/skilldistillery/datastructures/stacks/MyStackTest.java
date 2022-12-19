package com.skilldistillery.datastructures.stacks;

public class MyStackTest {

	public static void main(String[] args) {
		MyStack<String> stack = new MyStack<>();
		System.out.println(stack);
		System.out.println(stack.size());
		
		stack.push("Hello");
		System.out.println(stack);
		System.out.println(stack.size());
		stack.push("cat");
		System.out.println(stack);
		System.out.println(stack.size());
		stack.push("dog");
		System.out.println(stack);
		System.out.println(stack.size());
		stack.push("frog");
		System.out.println(stack);
		System.out.println(stack.size());
		
		String s = stack.pop();
		System.out.println(s);
		System.out.println(stack);
		System.out.println(stack.size());
		

	}

}
