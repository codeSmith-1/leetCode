package com.skilldistillery.datastructures.lists;

public class SinglyLinkedListTest {

	public static void main(String[] args) {
		SinglyLinkedList<String> myList = new SinglyLinkedList<>();
		System.out.println(myList);
		System.out.println(myList.size());
		myList.add("Hello");
		System.out.println(myList);
		System.out.println(myList.size());
		myList.add("cat");
		System.out.println(myList);
		System.out.println(myList.size());
		myList.add("dog");
		System.out.println(myList);
		System.out.println(myList.size());
		
		myList.add(1, "frog");
		System.out.println(myList);
		System.out.println(myList.size());
		
//		String thing = myList.remove(4);
//		System.out.println(thing);
//		System.out.println(myList);
//		System.out.println(myList.size());
		
//		thing = myList.get(13);
//		System.out.println(thing);

	}

}
