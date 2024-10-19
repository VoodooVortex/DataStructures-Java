public class StackLink implements Stack{

    private DoublyLinkedList top;
    private int count;

    public StackLink(){
        top = new DoublyLinkedList();
        count = -1;//0 หรือ -1 ก็ได้
    }

    @Override
    public void push(Object value) {
        top.add(value);
        count++;
    }

    @Override
    public Object pop() {
        Object current;
        if (isEmpty()){
            throw new RuntimeException("is empty");
        }else {
            current = top.get(count);
            top.removeIndex(count);
            count--;
        }
        return current;
    }

    @Override
    public Object peek() {
        Object current;
        if (isEmpty()){
            throw new RuntimeException("is empty");
        }else {
            current = top.get(count);
        }
        return current;
    }

    @Override
    public int size() {
        return this.count+1;
    }

    @Override
    public void show() {
        top.show();
    }

    @Override
    public boolean isEmpty() {
        return this.count == -1;
    }
}
