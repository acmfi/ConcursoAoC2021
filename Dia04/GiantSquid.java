import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.AbstractMap.SimpleEntry;
import java.util.Map.Entry;

public class GiantSquid {

    private static Scanner sc;
    private static String line;
    private static int intLine;
    private static String[] bingoNums;
    private static int i; 
    private static int n;
    private static List<List<Entry<Integer, Boolean>>> board;          // Cartilla (lista formada por lista de columnas)
    private static List<List<List<Entry<Integer, Boolean>>>> bingo;    // Lista de cartillas
    private static List<List<List<Entry<Integer, Boolean>>>> winners;  // Lista de ganadores
    private static Entry<Integer, Boolean> numPair;
    private static Boolean winnerFound;
    private static Boolean numberFound;
    private static Boolean lastWinner;
    private static int score;

    public static void first(){
        i = 0;
        n = 0;
        sc = new Scanner(System.in);
        board = new ArrayList<>();  
        bingo = new ArrayList<>(); 
        numPair = null;
        winnerFound = false;
        numberFound = false;
        score = 0;

        readRandomNumbers();
        saveBoards();

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

    public static void second(){
        i = 0;
        n = 0;
        sc = new Scanner(System.in);
        board = new ArrayList<>();  
        bingo = new ArrayList<>(); 
        winners = new ArrayList<>();
        numPair = null;
        winnerFound = false;
        numberFound = false;
        lastWinner = false;
        score = 0;

        readRandomNumbers();
        saveBoards();

        //------------- Read numbers and mark them -------------//

        for(int j = 0; !lastWinner && j < bingoNums.length; j++){
            Integer number = Integer.parseInt(bingoNums[j]);        // Numero a marcar
            numPair = new SimpleEntry<>(number, false);
            for(int k = 0; !lastWinner && k < bingo.size(); k++){ // Para cada cartilla
                numberFound = false;
                winnerFound = false;
                board = bingo.get(k);
                for(int col = 0; !lastWinner && !winners.contains(board) && !numberFound && !winnerFound && col < board.size(); col++){ // Para cada columna
                    int index = board.get(col).indexOf(numPair);                             // Busca el elemento en la columna y devuelve la pos
                    if(index != -1){                                                         // Existe ocurrencia en la columna
                        numberFound = true;
                        board.get(col).get(index).setValue(true);
                        // Mirar si es cartilla ganadora (fila o columna marcadas)
                        boolean winner = isWinner(board, index, col); // Le paso la posicion del elemento
                        if(winner){
                            winners.add(board);
                            winnerFound = true;
                            if(winners.size() == bingo.size()){ 
                                lastWinner = true;
                                score = getScore(board, number);
                            }
                        }
                    }
                }
            }
        }
        System.out.println(score);
    }

    //------------- Auxiliar methods -------------//
 
    private static void readRandomNumbers(){
        line = sc.nextLine();
        bingoNums = line.split(",");
    }

    private static void saveBoards(){
        for(int j = 0; j < 5; j++){    //Inicializo columnas
            board.add(new ArrayList<Entry<Integer, Boolean>>());
        }
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
            if(i == 4){    // Se completa una fila                        
                i = -1;
                n++; 
            }
            i++;
        }
        sc.close();
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
    
    public static void main(String [] args){
        //first();
        second();
    }
}