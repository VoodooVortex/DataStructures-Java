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


    public void sort_merge() {
        Object[] sortedArr = mergeSort(arry);

        System.arraycopy(sortedArr, 0, arry, 0, sortedArr.length);
    }

    public Object[] mergeSort(Object[] arr){
        int size = arr.length;
        int mid = size/2;
        if (size == 1) return arr;

        Object[] left = new Object[mid];
        Object[] right = new Object[size-mid];

        int j = 0;
        for (int i = 0; i < size; i++) {
            if (i < mid){
                left[i] = arr[i];
            }else {
                right[j++] = arr[i];
            }
        }

        left = mergeSort(left);
        right = mergeSort(right);

        return merge(left, right);
    }

    public Object[] merge(Object[] l, Object[] r){
        int ri = 0, li = 0, i = 0;
        Object[] result = new Object[l.length + r.length];

        while (ri < r.length && li < l.length){
            if (Integer.parseInt((String) l[li]) > Integer.parseInt((String) r[ri])){
                result[i++] = r[ri++];
            }else {
                result[i++] = l[li++];
            }
        }

        while (li < l.length){
            result[i++] = l[li++];
        }

        while (ri < r.length){
            result[i++] = r[ri++];
        }

        return result;
    }

    public void sort_quick() {
        quickSort(arry, 0, arry.length-1);
    }

    public void quickSort(Object[] arr, int left, int right){

        if (right <= left) return;

        int i = left-1;
        int j = left;
        Object temp;
        Object pivot = arr[right];

        while (j < right){
            if (Integer.parseInt((String) arr[j]) < Integer.parseInt((String) pivot)) {
                i++;
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
            j++;
        }

        i++;
        temp = arr[i];
        arr[i] = arr[right];
        arr[right] = temp;

        if (left < i-1) quickSort(arr, left, (i-1));
        if (i+1 < right) quickSort(arr, (i+1), right);



//        int i = left;
//        int j = right;
//        Object temp;
//        Object pivot = arr[(left+right)/2];
//
//        while (i <= j){
//            while ((Integer) arr[i] < (Integer) pivot){
//                i++;
//            }
//            while ((Integer) arr[j] > (Integer) pivot){
//                j--;
//            }
//            if (i <= j){
//                temp = arr[i];
//                arr[i] = arr[j];
//                arr[j] = temp;
//                i++;
//                j--;
//            }
//        }
//
//        if (left < j) quickSort(arr, left, j);
//        if (i < right) quickSort(arr, i, right);
    }

}