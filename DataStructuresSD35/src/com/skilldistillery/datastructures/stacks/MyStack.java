package com.skilldistillery.datastructures.stacks;

import java.util.NoSuchElementException;

public class MyStack<T> {
	
	private Node<T> top;
	private int size = 0;
	
	public void push(T item) {
		Node<T> newNode = new Node<>(item);
		if ( top == null) {
			top = newNode;
		}
		else {
			newNode.setNext(top);
			top = newNode;
		}
		size++;
	}
	
	public T pop() {
		if (isEmpty()) {
			throw new NoSuchElementException();
		}
		T item = top.getData();
		top = top.getNext();
		size--;
		return item;
	}
	
	public T peek() {
		return null;//FIXME
	}
	
	public boolean isEmpty() {
		return top == null;
	}
	
	public int size() {
		return this.size;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("==TOP==\n");
		Node<T> currNode = top;
		while (currNode != null) {
			builder.append(currNode.getData()).append("\n");
			currNode = currNode.getNext();
		}
		builder.append("==BOTTOM==");
		return builder.toString();
	}



	private class Node<T> {
		private T data;
		private Node<T> next;

		public Node(T data) {
			super();
			this.data = data;
		}

		public Node<T> getNext() {
			return next;
		}

		public void setNext(Node<T> next) {
			this.next = next;
		}

		public T getData() {
			return data;
		}

	}

}
