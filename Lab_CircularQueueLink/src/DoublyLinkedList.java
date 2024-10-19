public class DoublyLinkedList implements Collection {

    private node head;
    private node tail;
    private int count;

    public DoublyLinkedList() {
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
            this.head.link = tail;
            this.head.plink = tail;
        }else {
            this.tail.link = newNode;
            newNode.plink = tail;
            newNode.link = head;
            this.head.plink = newNode;
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
            newNode.plink = tail;
            tail.link = newNode;
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
                    this.head.plink = this.tail;
                    this.tail.link = this.head;
                    count--;
                    current = this.head;
                }
                if (this.tail.data == value){
                    this.tail = this.tail.plink;
                    this.tail.link = this.head;
                    this.head.plink = this.tail;
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

    public void removeIndex(int index){
        if (size() == 1){
            this.tail = null;
            this.head = null;
            count--;
        }else if (index == 0){
            this.head = this.head.link;
            this.head.plink = this.tail;
            this.tail.link = this.head;
            count--;
        }else if (index == size()-1){
            this.tail = this.tail.plink;
            this.tail.link = null;
            count--;
        }
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
                current = current.link;
                if (current != head){
                    System.out.print(", ");
                }else {
                    break;
                }
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
                current = current.plink;
                if (current != tail){
                    System.out.print(", ");
                }else {
                    break;
                }
            }
            System.out.println("]");
        }
    }
}