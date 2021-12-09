import java.util.Scanner;

public class SegmentSearch {
    
    public static void first(){
        Scanner sc = new Scanner(System.in);
        Scanner scanner = null;
        String line;
        String element;
        int size;
        int uniqueNumber = 0;
        boolean found = false;
        while(sc.hasNextLine()){
            line = sc.nextLine();
            scanner = new Scanner(line);
            found = false;
            while(scanner.hasNext()){
                element = scanner.next();
                if(element.equals("|")){
                    found = true;
                }
                else if(found){
                    size = element.length();
                    if(size == 2 || size == 3 || size == 4 || size == 7){
                        uniqueNumber++;
                    }
                }   
            }
        }
        sc.close();
        System.out.println(uniqueNumber);
    }

    public static void second(){

    }

    public static void main(String[] args){
        first();
    }
}
