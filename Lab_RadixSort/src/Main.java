import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int size_arr = input.nextInt();
        int[] arr = new int[size_arr];
        int temp = 0;
        for(int i = 0; i < size_arr; i++){
            arr[i] = input.nextInt();
            if (temp < arr[i]){
                temp = arr[i];
            }
        }

        int maxDigit = String.valueOf(temp).length();

        QueueLink[] queue= new QueueLink[10];
        for (int ix = 0; ix < 10; ix++) {
            queue[ix] = new QueueLink();
        }

        for (int i = 0; i < maxDigit; i++) {
            for (int k = 0; k < size_arr; k++) {
                int digit = Integer.parseInt(String.valueOf(String.valueOf(arr[k]).length()));
                char digitHM = String.valueOf(arr[k]).charAt(0);
                if (i == 0) {
                    char num = String.valueOf(arr[k]).charAt(digit-1);
                    int index = Integer.parseInt(String.valueOf(num));
                    queue[index].enqueue(arr[k]);
                }
                if (i == 1) {
                    if (digit == 2){
                        int index = Integer.parseInt(String.valueOf(digitHM));
                        queue[index].enqueue(arr[k]);
                    }else if (digit > 2){
                        char num = String.valueOf(arr[k]).charAt(1);
                        int index = Integer.parseInt(String.valueOf(num));
                        queue[index].enqueue(arr[k]);
                    }else {
                        queue[0].enqueue(arr[k]);
                    }
                }
                if (i == 2) {
                    if (digit == 3) {
                        int index = Integer.parseInt(String.valueOf(digitHM));
                        queue[index].enqueue(arr[k]);
                    } else {
                        queue[0].enqueue(arr[k]);
                    }
                }
            }

            int out = 0;
            for (int k = 0; k < 10; k++) {
                while (!queue[k].isEmpty()){
                    arr[out++] = (int) queue[k].dequeue();
                }
            }

            System.out.print("Step " + (i+1) + ": ");
            printResult(arr, size_arr);
        }

        System.out.print("Result => ");
        printResult(arr, size_arr);
    }

    public static void printResult(int[] arr, int size){
        StringBuilder result = new StringBuilder();
        for (int j = 0; j < size; j++) {
            if (j != size-1){
                result.append(arr[j]).append(", ");
            }else {
                result.append(arr[j]);
            }
        }
        System.out.println(result);
    }
}
