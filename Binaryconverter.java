import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Binaryconverter
 */
public class Binaryconverter {
    public static void main(String[] args) throws IOException {
        while (true) {
            
            int position1, position2, length;
            double currentNum, exponent, total;
            String binary;

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            System.out.print("Enter a binary number: ");
            binary = br.readLine();
            
            if (binary.matches("[0-1]+")){

                length = binary.length();
                exponent = binary.length();
                exponent = exponent - 1; 
                position1 = 0;
                position2 = 1;
                total = 0;
            
                for (int i = 0; i <= length; i++){
                
                    currentNum = Integer.parseInt(binary.substring(position1, position2));
    
                    if (currentNum == 1) {
                        currentNum =  1 * Math.pow(2, exponent);
                        total = total + currentNum;
                    } 
                    else {}

                    position1 = position1 + 1;
                    position2 = position2 + 1;
                    exponent = exponent -1;

                    if (position1 == length) {
                        break;
                    } 
                    else {
                        continue;
                    }
                }
                System.out.println((int)total);
            } else {
                System.out.println("Please enter bits that are 0's and 1's");
            }
        
        }
    }
}
