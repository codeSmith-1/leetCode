package com.skilldistillery.datastructures.lists;

import java.util.LinkedList;

public class DoublyLinkedListTest {

	public static void main(String[] args) {
		
		LinkedList<String> l;
		
		DoublyLinkedList<String> myList = new DoublyLinkedList<>();
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
		myList.add("frog");
		System.out.println(myList);
		System.out.println(myList.size());
		myList.add("giraffe");
		System.out.println(myList);
		System.out.println(myList.size());
		
		String thing = myList.remove(4);
		System.out.println(thing);
		System.out.println(myList);
		System.out.println(myList.size());
		

	}

}
