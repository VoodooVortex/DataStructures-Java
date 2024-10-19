public class ArrayList implements Collection{
    private int capacity;
    private int count;
    private Object[] arry;

    ArrayList(int size_arr){
        this.capacity = size_arr;
        this.count = 0;
        this.arry = new Object[this.capacity];
    }
    @Override
    public void add(Object value) {
        this.add(this.count, value);
    }

    @Override
    public void add(int index, Object value) {
        if (index < 0 || index >= capacity || index > count || count >= capacity){
            throw new RuntimeException("Array Out of Bounds");
        }
        for (int i = count; i > index; i--) {
            this.arry[i] = this.arry[i-1];
        }
        count++;
        this.arry[index] = value;
    }

    @Override
    public Object get(int index) {
        if (index >= count){
            throw new RuntimeException("Array Out of Bounds");
        }else {
            return arry[index];
        }
    }

    @Override
    public void set(int index, Object value) {
        if (index >= capacity || index < 0 || index >= count){
            throw new RuntimeException("Array Out of Bounds");
        }else {
            this.arry[index] = value;
        }

    }

    @Override
    public void remove(Object value) {
        for (int i = 0; i < count; i++) {
            if (value.equals(this.arry[i])){
                for (int j = i; j < count-1; j++) {
                    this.arry[j] = this.arry[j+1];
                }
                count--;
                this.arry[count] = null;
                return;
            }
        }
    }

    public void removeIndex(int index){
        for (int i = 0; i < count; i++) {
            if (i == index){
                for (int j = i; j < count-1; j++) {
                    this.arry[j] = this.arry[j+1];
                }
                count--;
                this.arry[count] = null;
                return;
            }
        }
    }

    @Override
    public boolean find(Object value) {
        boolean check = false;
        for (int i = 0; i < this.arry.length; i++) {
            if (value.equals(arry[i])){
                check = true;
            }
        }
        return check;
    }

    public int indexOf(Object value){
        int check = -1;
        for (int i = 0; i < this.arry.length; i++) {
            if (value.equals(arry[i])){
                check = i;
            }
        }
        return check;
    }

    @Override
    public void show() {
        System.out.print("[");
        for (int i = 0; i < arry.length; i++) {
            System.out.print(i + "=>" + arry[i]);
            if (i != arry.length-1){
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    @Override
    public int size() {
        return this.count;
    }

    public int maxSize(){
        return this.capacity;
    }

    @Override
    public boolean isEmpty() {
        for (int i = 0; i < this.arry.length; i++) {
            if (this.arry[i] != null){
                return false;
            }
        }
        return true;
    }

    public boolean isFull(){
        return count == capacity;
    }
}
