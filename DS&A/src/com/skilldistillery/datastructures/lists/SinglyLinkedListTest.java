package com.skilldistillery.datastructures.lists;

public class SinglyLinkedListTest {
		
	public static void main(String[] args) {
		SinglyLinkedList<String> myList = new SinglyLinkedList<>();
		myList.add("Hello");
		System.out.println(myList);
		myList.add("Cat");
		System.out.println(myList);
		myList.add("dog");
		System.out.println(myList);
		myList.add("frog");
		System.out.println(myList);
		myList.add("giraffe");
	
		
		String thing = myList.get(3);
		System.out.println(thing);
//		
//		String thing2 = myList.get(13);
//		System.out.println(thing);
		
		String removed = myList.remove(3);
		System.out.println(removed);
//		
		
		
		System.out.println(myList.size());
	}
	
	
	
}
