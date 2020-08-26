import java.util.Scanner;

public class Calculator {
    private static boolean arabic_numbers = true;
    private static boolean strI1 = true;
    private static boolean strI2 = true;


    private static String[] pars(String input) {
        String[] parsedInput = input.split(" ");
        if (parsedInput.length != 3) {
            input = null;
            return pars(input);
        } else {
            return parsedInput;
        }
    }


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите выражение, разделяя каждый символ пробелом: ");
        String input = scanner.nextLine();
       try {
           while (!input.equals(null)) {
               String[] values1 = Calculator.pars(input);
               String operation = values1[1];
               Number values;
               int i = 0;
               int i2 = 0;
               try {
                   i = Integer.parseInt(values1[0]);
               } catch (NumberFormatException e) {
                   strI1 = false;
               }
               try {
                   i2 = Integer.parseInt(values1[2]);
               } catch (NumberFormatException e) {
                   strI2 = false;
               }
               if (strI1 && strI2) {
                   arabic_numbers = false;
               }
               if (arabic_numbers) {
                   values = new ArabicNumber(i, i2);
               } else {
                   values = new RomesNumer(values1[0], values1[2]);
               }
               if (operation.equals("+")) {
                   values.sum();
               } else if (operation.equals("-")) {
                   values.sub();
               } else if (operation.equals("/")) {
                   values.div();
               } else if (operation.equals("*")) {
                   values.mul();
               }

               if (arabic_numbers) {
                   System.out.println("Ответ: " + values.getResult());
               } else {
                   System.out.println("Ответ: " + values.getStringResult());
               }
               System.out.println();
               input = null;
           }
       } catch (NullPointerException e){}
    }
}
