import java.util.Arrays;

public class Heap {
    private int[] array;
    private int size;
    private int maxsize;

    Heap(int maxsize){
        this.array = new int[maxsize];
        this.maxsize = maxsize;
        this.size = 0;
    }

    void MaxHeap(int[] array, int size){
        for (int i = size/2-1; i >= 0; i--) {
            Heapify(array, size, i);
        }
    }

    void Heapify(int[] array, int size, int i){
        int largest = i;
        int leftChild = (2*i) + 1;
        int rightChild = (2*i) + 2;

        if (leftChild < size && array[leftChild] > array[largest]){
            largest = leftChild;
        }
        if (rightChild < size && array[rightChild] > array[largest]){
            largest = rightChild;
        }

        if (largest != i) {
            int temp = array[i];
            array[i] = array[largest];
            array[largest] = temp;
            Heapify(array, size, largest);
        }
    }

    void insert(int value){
        if (isEmpty()){
            array[size] = value;
            size++;
        }else {
            array[size] = value;
            size++;
            MaxHeap(array, size);
        }
    }

    public int[] getHeap() {
        return Arrays.copyOf(array, size);
    }

    boolean isEmpty(){return size == 0;}
    boolean isFull(){return size == maxsize;}

    int size(){return size;}
    int maxSize(){return maxsize;}

}

// Java program to implement Max Heap
//
// Main class
//public class MaxHeap {
//    private int[] Heap;
//    private int size;
//    private int maxsize;
//
//    // Constructor to initialize an
//    // empty max heap with given maximum
//    // capacity
//    public MaxHeap(int maxsize)
//    {
//        // This keyword refers to current instance itself
//        this.maxsize = maxsize;
//        this.size = 0;
//        Heap = new int[this.maxsize];
//    }
//
//    // Method 1
//    // Returning position of parent
//    private int parent(int pos) { return (pos - 1) / 2; }
//
//    // Method 2
//    // Returning left children
//    private int leftChild(int pos) { return (2 * pos) + 1; }
//
//    // Method 3
//    // Returning right children
//    private int rightChild(int pos)
//    {
//        return (2 * pos) + 2;
//    }
//
//    // Method 4
//    // Returning true if given node is leaf
//    private boolean isLeaf(int pos)
//    {
//        if (pos > (size / 2) && pos <= size) {
//            return true;
//        }
//        return false;
//    }
//
//    // Method 5
//    // Swapping nodes
//    private void swap(int fpos, int spos)
//    {
//        int tmp;
//        tmp = Heap[fpos];
//        Heap[fpos] = Heap[spos];
//        Heap[spos] = tmp;
//    }
//
//    // Method 6
//    // Recursive function to max heapify given subtree
//    private void maxHeapify(int pos)
//    {
//        if (isLeaf(pos))
//            return;
//
//        if (Heap[pos] < Heap[leftChild(pos)]
//                || Heap[pos] < Heap[rightChild(pos)]) {
//
//            if (Heap[leftChild(pos)]
//                    > Heap[rightChild(pos)]) {
//                swap(pos, leftChild(pos));
//                maxHeapify(leftChild(pos));
//            }
//            else {
//                swap(pos, rightChild(pos));
//                maxHeapify(rightChild(pos));
//            }
//        }
//    }
//
//    // Method 7
//    // Inserts a new element to max heap
//    public void insert(int element)
//    {
//        Heap[size] = element;
//
//        // Traverse up and fix violated property
//        int current = size;
//        while (Heap[current] > Heap[parent(current)]) {
//            swap(current, parent(current));
//            current = parent(current);
//        }
//        size++;
//    }
//
//    // Method 8
//    // To display heap
//    public void print()
//    {
//
//        for (int i = 0; i < size / 2; i++) {
//
//            System.out.print("Parent Node : " + Heap[i]);
//
//            if (leftChild(i)
//                    < size) // if the child is out of the bound
//                // of the array
//                System.out.print(" Left Child Node: "
//                        + Heap[leftChild(i)]);
//
//            if (rightChild(i)
//                    < size) // the right child index must not
//                // be out of the index of the array
//                System.out.print(" Right Child Node: "
//                        + Heap[rightChild(i)]);
//
//            System.out.println(); // for new line
//        }
//    }
//
//    // Method 9
//    // Remove an element from max heap
//    public int extractMax()
//    {
//        int popped = Heap[0];
//        Heap[0] = Heap[--size];
//        maxHeapify(0);
//        return popped;
//    }
//
//    // Method 10
//    // main driver method
//    public static void main(String[] arg)
//    {
//        // Display message for better readability
//        System.out.println("The Max Heap is ");
//
//        MaxHeap maxHeap = new MaxHeap(15);
//
//        // Inserting nodes
//        // Custom inputs
//        maxHeap.insert(5);
//        maxHeap.insert(3);
//        maxHeap.insert(17);
//        maxHeap.insert(10);
//        maxHeap.insert(84);
//        maxHeap.insert(19);
//        maxHeap.insert(6);
//        maxHeap.insert(22);
//        maxHeap.insert(9);
//
//        // Calling maxHeap() as defined above
//        maxHeap.print();
//
//        // Print and display the maximum value in heap
//        System.out.println("The max val is "
//                + maxHeap.extractMax());
//    }
//}



//import java.util.Arrays;
//
//public class MaxHeap {
//    private int[] heap;
//    private int size;
//
//    public MaxHeap(int capacity) {
//        heap = new int[capacity];
//        size = 0;
//    }
//
//    public void insert(int value) {
//        if (size == heap.length) {
//            throw new IllegalStateException("Heap is full");
//        }
//        heap[size] = value;
//        size++;
//        heapifyUp(size - 1);
//    }
//
//    private void heapifyUp(int index) {
//        int parentIndex = (index - 1) / 2;
//        if (parentIndex >= 0 && heap[index] > heap[parentIndex]) {
//            swap(index, parentIndex);
//            heapifyUp(parentIndex);
//        }
//    }
//
//    public void heapifyDown(int index) {
//        int largest = index;
//        int leftChild = 2 * index + 1;
//        int rightChild = 2 * index + 2;
//
//        if (leftChild < size && heap[leftChild] > heap[largest]) {
//            largest = leftChild;
//        }
//        if (rightChild < size && heap[rightChild] > heap[largest]) {
//            largest = rightChild;
//        }
//        if (largest != index) {
//            swap(index, largest);
//            heapifyDown(largest);
//        }
//    }
//
//    public int extractMax() {
//        if (size == 0) throw new IllegalStateException("Heap is empty");
//        int max = heap[0];
//        heap[0] = heap[size - 1];
//        size--;
//        heapifyDown(0);
//        return max;
//    }
//
//    private void swap(int i, int j) {
//        int temp = heap[i];
//        heap[i] = heap[j];
//        heap[j] = temp;
//    }
//
//    public int[] getHeap() {
//        return Arrays.copyOf(heap, size);
//    }
//
//    public static void main(String[] args) {
//        MaxHeap maxHeap = new MaxHeap(10);
//        maxHeap.insert(4);
//        maxHeap.insert(10);
//        maxHeap.insert(3);
//        maxHeap.insert(5);
//        maxHeap.insert(1);
//
//        System.out.println("Heap: " + Arrays.toString(maxHeap.getHeap()));
//
//        int max = maxHeap.extractMax();
//        System.out.println("Extracted max: " + max);
//        System.out.println("Heap after extraction: " + Arrays.toString(maxHeap.getHeap()));
//    }
//}


