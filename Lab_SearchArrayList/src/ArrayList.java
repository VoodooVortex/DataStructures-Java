
public class ArrayList implements Collection{
    private int capacity;
    private int count;
    private Object[] arry;

    public ArrayList(int size){
        arry = new Object[size];
        capacity = size;
        count = 0;
    }

    @Override
    public void add(Object value) {
        if(!isFull()){
            add(count, value);
        }else {
            throw new RuntimeException("is full");
        }
    }

    @Override
    public void add(int index, Object value) {
        if(index == count) {
            arry[index] = value;
        } else if (index < count) {
            for(int i = count; i > index; i--){
                arry[i] = arry[i-1];
            }
            arry[index] = value;
        } else {
            throw new RuntimeException("out of bounds");
        }
        count++;
    }

    @Override
    public Object get(int index) {
        if(index < count) {
            return arry[index];
        } else{
            throw new RuntimeException("not found");
        }
    }

    @Override
    public void set(int index, Object value) {
        if(index < count){
            arry[index] = value;
        }else{
            throw new RuntimeException("not found");
        }
    }

    @Override
    public void remove(Object value) {
        if(indexOf(value) == -1){
            throw new RuntimeException("not found");
        }
        Object[] temp_arry = new Object[capacity];
        int temp_count = 0;
        for(int i=0; i < capacity; i++){
            if(arry[i] != value){
                temp_arry[temp_count++] = arry[i];
            } else {
                count--;
            }
        }
        arry = temp_arry;
    }

    public int indexOf(Object value) {
        for(int i=0;i<count;i++){
            if(arry[i]== value) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int size() {
        return count;
    }

    public int max_size() {
        return capacity;
    }

    @Override
    public boolean isEmpty() {
        return count == 0;
    }


    public boolean isFull() {
        return count >= capacity;
    }

    @Override
    public void show() {
        System.out.print("[");
        if(!isEmpty())
            for(int i=0;i<max_size();i++){
                if(i == 0){
                    System.out.print(" ");
                }
                System.out.print(i);
                System.out.print("=>");
                System.out.print(arry[i]);
                if(i < max_size()-1){
                    System.out.print(", ");
                }else {
                    System.out.print(" ");
                }
            }
        System.out.println("]");
    }

    public boolean search_sequential(String c){
        for (int i = 0; i < size(); i++) {
            if (arry[i].equals(c)){
                return true;
            }
        }
        return false;
    }

    public boolean search_binary(String c){
        int f = 0;
        int l = arry.length-1;
        sort_quick();
        return binary(c, f, l);
    }

    public boolean binary(String c, int f, int l){
        int m = (f+l)/2;

        if (f > l) return false;

        if (Integer.parseInt((String) arry[m]) == Integer.parseInt(c)) return true;


        if (Integer.parseInt((String) arry[m]) < Integer.parseInt(c)){
            return binary(c, m+1, l);
        }else {
            return binary(c, f, m-1);
        }
    }

    public void sort_quick() {
        quickSort(arry, 0, arry.length-1);
    }

    public void quickSort(Object[] arr, int left, int right){
        int i = left;
        int j = right;
        Object temp;
        Object pivot = arr[(left+right)/2];

        while (i <= j){
            while (Integer.parseInt((String) arr[i]) < Integer.parseInt((String) pivot)){
                i++;
            }
            while (Integer.parseInt((String) arr[j]) > Integer.parseInt((String) pivot)){
                j--;
            }
            if (i <= j){
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        }

        if (left < j) quickSort(arr, left, j);
        if (i < right) quickSort(arr, i, right);
    }

    public boolean search_hashing(String c){
        Object[] table = hashTable();
        int key = Integer.parseInt(c) % size();
        int ix = 0;
        if (table[key] != null) {
            while (((Object[]) table[key])[ix] != null) {
                if (((Object[]) table[key])[ix].equals(c)) {
                    return true;
                }
                ix++;
            }
        }

        return false;
    }

    public Object[] hashTable(){
        Object[] arr = new Object[size()];

        for (int i = 0; i < size(); i++) {
            int value = Integer.parseInt((String) arry[i]);
            int index = value % size();
            int ix = 0;
            if (arr[index] != null){
                while ( ((Object[]) arr[index]) [ix] != null){
                    ix++;
                }
                ((Object[]) arr[index]) [ix] = arry[i];
            }else {
                arr[index] = new Object[size()];
                ((Object[]) arr[index]) [ix] = arry[i];
            }
        }
        return arr;
    }

}