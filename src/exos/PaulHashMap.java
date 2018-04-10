package exos;

import java.util.LinkedList;

public class PaulHashMap<K, V> {

	private LinkedList<PaulHashMapElement>[] elements;
	private int size, maxSize;

	public PaulHashMap() {
		this.maxSize = 10;
		this.elements = new LinkedList[this.maxSize];
		this.size = 0;
	}

	public void put(K key, V value) {
		PaulHashMapElement<K, V> element = new PaulHashMapElement<K, V>(key, value);
		if (this.size >= this.maxSize) {
			this.resize();
		}
		this.putOnArray(element, this.elements);
		this.size++;
	}
	
	private void putOnArray(PaulHashMapElement newElement, LinkedList<PaulHashMapElement>[] elements) {
		int index = this.hash((K) newElement.key);
		if (elements[index] == null) {
			elements[index] = new LinkedList<PaulHashMapElement>();	
		}
		for (PaulHashMapElement element: elements[index]) {
			if (element.key == newElement.key) {
				elements[index].remove(element);
			}
		}
		elements[index].add(newElement);
	}
	
	public V get(K key){
		LinkedList<PaulHashMapElement> list;
		list = this.elements[this.hash(key)];
		if (list == null)
			return null;
		for (PaulHashMapElement element: list) {
			if (element.key == key)
				return (V) element.value;
		}
		return null;
	}
	
	private void resize(){
		int newSize = this.maxSize * 2;
		LinkedList<PaulHashMapElement>[] newElements;
		newElements = new LinkedList[newSize];
		for (LinkedList<PaulHashMapElement> list: this.elements){
			for (PaulHashMapElement element: list) {
				this.putOnArray(element, newElements);
			}
		}
		this.elements = newElements;
		this.maxSize = newSize;
	}
	
	private int hash(K key){
		return this.hash(key, this.maxSize);
	}
	
	private int hash(K key, int size){
		return key.hashCode() % size;
	}

}
