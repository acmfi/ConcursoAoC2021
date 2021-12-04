import java.util.Scanner;

public class SonarSweep{

    private static void first() {
        Scanner sc = new Scanner(System.in);
        String line;
        int actualNum;
        int prevNum;
        int incrCounter = 0;
        line = sc.nextLine();
        prevNum = Integer.parseInt(line);
        while(sc.hasNextLine()){
            line = sc.nextLine();
            actualNum = Integer.parseInt(line);
            if(actualNum > prevNum){
                incrCounter++;
            }
            prevNum = actualNum;
        }
        sc.close();
        System.out.println(incrCounter);
    }

    private static void second() {
        Scanner sc = new Scanner(System.in);
        String line;
        int actualNum;
        int prevNum1 = 0;
        int prevNum2 = 0;
        int actualSum = 0;
        int prevSum = 0;
        int incrCounter = 0;
        int elemCounter = 1;
        while(elemCounter < 4 && sc.hasNextLine()){
            line = sc.nextLine();
            actualNum = Integer.parseInt(line);
            prevSum += actualNum;
            if(elemCounter == 2){
                prevNum1 = actualNum;
            }else if (elemCounter == 3){
                prevNum2 = actualNum;
            }
            elemCounter++;
        }
        while(sc.hasNextLine()){
            line = sc.nextLine();
            actualNum = Integer.parseInt(line);
            actualSum = actualNum + prevNum1 + prevNum2;
            if(actualSum > prevSum){
                incrCounter++;
            }
            prevNum1 = prevNum2;
            prevNum2 = actualNum;
            prevSum = actualSum;
        }
        sc.close();
        System.out.println(incrCounter);
    }

    public static void main (String[] args){
        first();
        second();
    }
    
}