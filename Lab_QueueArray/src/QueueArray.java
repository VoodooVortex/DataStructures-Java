public class QueueArray implements Queue{

    private int count;
    private int front;
    private int back;
    private int max;
    private ArrayList arr_queue;

    public QueueArray(int size){
        max = size;
        count = 0;
        front = 0;
        back = 0;
        arr_queue = new ArrayList(size);
    }

    @Override
    public void enqueue(Object value) {
        if (isFull()) throw new ArrayIndexOutOfBoundsException("is full");
        arr_queue.add(value);
        back++;
        count++;

    }

    @Override
    public Object dequeue() {
        if (isEmpty()) throw new ArrayIndexOutOfBoundsException("is empty");
        Object value = arr_queue.get(front);
        arr_queue.removeIndex(front);
        front++;
        if (front == back) {
            front = back = count = 0;
        }
        return value;
    }

    @Override
    public Object peek() {
        if (isEmpty()) throw new ArrayIndexOutOfBoundsException("is empty");
        return arr_queue.get(front);
    }

    @Override
    public int size() {
        return count;
    }

    @Override
    public void show() {
        arr_queue.show();
    }

    @Override
    public boolean isEmpty() {
        return arr_queue.isEmpty();
    }

    public boolean isFull(){
        return back == max;
    }
}
