import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.AbstractMap.SimpleEntry;
import java.util.Map.Entry;
import java.util.ArrayList;

public class TreacheryWhales {
    
    public static void first(){
        List<Integer> numbers = new ArrayList<Integer>();
        Long dim = Long.parseLong("10000000000000000");
        Entry<Long, Integer> prevPair = new SimpleEntry<Long,Integer>(dim,0);
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        sc.close();
        String [] sInitialState = line.split(",");
        for(int i = 0; i < sInitialState.length; i++){
            Integer number = Integer.parseInt(sInitialState[i]);
            numbers.add(number);
        }
        Integer max = Collections.max(numbers); // Maxima posicion a probar (minima 0)
        Integer min = Collections.min(numbers);
        int lastPost = max;
        int firstPos = min;
        int fuel = 0;
        for(int j = firstPos; j <= lastPost; j++){ // Para cada elemento de la lista
            fuel = 0;
            for(int i = 0; i < numbers.size(); i++){
                fuel += Math.abs(j - numbers.get(i));
            }
            String s = Integer.toString(fuel);
            Long f = Long.parseLong(s);
            Entry<Long, Integer> pair = new SimpleEntry<Long, Integer>(f, j);
            if(pair.getKey() < prevPair.getKey()){
                prevPair = pair;
            }
        }
        System.out.println(prevPair.getKey());
        System.out.println(prevPair.getValue());
    }
    
    public static void main(String[] args){
        first();
    }
    
}
