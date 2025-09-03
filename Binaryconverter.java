import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BinaryConverter {

    //validates binary input
    private static boolean isBinary(String s) {
        return s != null && s.matches("[01]+");
    }

    public static void main(String[] args) throws IOException {
        while (true) {

            int position1, position2, length, positionCount, total;
            double currentNum, exponent;
            String binary, response;
            String hexa = ""; 
            char currentChar = '0';

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            System.out.print("Do you want to convert to hexadecimal or decimal: ");
            response = br.readLine();

            if ("hexidecimal".equalsIgnoreCase(response) || "hexadecimal".equalsIgnoreCase(response)|| "hexa".equalsIgnoreCase(response)) {
                System.out.println("You have choosen Hexadecimal");
                System.out.print("Enter a binary number: ");
                binary = br.readLine();

                if (isBinary(binary)) {

                    length = binary.length();
                    System.out.println("Length of binary: " + length);

                    if ((length - 3) % 4 == 0) {
                        exponent = 2;
                        positionCount = 1;
                    } else if ((length - 2) % 4 == 0) {
                        exponent = 1;
                        positionCount = 2;
                    } else if ((length - 1) % 4 == 0) {
                        exponent = 0;
                        positionCount = 3;
                    } else {
                        exponent = 3;
                        positionCount = 0;
                    }

                    position1 = 0;
                    position2 = 1;
                    total = 0;

                    for (int i = 0; i < length; i++) {

                        currentNum = Integer.parseInt(binary.substring(position1, position2));

                        if (currentNum == 1) {
                            System.out.println("Current Num before exponent: " + currentNum);
                            currentNum = Math.pow(2, exponent);
                            System.out.println("current num:" +currentNum);
                            total += (int) currentNum;
                            System.out.println("the exponent: "+ exponent);
                        } else{
                            System.out.println("current num: " + currentNum);
                            total += 0;
                        }

                        if (positionCount == 3) {
                            switch (total) {
                                case 15: currentChar = 'F'; break;
                                case 14: currentChar = 'E'; break;
                                case 13: currentChar = 'D'; break;
                                case 12: currentChar = 'C'; break;
                                case 11: currentChar = 'B'; break;
                                case 10: currentChar = 'A'; break;
                                case 9: currentChar = '9'; break;
                                case 8: currentChar = '8'; break;
                                case 7: currentChar = '7'; break;
                                case 6: currentChar = '6'; break;
                                case 5: currentChar = '5'; break;
                                case 4: currentChar = '4'; break;
                                case 3: currentChar = '3'; break;
                                case 2: currentChar = '2'; break;
                                case 1: currentChar = '1'; break;
                                case 0: currentChar = '0'; break;
                                default: break;
                            }
                            hexa = hexa + currentChar;
                            System.out.println("currentChar: "+ currentChar);
                            positionCount = 0;
                            total = 0;
                            exponent = 3;
                            position1++;
                            position2++;
                        } else {
                            positionCount++;
                            position1++;
                            position2++;
                            exponent--;
                        }

                        if (position1 == length) {
                            break;
                        }
                    }
                    System.out.println(hexa);
                } else {
                    System.out.println("Please enter bits that are 0's and 1's");
                }
            } else { //decimal
                System.out.println("You have choosen decimal");
                System.out.print("Enter a binary number: ");
                binary = br.readLine();

                if (isBinary(binary)) {

                    length = binary.length();
                    exponent = length - 1;
                    position1 = 0;
                    position2 = 1;
                    int totalDec = 0;

                    for (int i = 0; i < length; i++) {

                        currentNum = Integer.parseInt(binary.substring(position1, position2));

                        if (currentNum == 1) {
                            totalDec += (int) Math.pow(2, exponent);
                        }

                        position1++;
                        position2++;
                        exponent--;

                        if (position1 == length) {
                            break;
                        }
                    }
                    System.out.println(totalDec);
                } else {
                    System.out.println("Please enter bits that are 0's and 1's");
                }
            }
        }
    }
}
