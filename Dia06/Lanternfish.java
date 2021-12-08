import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Lanternfish {

    public static void first(int days){
        List<Integer> list = new ArrayList<Integer>();;
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        sc.close();
        String [] sInitialState = line.split(",");
        Integer number;
        Integer negative = -1;
        int counter = sInitialState.length;
        for(int i = 0; i < sInitialState.length; i++){
            number = Integer.parseInt(sInitialState[i]);
            list.add(number);
        }

        for(int i = 1; i <= days; i++){
            for(int j = 0; j < list.size(); j++){
                list.set(j, list.get(j) - 1); // decrementa todos 1 unidad
            }
            while(list.contains(negative)){ 
                int index = list.indexOf(negative);
                list.set(index, 6);
                list.add(8);
                counter++;
            }
        }
        System.out.println(counter);
    }


    public static void main(String[]args){
        first(256);
    }
}
