import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.AbstractMap.SimpleEntry;
import java.util.Map.Entry;
import java.util.ArrayList;

public class TreacheryWhales {
    
    public static void first(){
        List<Integer> numbers = saveNumbers();
        Entry<Integer, Integer> prevPair = new SimpleEntry<Integer,Integer>(-1,0);
        Integer max = Collections.max(numbers); // Maxima posicion a probar 
        Integer min = Collections.min(numbers); // Minima posicion a probar
        int lastPost = max; // Lo paso a tipo primitivo
        int firstPos = min; // Lo paso a tipo primitivo
        int fuel = 0;
        for(int j = firstPos; j <= lastPost; j++){ // Para cada posible posicion
            fuel = 0;
            for(int i = 0; i < numbers.size(); i++){ // Para cada elemento de la lista
                fuel += Math.abs(j - numbers.get(i)); // Calculo su gasto y lo acumulo 
            }
            //------------Implementacion no necesaria para el ejercicio--------------//
            Entry<Integer, Integer> pair = new SimpleEntry<Integer, Integer>(fuel, j);
            if(prevPair.getKey().equals(-1) || pair.getKey() < prevPair.getKey()){
                prevPair = pair;
            }
        }
        System.out.println(prevPair.getKey());      // Fuel
        System.out.println(prevPair.getValue());    // Posicion elegida para el alineamiento
    }

    public static void second(){
        List<Integer> numbers = saveNumbers();
        Integer max = Collections.max(numbers); // Maxima posicion a probar 
        Integer min = Collections.min(numbers); // Minima posicion a probar
        int lastPost = max; // Lo paso a tipo primitivo
        int firstPos = min; // Lo paso a tipo primitivo
        int fuel = 0;
        int prevFuel = -1; // Variable en la que almaceno el gasto minimo encontrado hasta el momento
        for(int j = firstPos; j <= lastPost; j++){ // Para cada posible posicion
            fuel = 0;
            for(int i = 0; i < numbers.size(); i++){ // Para cada elemento de la lista
                int iterations = Math.abs(j - numbers.get(i)); // Considero numero maximo de iteraciones la distancia entre ambos numeros
                for(int k = 1; k <= iterations; k++){ // El numero de la iteracion sera el numero a sumar al gasto
                    fuel += k;
                }
            }
            if(prevFuel == -1 || fuel < prevFuel){
                prevFuel = fuel;
            }
        }
        System.out.println(prevFuel); // Se imprime el gasto previo que en este caso sera el minimo
    }

    private static List<Integer> saveNumbers(){
        List<Integer> numbers = new ArrayList<Integer>();
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        sc.close();
        String [] sInitialState = line.split(",");
        for(int i = 0; i < sInitialState.length; i++){
            Integer number = Integer.parseInt(sInitialState[i]);
            numbers.add(number);
        }
        return numbers;
    }
    
    public static void main(String[] args){
        first();
        //second();
    }
    
}
