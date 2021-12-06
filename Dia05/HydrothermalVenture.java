import java.util.Scanner;

public class HydrothermalVenture {
    
    public static void first(){
        Scanner sc = new Scanner(System.in);
        int[][] diagram = new int [10000][10000]; // diagrama
        int[] row = new int[4];
        int num;
        String line;
        String[] numbers;
        int dangerousAreas = 0;
        int j = 0;

        while (sc.hasNext()) {
            line = sc.next();
            numbers = line.split(",");
            if(numbers.length != 1){ // no es la flecha
                for(int i = 0; i < numbers.length; i++){
                    num = Integer.parseInt(numbers[i]); // guardo el numero 
                    row[j] = num;
                    j++;
                }
                if(j == 4){ // Se ha completado un row
                    if(row[0] == row[2]){
                        if(row[1] < row[3]){ // x1 = x2
                            for(int i = row[1]; i <= row[3]; i++){ // Se modifica la fila
                                diagram[i][row[0]]++;
                            }
                        }else{
                            for(int i = row[1]; i >= row[3]; i--){ // Se modifica la fila
                                diagram[i][row[0]]++;
                            }
                        }
                    }else if(row[1] == row[3]){
                        if(row[0] < row[2]){
                            for(int i = row[0]; i <= row[2]; i++){ // Se modifica la columna
                                diagram[row[1]][i]++;
                            }
                        }else{
                            for(int i = row[0]; i >= row[2]; i--){ // Se modifica la columna
                                diagram[row[1]][i]++;
                            }
                        }
                    }
                    j = 0;
                }
            }  
        }
        sc.close();
        
        for(int i = 0; i < 10000; i++){
            for(int k = 0; k < 10000; k++){
                if(diagram[i][k] >= 2){
                    dangerousAreas++;
                }
            }
        }
        System.out.println(dangerousAreas);
    }

    public static void second(){
        
    }

    public static void main(String[] args){
        first();
    }
}
