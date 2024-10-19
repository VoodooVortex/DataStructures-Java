import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        String[] check;
        QueueLink obj_queueArr = new QueueLink();

        do {
            check = kb.nextLine().split(" ");
            if (check.length > 0 && !check[0].isEmpty()) {
                switch (Integer.parseInt(check[0])) {
                    case 1:
                        try {
                            obj_queueArr.enqueue(check[1]);
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                    case 2:
                        try {
                            System.out.println(obj_queueArr.dequeue());
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                    case 3:
                        try {
                            System.out.println(obj_queueArr.peek());
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                    case 4:
                        try {
                            System.out.println(obj_queueArr.size());
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                    case 5:
                        try {
                            obj_queueArr.show();
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                    case 6:
                        try {
                            if (obj_queueArr.isEmpty()){
                                System.out.println("is empty");
                            }else {
                                System.out.println("not empty");
                            }
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                }
            }
        }while (!check[0].equals("-99"));
    }
}