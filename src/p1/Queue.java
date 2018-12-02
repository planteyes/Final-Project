package p1;
import java.util.Arrays;

class Queue {
	int front;
	int back;
	int back1;
	int capacity, size;
	int id;
	double price;
	String[] array;


	public Queue(int capacity) {
		this.capacity = capacity;
		front = this.size = 0;
		back = capacity - 1;
		array = new String[this.capacity];

	}

	boolean isFull(Queue queue) {
		return (queue.size == queue.capacity);
	}

	boolean isEmpty(Queue queue) {
		return (queue.size == 0);
	}

	String enqueue(String item, double price, int id) {
		if (isFull(this))
			return "//too many queued items ";
		this.back = (this.size + 1) % this.capacity;
		this.price = price;
		this.array[this.back] = "[" +item + ", Price = " + price + ", ID ="+ id + "]" + "\n";
		this.size = this.size + 1;
		//System.out.println(item);
		return item + "has been entered";
	}

	String dequeue() {
		if (isEmpty(this))
			return "The que is empty";
		String item = this.array[this.front];
		this.front = (this.front + 1) % this.capacity;
		this.size = this.size - 1;
		return item;
	}
	
		

	String peekItem() {

		return this.array[this.front];
	}

	
	
	String peekBack() {

		return this.array[this.back];
	}
	


	int size() {
		return this.size;
	}

	String print() {
		return  Arrays.toString(array) ;
	}

}
