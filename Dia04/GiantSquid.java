import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.AbstractMap.SimpleEntry;
import java.util.Map.Entry;

public class GiantSquid {
    
    public static void first(){
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        int intLine;
        String[] bingoNums = line.split(",");
        int i = 0; 
        int n = 0;
        List<List<Entry<Integer, Boolean>>> board = new ArrayList<>();          // Cartilla (lista formada por lista de columnas)
        List<List<List<Entry<Integer, Boolean>>>> bingo = new ArrayList<>();    // Lista de cartillas
        Entry<Integer, Boolean> numPair = null;
        Boolean winnerFound = false;
        Boolean numberFound = false;
        int score = 0;

        for(int j = 0; j < 5; j++){                                 //Inicializo columnas
            board.add(new ArrayList<Entry<Integer, Boolean>>());
        }
        //------------- Save sets of boards ------------//
        while(sc.hasNextInt()){
            intLine = sc.nextInt();
            numPair = new SimpleEntry<>(intLine, false);     // Inicializo el par con el numero y no marcado
            board.get(i).add(numPair);                       // Añado el par a la cartilla
            if(i == 4 && n == 4 ){                           // Se completa una cartilla
                bingo.add(board);
                board = new ArrayList<>();
                for(int j = 0; j < 5; j++){
                    board.add(new ArrayList<Entry<Integer, Boolean>>());
                }
                n = -1;
            } 
            if(i == 4){                                       // Se completa una fila                        
                i = -1;
                n++; 
            }
            i++;
        }
        sc.close();

        //------------- Read numbers and mark them -------------//

        for(int j = 0; !winnerFound && j < bingoNums.length; j++){
            Integer number = Integer.parseInt(bingoNums[j]);        // Numero a marcar
            numPair = new SimpleEntry<>(number, false);
            for(int k = 0; !winnerFound && k < bingo.size(); k++){ // Para cada cartilla
                numberFound = false;
                board = bingo.get(k);
                for(int col = 0; !numberFound && !winnerFound && col < board.size(); col++){ // Para cada columna
                    int index = board.get(col).indexOf(numPair);                             // Busca el elemento en la columna y devuelve la pos
                    if(index != -1){                                                         // Existe ocurrencia en la columna
                        numberFound = true;
                        board.get(col).get(index).setValue(true);
                        // Mirar si es cartilla ganadora (fila o columna marcadas)
                        boolean winner = isWinner(board, index, col); // Le paso la posicion del elemento
                        if(winner){
                            winnerFound = true;
                            score = getScore(board, number);
                        }
                    }
                }
            }
        }
        System.out.println(score);
    }

    private static boolean isWinner(List<List<Entry<Integer, Boolean>>> board, int index, int col){
        boolean isWinner1 = true;
        boolean isWinner2 = true;
        for(int i = 0; isWinner1 && i < board.size(); i++){
            isWinner1 = board.get(col).get(i).getValue();
        }
        for(int i = 0; !isWinner1 && isWinner2 && i < board.size(); i++){
            isWinner2 = board.get(i).get(index).getValue();
        }
        return isWinner1 || isWinner2;
    }

    private static int getScore(List<List<Entry<Integer, Boolean>>> board, Integer number){
        int score = 0;
        for(int i = 0; i < board.size(); i++){  // Para cada columna 
            for(int j = 0; j < board.size(); j++){
                Entry<Integer, Boolean> pair = board.get(i).get(j);
                if(pair.getValue() == false){
                    score += pair.getKey();
                }
            }
        }
        return score * number;
    }

    public static void second(){
        
    }

    public static void main(String [] args){
        first();
        //second();
    }
}
