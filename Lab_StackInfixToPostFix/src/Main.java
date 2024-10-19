import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        String inputInFix;
        char inFix;
        StringBuilder postFix = new StringBuilder();
        StackLink stack = new StackLink();
        int outStack = 0;
        int inStack = 0;
        boolean checkNum;
        boolean checkOpenS = false;
        boolean checkCloseS = false;
        boolean checkOpenM = false;
        boolean checkCloseM = false;
        boolean checkOpenL = false;
        boolean checkCloseL = false;
        boolean checkPrint = false;

        do {
            inputInFix = kb.nextLine();
            if (!inputInFix.equals("exit")) {
                for (int i = 0; i < inputInFix.length(); i++) {
                    checkNum = false;
                    inFix = inputInFix.charAt(i);
                    //ถ้า Stack ว่างหรือเป็นค่าแรกให้เอาเครื่องหมายใส่ใน Stack
                    if (stack.isEmpty()){
                        if (inFix == '+' || inFix == '-' || inFix == '*' || inFix == '/' || inFix == '^'){
                            stack.push(String.valueOf(inFix));
                        }else if (inFix == '('){
                            stack.push(String.valueOf(inFix));
                            checkOpenS = true;
                        }else if (inFix == '{'){
                            stack.push(String.valueOf(inFix));
                            checkOpenM = true;
                        }else if (inFix == '['){
                            stack.push(String.valueOf(inFix));
                            checkOpenL = true;
                        }else {
                            postFix.append(inFix);
                        }
                    }else {
                        //เช็คค่าข้างใน Stack
                        if (stack.peek().equals("+") || stack.peek().equals("-")){
                            inStack = 2;
                        }else if (stack.peek().equals("*") || stack.peek().equals("/")){
                            inStack = 4;
                        }else if (stack.peek().equals("^")){
                            inStack = 5;
                        }else if (stack.peek().equals("(")){
                            checkOpenS = true;
                        }else if (stack.peek().equals("{")){
                            checkOpenM = true;
                        }else if (stack.peek().equals("[")){
                            checkOpenL = true;
                        }
                        //เช็คค่าที่รับเข้ามา
                        if (inFix == '+' || inFix == '-'){
                            outStack = 1;
                        }else if (inFix == '*' || inFix == '/'){
                            outStack = 3;
                        }else if (inFix == '^'){
                            outStack = 6;
                        }else if (inFix == '('){
                            outStack = 7;
                            checkOpenS = true;
                        }else if (inFix == '{'){
                            outStack = 7;
                            checkOpenM = true;
                        }else if (inFix == '['){
                            outStack = 7;
                            checkOpenL = true;
                        }else if (inFix == ')'){
                            outStack = 0;
                            checkCloseS = true;
                        }else if (inFix == '}'){
                            outStack = 0;
                            checkCloseM = true;
                        }else if (inFix == ']'){
                            outStack = 0;
                            checkCloseL = true;
                        }else {
                            postFix.append(inFix);
                            checkNum = true;
                        }

                        //เปรียบเทียบค่า
                        if (!checkNum) {
                            if (inStack < outStack) {
                                stack.push(String.valueOf(inFix));
                            }else if (inStack > outStack && !checkCloseS && !checkCloseM && !checkCloseL) {
                                while (!stack.isEmpty()) {
                                    int inStackCheck = 0;
                                    if (stack.peek().equals("+") || stack.peek().equals("-")){
                                        inStackCheck = 2;
                                        postFix.append(stack.pop());
                                    }else if (stack.peek().equals("*") || stack.peek().equals("/")) {
                                        inStackCheck = 4;
                                        postFix.append(stack.pop());
                                    }else if (stack.peek().equals("^")) {
                                        inStackCheck = 5;
                                        postFix.append(stack.pop());
                                    }

                                    //เช็คว่าค่าใน stack ที่เราเอาออกไปมันมันน้อยกว่าค่าที่รับมารึเปล่า
                                    if (inStackCheck < outStack){
                                        stack.push(String.valueOf(inFix));
                                        break;
                                    }
                                    //แปลงค่าข้างใน stack ให้เป็นค่าเท่ากับตอนที่รับเข้ามา
                                    if (inStackCheck == 2){
                                        inStackCheck = 1;
                                    }else if (inStackCheck == 4){
                                        inStackCheck = 3;
                                    }else if (inStackCheck == 5){
                                        inStackCheck = 6;
                                    }
                                    //เช็คว่าค่าข้างใน stack มีค่าเท่ากับค่าที่รับมารึเปล่า
                                    if (inStackCheck == outStack){
                                        stack.push(String.valueOf(inFix));
                                        break;
                                    }
                                }

                                if (stack.isEmpty()){
                                    stack.push(String.valueOf(inFix));
                                }
                                
                            }else if (checkOpenS && checkCloseS){
                                while (!stack.isEmpty()){
                                    if (stack.peek().equals("(")){
                                        stack.pop();
                                        checkOpenS = false;
                                        checkCloseS = false;
                                        break;
                                    }else {
                                        postFix.append(stack.pop());
                                    }
                                }
                            }else if (checkOpenM && checkCloseM){
                                while (!stack.isEmpty()){
                                    if (stack.peek().equals("{")){
                                        stack.pop();
                                        checkOpenM = false;
                                        checkCloseM = false;
                                        break;
                                    }else {
                                        postFix.append(stack.pop());
                                    }
                                }
                            }else if (checkOpenL && checkCloseL){
                                while (!stack.isEmpty()){
                                    if (stack.peek().equals("[")){
                                        stack.pop();
                                        checkOpenL = false;
                                        checkCloseL = false;
                                        break;
                                    }else {
                                        postFix.append(stack.pop());
                                    }
                                }
                            }
                        }
                    }
                    if (i == inputInFix.length()-1){
                        while (!stack.isEmpty()){
                            postFix.append(stack.pop());
                        }
                    }
                }
                checkPrint = true;
            }
            boolean checkMissing = false;
            StringBuilder result = new StringBuilder("not found  ");

            if (checkOpenS && !checkCloseS){
                checkPrint = false;
                checkMissing = true;
                result.replace(9,11, " )");
            }
            if (!checkOpenS && checkCloseS){
                checkPrint = false;
                checkMissing = true;
                result.replace(9,11, " (");
            }
            if (checkOpenM && !checkCloseM){
                checkPrint = false;
                checkMissing = true;
                result.replace(9,11, " }");
            }
            if (!checkOpenM && checkCloseM){
                checkPrint = false;
                checkMissing = true;
                result.replace(9,11, " {");
            }
            if (checkOpenL && !checkCloseL){
                checkPrint = false;
                checkMissing = true;
                result.replace(9,11, " ]");
            }
            if (!checkOpenL && checkCloseL){
                checkPrint = false;
                checkMissing = true;
                result.replace(9,11, " [");
            }
            if (checkMissing){
                System.out.printf(result.toString());
                break;
            }

        }while (!inputInFix.equals("exit"));
        if (checkPrint) System.out.println(postFix);
    }
}