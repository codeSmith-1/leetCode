package com.skilldistillery.datastructures.lists;

public class DoublyLinkedList<T> {
	
	private Node<T> first;
	private Node<T> last;
	private int size = 0;

	public int size() {
		return size;
	}

	public void add(T item) {
		Node<T> newNode = new Node<T>(item);
		if (first == null) {
			first = newNode;
		}
		else {
//			Node<T> currNode = first;
//			while (currNode.getNext() != null) {
//				currNode = currNode.getNext();
//			}
			Node<T> currNode = last;
			currNode.setNext(newNode);
			newNode.setPrev(currNode);
			this.last = newNode;
		}
		size++;
	}

	public boolean isEmpty() {
		return first == null;
	}

	public T get(int index) {
		return null;// FIXME
	}

	public T remove(int index) {
		// don't forget to decrement size.
		return null;// FIXME
	}

	public void add(T item, int index) {
		// FIXME
	}

	public void set(T item, int index) {
		// FIXME
	}

	private class Node<T> {
		private T data;
		private Node<T> prev;
		private Node<T> next;

		public Node(T data) {
			super();
			this.data = data;
		}

		public Node<T> getPrev() {
			return prev;
		}

		public void setPrev(Node<T> prev) {
			this.prev = prev;
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
