import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int size_arr = input.nextInt();
        Heap obj_arr = new Heap(size_arr);
        obj_arr.insert(input.nextInt());
        obj_arr.insert(input.nextInt());
        obj_arr.insert(input.nextInt());
        obj_arr.insert(input.nextInt());
        obj_arr.insert(input.nextInt());
        System.out.println("Heap: " + Arrays.toString(obj_arr.getHeap()));
    }
}