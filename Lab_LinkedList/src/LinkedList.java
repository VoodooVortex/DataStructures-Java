public class LinkedList implements Collection{

    private class node {
        Object data;
        node link;
        node(Object d, node l){
            this.data = d;
            this.link = l;
        }
    }

    node head;
    node tail;
    int count;

    LinkedList(){
        this.head = null;
        this.tail = null;
        this.count = 0;

    }

    @Override
    public void add(Object value) {
        node new_Node = new node(value, null);
        if (isEmpty()){
            this.head = new_Node;
            this.tail = new_Node;
        }else {
            this.tail.link = new_Node;
            this.tail = new_Node;
        }
        count++;
    }

    @Override
    public void add(int index, Object value) {
        node newNode = new node(value, null);
        if (index > count+1 || index < 1 ){
            throw new IndexOutOfBoundsException("out of bound");
        }

        if (index == size()){
            add(value);
        }else if (index == 1){
            newNode.link = this.head;
            this.head = newNode;
            count++;
        }else {
            node temp = this.head;
            node ptemp = null;
            for (int i = 1; i < index; i++) {
                ptemp = temp;
                temp = temp.link;
            }
            newNode.link = temp;
            ptemp.link = newNode;
            count++;
        }


    }

    @Override
    public Object get(int index) {
        node current = null;
        if (index > count || index < 1){
            throw new IndexOutOfBoundsException("out of bound");
        }else {
            node temp = this.head;
            for (int i = 1; i <= index; i++) {
                if (i == index){
                    current = temp;
                }
                temp = temp.link;
            }

        }
        return current.data;
    }

    @Override
    public void set(int index, Object value) {
        node newNode = new node(value, null);
        node temp = this.head;
        node ptemp = null;
        if (index > count || index < 1){
            throw new IndexOutOfBoundsException("out of bound");
        }else if (index == 1){//set ค่าตัวแรกสุด
            newNode.link = this.head.link;
            this.head = newNode;
        }else if (index == size()){//set ค่าตัวหลังสุด
            while (temp != null){
                if (temp.link == tail){
                    temp.link = newNode;
                    tail = newNode;
                }
                temp = temp.link;
            }
        }else {//set ค่าตัวระหว่างตัวหน้ากับหลัง
            for (int i = 1; i < index; i++) {
                ptemp = temp;
                temp = temp.link;
            }
            ptemp.link = newNode;
            newNode.link = temp.link;
        }

    }

    @Override
    public void remove(Object value) {
        node temp = this.head;
        node ptemp = null;
        if (value == this.head.data){
            this.head = this.head.link;
            if (this.head == null) this.tail = null;
            count--;
        }else if (this.tail.data == value){
           while (temp != null){
               if (temp.link == this.tail){
                   temp.link = null;
                   tail = temp;
                   count--;
               }
               temp = temp.link;
           }
        }else {
            while (temp.link != null){
                if (temp.data == value){
                    ptemp.link = temp.link;
                    count--;
                }else if (temp.link.data == value){
                    temp.link = temp.link.link;
                    count--;
                }
                ptemp = temp;
                temp = temp.link;
            }
        }
    }

    @Override
    public boolean find(Object value) {
        node current = this.head;
        while (current != null){
            if (current.data == value){
                return true;
            }
            current = current.link;
        }
        return false;
    }

    @Override
    public int size() {
        return this.count;
    }

    @Override
    public boolean isEmpty() {
        return count == 0;
    }

    @Override
    public void show() {
        if (isEmpty()){
            System.out.println("[]");
        }else {
            System.out.print("[");
            node current = this.head;
            while (current != null){
                System.out.print(current.data);
                if (current.link != null){
                    System.out.print(", ");
                }
                current = current.link;
            }
            System.out.println("]");
        }

    }
}