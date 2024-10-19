public class DoubleLinkedList implements Collection {

    class node {
        Object data;
        node link;
        node plink;

        node(node pl, Object d, node l) {
            data = d;
            link = l;
            plink = pl;
        }
    }

    private node head;
    private node tail;
    private int count;

    public DoubleLinkedList() {
        this.head = null;
        this.tail = null;
        this.count = 0;
    }

    @Override
    public void add(Object value) {
        node newNode = new node(null, value, null);

        if (isEmpty()){
            this.head = newNode;
            this.tail = newNode;
        }else {
            this.tail.link = newNode;
            newNode.plink = tail;
            this.tail = newNode;
        }
        count++;
    }

    @Override
    public void add(int index, Object value) {
        if (index < 0 || index > count+1) throw new IndexOutOfBoundsException("out of bound");
        node newNode = new node(null, value, null);
        if (index == 0){
            newNode.link = this.head;
            this.head.plink = newNode;
            this.head = newNode;
            count++;
        }else if (index > size()){
            add(value);
        }else {
            node ptemp = null;
            node temp = this.head;
            for (int i = 0; i < index; i++) {
                ptemp = temp;
                temp = temp.link;
            }
            newNode.plink = ptemp;
            newNode.link = temp;
            ptemp.link = newNode;
            temp.plink = newNode;
            count++;
        }
    }

    @Override
    public Object get(int index) {
        if (index < 0 || index > count) throw new IndexOutOfBoundsException("out of bound");
        node current = this.head;
        for (int i = 0; i < index; i++) {
            current = current.link;
        }
        return current.data;
    }

    @Override
    public void set(int index, Object value) {
        if (index < 0 || index > count) throw new IndexOutOfBoundsException("out of bound");
        node current = this.head;
        for (int i = 0; i < index; i++) {
            current = current.link;
        }
        current.data = value;
    }

    @Override
    public void remove(Object value) {
        if (!isEmpty()) {
            node current = this.head;
            while (current.link != null) {
                if (this.head.data == value){
                    this.head = this.head.link;
                    this.head.plink = null;
                    count--;
                    current = this.head;
                }
                if (this.tail.data == value){
                    this.tail = this.tail.plink;
                    this.tail.link = null;
                    count--;
                }
                if (current.data == value && current.plink != null) {
                    current.plink.link = current.link;
                    current.link.plink = current.plink;
                    count--;
                }
                if (current.link != null){
                    current = current.link;
                }
            }
        }

    }

    @Override
    public boolean find(Object value) {
        node current = this.head;
        while (current != null){
            if (current.data == value) return true;
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
            node current = this.head;
            System.out.print("[");
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

    public void show_backward() {
        if (isEmpty()){
            System.out.println("[]");
        }else {
            node current = this.tail;
            System.out.print("[");
            while (current != null){
                System.out.print(current.data);
                if (current.plink != null){
                    System.out.print(", ");
                }
                current = current.plink;
            }
            System.out.println("]");
        }
    }
}