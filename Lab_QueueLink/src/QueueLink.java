public class QueueLink implements Queue{
    private int count;
    private DoublyLinkedList link_queue;

    public QueueLink(){
        count = 0;
        link_queue = new DoublyLinkedList();
    }

    @Override
    public void enqueue(Object value) {
        link_queue.add(value);
        count++;
    }

    @Override
    public Object dequeue() {
        if (isEmpty()) throw new RuntimeException("is empty");
        Object value = link_queue.get(0);
        link_queue.removeIndex(0);
        count--;
        return value;
    }

    @Override
    public Object peek() {
        if (isEmpty()) throw new RuntimeException("is empty");
        return link_queue.get(0);
    }

    @Override
    public int size() {
        return count;
    }

    @Override
    public void show() {
        link_queue.show();
    }

    @Override
    public boolean isEmpty() {
        return link_queue.isEmpty();
    }
}
