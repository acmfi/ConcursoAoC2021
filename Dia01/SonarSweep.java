import java.util.Scanner;

public class SonarSweep{

    private static void first() {
        Scanner sc = new Scanner(System.in);
        String line;
        int actualNum;
        int prevNum;
        int counter = 0;
        line = sc.nextLine();
        prevNum = Integer.parseInt(line);
        while(sc.hasNextLine()){
            line = sc.nextLine();
            actualNum = Integer.parseInt(line);
            if(actualNum > prevNum){
                counter++;
            }
            prevNum = actualNum;
        }
        sc.close();
        System.out.println(counter);
    }

    private static void second() {
    }

    public static void main (String[] args){
        first();
        //second();
    }
    
}