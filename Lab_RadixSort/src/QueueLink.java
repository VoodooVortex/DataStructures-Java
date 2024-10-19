public class QueueLink implements Queue {
    class node {
        Object data;
        node link;
        node(Object d, node l){
            data = d;
            link = l;
        }
    }

    node front;
    node back;
    int count;
    QueueLink(){
        front = null;
        back = null;
        count = 0;
    }


    @Override
    public void enqueue(Object value) {
        node new_node = new node(value, null);
        if(front == null){
            front = new_node;
            back = new_node;
        }else{
            back.link = new_node;
            back = new_node;
        }
        count++;
    }


    @Override
    public Object dequeue() {
        if(isEmpty()){
            throw new RuntimeException("is empty");
        }
        node temp = front;
        Object for_return = temp.data;
        if(front == back){
            back = temp.link;
        }
        front = temp.link;
        temp = null;
        count--;
        return for_return;
    }


    @Override
    public Object peek() {
        if(isEmpty()){
            throw new RuntimeException("is empty");
        }
        return front.data;
    }


    @Override
    public int size() {
        return count;
    }


    @Override
    public void show() {
        node temp = front;
        System.out.print("[");
        while(temp != null){
            System.out.print(temp.data);
            if(temp.link != null){
                System.out.print(", ");
            }
            temp = temp.link;
        }
        System.out.println("]");
    }


    @Override
    public boolean isEmpty() {
        return count == 0;
    }


}