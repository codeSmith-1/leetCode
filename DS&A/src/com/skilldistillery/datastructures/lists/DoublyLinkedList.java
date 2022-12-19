package com.skilldistillery.datastructures.lists;

public class DoublyLinkedList<T> {

	private Node<T> first;
	private Node<T> last;
	private int size = 0;

	public int size() {
		return size; // FIXME
	}

	public void add(T item) {
		Node<T> newNode = new Node<T>(item);
		if (first == null) {
			first = newNode;
		} else {
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

	public void add(T item, int idx) {
	}

	public void set(T item, int idx) {

	}

	public boolean isEmpty() {
		return first == null; // FIXME
	}

	public T get(int index) {
		if (this.isEmpty() || index < 0 || index >= this.size()) {
			throw new IndexOutOfBoundsException(index);
		}
		int i = 0;
		Node<T> currNode = first;
		while (currNode.getNext() != null && i < index) {
			currNode = currNode.getNext();
			i++;
		}
		return currNode.getData();
	}

	public T remove(int index) {
		if (this.isEmpty() || index < 0 || index >= this.size()) {
			throw new IndexOutOfBoundsException(index);
		}
		int i = 0;
		Node<T> currNode = first;

		while (currNode.getNext() != null && i < index - 1) {
			currNode = currNode.getNext();
			i++;
		}
		T item = currNode.getNext().getData();
		currNode.setNext(currNode.getNext().getNext());
		this.size--;
		return item;
	}

	private class Node<T> {
		private T data;
		private Node<T> prev;
		private Node<T> next;

		public T getData() {
			return data;
		}

		public void setData(T data) {
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

		public Node(T data) {
			super();
			this.data = data;
		}

		@Override
		public String toString() {
			return "Node [data=" + data + "]";
		}

	}

}
