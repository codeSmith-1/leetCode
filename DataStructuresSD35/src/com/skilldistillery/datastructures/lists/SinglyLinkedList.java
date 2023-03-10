package com.skilldistillery.datastructures.lists;

public class SinglyLinkedList<T> {
	
	private SinglyLinkedListNode<T> first;
	private int size = 0;
	
	public void add(int index, T item) {
		SinglyLinkedListNode<T> newNode = new SinglyLinkedListNode<T>(item);
		if (first == null) {
			first = newNode;
		}
		int count = 0;
		SinglyLinkedListNode<T> currNode = first;
		SinglyLinkedListNode<T> prev = first;
		while(count < index) {
			prev = currNode;
			currNode = first.getNext();
			count++;
		}
		prev.setNext(newNode);
		newNode.setNext(currNode);
		size++;
	}

	public void set(int index, T item) {
		SinglyLinkedListNode<T> newNode = new SinglyLinkedListNode<T>(item);
		if (first == null) {
			first = newNode;
		}
		if (this.get(index) == null) {
			System.out.println("Index does not exist, check size.");
		}
		
	}

	
	public void add(T item) {
		SinglyLinkedListNode<T> newNode = new SinglyLinkedListNode<T>(item);
		if (first == null) {
			first = newNode;
		}
		else {
			SinglyLinkedListNode<T> currNode = first;
			while (currNode.getNext() != null) {
				currNode = currNode.getNext();
			}
			currNode.setNext(newNode);
		}
		size++;
	}
	
	public T get(int index) {
		if (this.isEmpty() || index < 0 || index >= size()) {
			throw new IndexOutOfBoundsException(index);
		}
		int i = 0;
		SinglyLinkedListNode<T> currNode = first;
		while (currNode.getNext() != null && i < index) {
			currNode = currNode.getNext();
			i++;
		}
		return currNode.getData(); //FIXME
	}
	
	public T remove(int index) {
		if (this.isEmpty() || index < 0 || index >= size()) {
			throw new IndexOutOfBoundsException(index);
		}
		int i = 0;
		SinglyLinkedListNode<T> currNode = first;
		while (currNode.getNext() != null && i < index - 1) {
			currNode = currNode.getNext();
			i++;
		}
		T item = currNode.getNext().getData();
		currNode.setNext(currNode.getNext().getNext());
		this.size--;
		return item;
	}
	
	public boolean isEmpty() {
		return first == null;
	}
	
	public int size() {
//		if (isEmpty()) {
//			return 0;
//		}
//		int size = 0;
//		SinglyLinkedListNode<T> currNode = first;
//		while (currNode != null) {
//			currNode = currNode.getNext();
//			size++;
//		}
		return this.size;
	}
	
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("[");
		SinglyLinkedListNode<T> currNode = first;
		while (currNode != null) {
			builder.append(currNode.getData());
			if (currNode.getNext() != null) {
				builder.append(", ");
			}
			currNode = currNode.getNext();
		}
		builder.append("]");
		return builder.toString();
	}
	
}
