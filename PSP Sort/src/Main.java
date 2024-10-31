import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }

    public void sortDESC(){
        Product temp;
        int max;
        for (int i = 0; i < productList.size()-1; i++) {
            max = i;
            temp = productList.get(i);
            for (int j = i+1; j < productList.size(); j++) {
                if (productList.get(max).getName().compareTo(productList.get(j).getName()) < 0){
                    max = j;
                }
            }
            productList.set(i, productList.get(max));
            productList.set(max, temp);
        }
    }

    public void sortASC(){
        quickSort(productList, 0, productList.size()-1);
    }

    public void quickSort(List<Product> arr, int left, int right){

        if (right <= left) return;

        int i = left;
        int j = right;
        Product temp;
        Product pivot = arr.get((left+right)/2);

        while (i <= j){
            while (Integer.parseInt(arr.get(i).getQuantity()) < Integer.parseInt(pivot.getQuantity())){
                i++;
            }
            while (Integer.parseInt(arr.get(j).getQuantity()) > Integer.parseInt(pivot.getQuantity())){
                j--;
            }
            if (i <= j){
                temp = arr.get(i);
                arr.set(i, arr.get(j));
                arr.set(j, temp);
                i++;
                j--;
            }
        }

        if (left < j) quickSort(arr, left, j);
        if (i < right) quickSort(arr, i, right);
    }
}