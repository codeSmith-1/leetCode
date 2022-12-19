package com.skilldistillery.datastructures.queue;

import java.util.NoSuchElementException;

public class MyQueue<T> {

	private Node<T> head;
	private Node<T> tail;
	private int size = 0;
	private int MAX_SIZE = 10;

	public boolean isEmpty() {
		return head == null;
	}
	
	public int size() {
		return this.size;
	}

	public void add(T item) {
		if (this.size == MAX_SIZE) {
			throw new IllegalArgumentException();
		}
		Node<T> newNode = new Node<T>(item);
		if (head == null) {
			head = tail = newNode;
		}
		else {
			tail.setNext(newNode);
			tail = newNode;
		}
		size++;
	}
	
	public boolean offer(T item) {
		if (this.size == MAX_SIZE) {
			return false;
		}
		Node<T> newNode = new Node<T>(item);
		if (head == null) {
			head = tail = newNode;
		}
		else {
			tail.setNext(newNode);
			tail = newNode;
		}
		size++;
		return true;
	}
	
	public T remove() {
		if (head == null) {
			throw new NoSuchElementException();
		}
		T item = head.getData();
		head = head.getNext();
		return item;
	}
	
	public T peek() {
		return null;//FIXME
	}
	
	
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("::HEAD:: ");
		Node<T> currNode = head;
		while (currNode != null) {
			builder.append(currNode.getData());
			if (currNode.getNext() != null) {
				builder.append(" ");
			}
			currNode = currNode.getNext();
		}
		builder.append(" ::TAIL::");
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
