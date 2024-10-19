import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int size_arr = input.nextInt();

        ArrayList obj = new ArrayList(size_arr);

        String[] checker = new String[3];
        do {
            checker = input.nextLine().split(" ");
            if (checker.length > 0 && !checker[0].isEmpty()) {
                switch (Integer.parseInt(checker[0])) {
                    case 1: // add
                        try {
                            obj.add(Integer.parseInt(checker[1]));
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                    case 2: // add index
                        try {
                            obj.add(Integer.parseInt(checker[1]), Integer.parseInt(checker[2]));
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                    case 3: // get
                        try {
                            System.out.println(obj.get(Integer.parseInt(checker[1])));
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                    case 4: // set
                        try {
                            obj.set(Integer.parseInt(checker[1]), Integer.parseInt(checker[2]));
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                    case 5: // remove
                        obj.remove(Integer.parseInt(checker[1]));
                        break;
                    case 6: // find
                        if(obj.find(Integer.parseInt(checker[1]))){
                            System.out.println("found");
                        }else{
                            System.out.println("not found");
                        }
                        break;
                    case 7: // show
                        obj.show();
                        break;
                    case 8: // indexOf
                        System.out.println(obj.indexOf(Integer.parseInt(checker[1])));
                        break;
                    case 9: // size
                        System.out.println(obj.size());
                        break;
                    case 10: // max_size
                        System.out.println(obj.maxSize());
                        break;
                    case 11: // isEmpty
                        if(obj.isEmpty()){
                            System.out.println("is empty");
                        }else{
                            System.out.println("is not empty");
                        }
                        break;
                    case 12: // isFull
                        if(obj.isEmpty()){
                            System.out.println("is full");
                        }else{
                            System.out.println("is not full");
                        }
                        break;
                }
            }
        } while (!checker[0].equals("-99"));
        input.close();
    }
}