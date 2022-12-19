package com.skilldistillery.datastructures.lists;

public class SinglyLinkedListNode<T> {

	T data;
	
	SinglyLinkedListNode<T> next;

	public SinglyLinkedListNode(T data) {
		super();
		this.data = data;
	}

	public SinglyLinkedListNode<T> getNext() {
		return next;
	}

	public void setNext(SinglyLinkedListNode<T> next) {
		this.next = next;
	}

	public T getData() {
		return data;
	}

	
}
