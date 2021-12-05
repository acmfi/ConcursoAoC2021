import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BinaryDiagnostic {
    
        public static void first(){
            Scanner sc = new Scanner(System.in);
            List<String> listO2 = new ArrayList<>();
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
                listO2.add(line);
            }
            sc.close();
            for(int i = 0; i < listO2.get(0).length(); i++){
                zerosCounter = 0;
                onesCounter = 0;
                for(int j = 0; j < listO2.size(); j++){
                    cBit = listO2.get(j).charAt(i);
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
            Scanner sc = new Scanner(System.in);
            List<String> listO2 = new ArrayList<>();
            String line;
            String o2Rate = "";      // Mayor bit
            String co2Rate = "";     // Menor bit
            Character cBit;                
            int bit;
            int zerosCounter;
            int onesCounter;
            int decimalO2 = 0;
            int decimalCO2 = 0;
            int lifeRating;

            while(sc.hasNextLine()){
                line = sc.nextLine();
                listO2.add(line);
            }

            List<String> listCO2 = new ArrayList<>(listO2);
            sc.close();

            //------------- Oxygen generator rating -------------//

            for(int i = 0; listO2.size() > 1 && i < listO2.get(0).length(); i++){
                zerosCounter = 0;
                onesCounter = 0;

                // Miro si hay mas 0 o 1
                for(int j = 0; j < listO2.size(); j++){
                    cBit = listO2.get(j).charAt(i);
                    bit = Integer.parseInt(cBit.toString());
                    if(bit == 0){
                        zerosCounter++;
                    }else{
                        onesCounter++;
                    }
                }
                
                // Para el O2 el mas comun
                if(onesCounter >= zerosCounter){    // Si hay mas 1 
                    listO2 = removeBit(listO2, i, 0);   // se quitan los 0 de la lista
                }else{                              // Si hay mas 0
                    listO2 = removeBit(listO2, i, 1);   // se quitan los 1 de la lista
                }
            }

            if(listO2.size() == 1){
                o2Rate = listO2.get(0);
                decimalO2 = Integer.parseInt(o2Rate, 2);
                //powerConsumption = decimalO2 * decimalCO2;
                System.out.println(decimalO2);
            }

            //------------- CO2 scrubber rating -------------//

            for(int i = 0; listCO2.size() > 1 && i < listCO2.get(0).length(); i++){
                zerosCounter = 0;
                onesCounter = 0;

                // Miro si hay mas 0 o 1
                for(int j = 0; j < listCO2.size(); j++){
                    cBit = listCO2.get(j).charAt(i);
                    bit = Integer.parseInt(cBit.toString());
                    if(bit == 0){
                        zerosCounter++;
                    }else{
                        onesCounter++;
                    }
                }
                
                // Para el CO2 el menos comun
                if(onesCounter >= zerosCounter){    // Si hay mas 1 
                    listCO2 = removeBit(listCO2, i, 1);   // se quitan los 1 de la lista
                }else{                              // Si hay mas 0
                    listCO2 = removeBit(listCO2, i, 0);   // se quitan los 0 de la lista
                }
            }

            if(listCO2.size() == 1){
                co2Rate = listCO2.get(0);
                decimalCO2 = Integer.parseInt(co2Rate, 2);
                System.out.println(decimalCO2);
            }

            //------------- Life support rating -------------//

            lifeRating = decimalO2 * decimalCO2;
            System.out.println(lifeRating);
    }

        private static List<String> removeBit(List<String> list, int i, int b){
            List<String> listRes = new ArrayList<>(list);
            for(int j = 0; j < list.size(); j++){
                Character cBit = list.get(j).charAt(i);
                int bit = Integer.parseInt(cBit.toString());
                if(bit == b){
                     listRes.remove(list.get(j)); 
                }
            }
            return listRes;
        }
        
        public static void main(String[] args){
            //first();
            second();
        }
}
