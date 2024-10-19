public class DoublyLinkedList implements Collection {

    class Node {
        Object data;
        Node link;
        Node plink;

        Node(Object d, Node l, Node pl) {
            data = d;
            link = l;
            plink = pl;
        }
    }

    private Node head;
    private Node tail;
    private int count;

    public DoublyLinkedList() {
        count = 0;
        head = null;
        tail = null;
    }

    @Override
    public void add(Object value) {
        Node newNode = new Node(value, null, tail);
        if (tail != null) {
            tail.link = newNode;
        }
        tail = newNode;
        if (head == null) {
            head = newNode;
        }
        count++;
    }

    @Override
    public void add(int index, Object value) {
        if (index <= 0 || index > count + 1) {
            throw new IndexOutOfBoundsException("out of bound");
        }
        if (index == count+1) {
            add(value);
        } else if (index == 1) {
            Node newNode = new Node(value, head, null);
            head.plink = newNode;
            head = newNode;
            count++;
        } else {
            Node current = head;
            for (int i = 1; i < index; i++) {
                current = current.link;
            }
            Node newNode = new Node(value, current, current.plink);
            current.plink.link = newNode;
            current.plink = newNode;
            count++;
        }
    }

    @Override
    public Object get(int index) {
        if (index <= 0 || index > count) {
            throw new IndexOutOfBoundsException("out of bound");
        }
        Node current = head;
        for (int i = 1; i < index; i++) {
            current = current.link;
        }
        return current.data;
    }

    @Override
    public void set(int index, Object value) {
        if (index <= 0 || index > count) {
            throw new IndexOutOfBoundsException("out of bound");
        }
        Node current = head;
        for (int i = 1; i < index; i++) {
            current = current.link;
        }
        current.data = value;
    }

    @Override
    public void remove(Object value) {
        Node current = head;
        while (current != null) {
            if (current.data == value) {
                if (current.plink != null) {
                    current.plink.link = current.link;
                } else {
                    head = current.link;
                }
                if (current.link != null) {
                    current.link.plink = current.plink;
                } else {
                    tail = current.plink;
                }
                count--;
            }
            current = current.link;
        }
    }

    public boolean find(Object value) {
        Node current = head;
        while (current != null) {
            if (current.data == value) {
                return true;
            }
            current = current.link;
        }
        return false;
    }

    @Override
    public int size() {
        return count;
    }

    @Override
    public boolean isEmpty() {
        return count == 0;
    }

    @Override
    public void show() {
        Node current = head;
        System.out.print("[ ");
        while (current != null) {
            System.out.print(current.data);
            if(current.link != null){
                System.out.print(", ");
            }else{
                System.out.print(" ");
            }
            current = current.link;
        }
        System.out.println("]");
    }

    public void show_backward() {
        Node current = tail;
        System.out.print("[ ");
        while (current != null) {
            System.out.print(current.data);
            if(current.plink != null){
                System.out.print(", ");
            }else{
                System.out.print(" ");
            }
            current = current.plink;
        }
        System.out.println("]");
    }

    public boolean search_sequential(Object value) {
        Node current = head;
        while (current != null){
            if (current.data.equals(value)){
                return true;
            }
            current = current.link;
        }
        return false;
    }

    public boolean search_binary(Object value) {
        sort_insertion();
        int first = 0;
        int last = size()-1;

        while (first <= last) {
            Node current = head;
            int mid = (first + last) / 2;

            for (int i = 0; i < mid; i++) {
                current = current.link;
            }

            if (current.data.equals(value)) return true;

            if (Integer.parseInt((String) current.data) > Integer.parseInt((String) value)){
                last = mid - 1;
            }else {
                first = mid + 1;
            }

        }

        return false;
    }

    public void sort_insertion() {
        Node i = head;
        Node j;
        Node temp = new Node(null, null, null);
        while (i != null){
            temp.data = i.data;
            j = i.plink;
            while (j != null){
                if (Integer.parseInt((String) temp.data) < Integer.parseInt((String) j.data)){
                    j.link.data = j.data;
                    j.data = temp.data;
                } else {
                    break;
                }
                j = j.plink;
            }
            i = i.link;
        }
    }

    public boolean search_hashing(Object value) {
        Node[] hashTable = hashTable();
        int key = Integer.parseInt((String) value) % size();

        Node current = hashTable[key];

        while (current != null){
            if (current.data.equals(value)) return true;
            current = current.link;
        }

        return false;
    }

    public Node[] hashTable(){
        Node[] table = new Node[size()];
        Node current = head;

        while (current != null) {
            int index = Integer.parseInt((String) current.data) % size();
            Node newNode = new Node(current.data, null, null);

            if (table[index] != null) {
                newNode.link = table[index];
                table[index].plink = newNode;
            }

            table[index] = newNode;
            current = current.link;
        }

        return table;
    }

}