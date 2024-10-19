public class StackArray implements Stack{
    int top;
    int max;
    ArrayList arr_stack;

    StackArray(int size){
        top = -1;
        max = size;
        arr_stack = new ArrayList(size);
    }
    @Override
    public void push(Object value) {
        if (!arr_stack.isFull()){
            arr_stack.add(value);
            top++;
        }else {
            throw new ArrayStoreException("is full");
        }
    }

    @Override
    public Object pop() {
        Object temp;
        if (!isEmpty()){
            temp = arr_stack.get(top);
            arr_stack.removeIndex(top);
            top--;
        }else{
            throw new ArrayIndexOutOfBoundsException("is empty");
        }
        return temp;
    }

    @Override
    public Object peek() {
        Object temp;
        if (!isEmpty()){
            temp = arr_stack.get(top);
        }else {
            throw new ArrayIndexOutOfBoundsException("is empty");
        }
        return temp;
    }

    @Override
    public int size() {
        return arr_stack.size();
    }

    @Override
    public void show() {
        arr_stack.show();
    }

    @Override
    public boolean isEmpty() {
        return arr_stack.isEmpty();
    }

    @Override
    public boolean isFull() {
        return arr_stack.isFull();
    }
    
}
