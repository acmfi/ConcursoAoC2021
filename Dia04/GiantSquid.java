import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Map.Entry;

public class GiantSquid {
    
    public static void first(){
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        String[] bingoNums = line.split(",");
        //List<String> bingoNums = new ArrayList<>(nums); // Numeros aleatorios
        List<String[][]> bingo = new ArrayList<>(); // Lista de cartillas 
        String[][] board = new String[5][5]; // Cartilla
        String[] row = new String[5];
        int i = 0; // fila
        
        //------------- Save sets of boards ------------//

        while(sc.hasNextLine()){
            line = sc.nextLine();
            if(line.equals("\n")){ //Indica nueva cartilla
                i = 0;
                line = sc.nextLine();
            }
            row = line.split(" ");
            for(int j = 0; j < 5; j++){
                board[i][j] = row[j];
            }
            if(i == 4){ // Cartilla completa
                bingo.add(board);
            }
            i++;
        }
        sc.close();

        //------------- CO2 scrubber rating -------------//

        for(int j = 0; j < bingoNums.length; j++){
            for(int k = 0; k < bingo.size(); k++){
                List<String[][]> actualBoard = bingo.get(k);
                Entry<Integer, Integer> pair = searchInBoard(actualBoard, Integer.parseInt(bingoNums[j]));
                if(pair != null){
                    // Marcar que el numero esta
                }
            }
        }
    }

    private static Entry<Integer, Integer> searchInBoard(String[][] board, int a){
        Entry<Integer, Integer> pair = null;
        boolean found = false;
        for(int j = 0; !found && j < 5; j++){
            for(int k = 0; !found && k < 5; k++){
                if(board[j][k].equals(a)){
                    found = true;
                    pair = new Entry<Integer,Integer>(j,k);
                }
            }
        }
        return pair;
    }

    public static void second(){
        
    }

    public static void main(String [] args){
        first();
        //second();
    }
}
