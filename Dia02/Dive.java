import java.util.Scanner;


public class Dive {

    public static void first(){
        Scanner sc = new Scanner(System.in);
        int depthPos = 0;
        int horizontalPos = 0;
        while(sc.hasNextLine()){
            String[] line = sc.nextLine().split(" ");
            int num = Integer.parseInt(line[1]);
            switch(line[0]){
                case "forward":
                    horizontalPos += num;
                    break;
                case "down":
                    depthPos += num;
                    break;
                case "up":
                    depthPos -= num;
                    break;
            }
        }
        sc.close();
        System.out.println(depthPos * horizontalPos);
    }

    public static void second(){
        Scanner sc = new Scanner(System.in);
        int depthPos = 0;
        int horizontalPos = 0;
        int aim = 0;
        while(sc.hasNextLine()){
            String[] line = sc.nextLine().split(" ");
            int num = Integer.parseInt(line[1]);
            switch(line[0]){
                case "forward":
                    horizontalPos += num;
                    depthPos += num * aim;
                    break;
                case "down":
                    aim += num;
                    break;
                case "up":
                    aim -= num;
                    break;
            }
        }
        sc.close();
        System.out.println(depthPos * horizontalPos);
    }

    public static void main (String[] args){
        //first();
        second();
    }
}
