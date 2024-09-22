package assignment5.ListInterface_Queue;

class DequeNode<T> {
    T value;
    DequeNode<T> next;
    DequeNode<T> prev;

    public DequeNode(T value) {
        this.value = value;
    }
}

class Deque<T> {
    private DequeNode<T> front;
    private DequeNode<T> rear;
    private int size;

    public Deque() {
        front = null;
        rear = null;
        size = 0;
    }

    public void addFront(T value) {
        DequeNode<T> newNode = new DequeNode<>(value);
        if (isEmpty()) {
            front = rear = newNode;
        } else {
            newNode.next = front;
            front.prev = newNode;
            front = newNode;
        }
        size++;
    }

    public void addRear(T value) {
        DequeNode<T> newNode = new DequeNode<>(value);
        if (isEmpty()) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            newNode.prev = rear;
            rear = newNode;
        }
        size++;
    }

    public T removeFront() {
        if (isEmpty()) {
            throw new IllegalStateException("Deque is empty");
        }
        T value = front.value;
        front = front.next;
        if (front != null) {
            front.prev = null;
        } else {
            rear = null;
        }
        size--;
        return value;
    }

    public T removeRear() {
        if (isEmpty()) {
            throw new IllegalStateException("Deque is empty");
        }
        T value = rear.value;
        rear = rear.prev;
        if (rear != null) {
            rear.next = null;
        } else {
            front = null;
        }
        size--;
        return value;
    }

    public T peekFront() {
        if (isEmpty()) {
            throw new IllegalStateException("Deque is empty");
        }
        return front.value;
    }

    public T peekRear() {
        if (isEmpty()) {
            throw new IllegalStateException("Deque is empty");
        }
        return rear.value;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }
}

public class Program10 {
    public static void main(String[] args) {
        Deque<Integer> deque = new Deque<>();
        deque.addFront(1);
        deque.addRear(2);
        deque.addFront(3);
        deque.addRear(4);

        System.out.println(deque.removeFront()); 
        System.out.println(deque.removeRear());  
        System.out.println(deque.peekFront());    
        System.out.println(deque.peekRear());     
        System.out.println(deque.size());         
    }
}
