import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BinaryDiagnostic {
    
        public static void first(){
            Scanner sc = new Scanner(System.in);
            List<String> lista = new ArrayList<>();
            String line;
            String gammaRate = "";      // Mayor bit
            String epsilonRate = "";    // Menor bit
            Character cBit;                
            int bit;
            int zerosCounter;
            int onesCounter;
            int decimalEps;
            int decimalGam;
            int powerConsumption;
            while(sc.hasNextLine()){
                line = sc.nextLine();
                lista.add(line);
            }
            for(int i = 0; i < lista.get(0).length(); i++){
                zerosCounter = 0;
                onesCounter = 0;
                for(int j = 0; j < lista.size(); j++){
                    cBit = lista.get(j).charAt(i);
                    bit = Integer.parseInt(cBit.toString());
                    if(bit == 0){
                        zerosCounter++;
                    }else{
                        onesCounter++;
                    }
                }
                if(onesCounter > zerosCounter){
                    gammaRate = gammaRate.concat("1");
                    epsilonRate = epsilonRate.concat("0");
                }else{
                    gammaRate = gammaRate.concat("0");
                    epsilonRate = epsilonRate.concat("1");
                }
            }
            decimalEps = Integer.parseInt(epsilonRate, 2);
            decimalGam = Integer.parseInt(gammaRate, 2);
            powerConsumption = decimalEps * decimalGam;
            System.out.println(powerConsumption);
        }
    
        public static void second(){

        }

        public static void main(String[] args){
            first();
            //second();
        }
}
