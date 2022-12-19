package com.skilldistillery.datastructures.lists;

public class SinglyLinkedList<T> {

	// reference type defaults to null
	private SinglyLinkedListNode<T> first;
	private int size = 0;

	public void add(T item) {
		SinglyLinkedListNode<T> newNode = new SinglyLinkedListNode<T>(item);
		if (first == null) {
			first = newNode;
		} else {
			SinglyLinkedListNode<T> currNode = first;
			while (currNode.getNext() != null) {
				currNode = currNode.getNext();
			}
			currNode.setNext(newNode);
		}
		size++;
	}

	public T get(int index) {
		if (this.isEmpty() || index < 0 || index >= this.size()) {
			throw new IndexOutOfBoundsException(index);
		}
		int i = 0;
		SinglyLinkedListNode<T> currNode = first;
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
		return false; // FIXME
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
		return this.size; // FIXME
	}

	public void add(int index, T item) {
		// FIXME
	}

	public void set(int index, T item) {
		// FIXME
	}

	@Override
	public String toString() {
		return "SinglyLinkedList [first=" + first.getData() + "]";
	}

	

}
