import java.util.Scanner;

public class Calculator {
    private static boolean arabic_numbers = true;
     private static Boolean strI1 = false;
     private static Boolean strI2 = false;


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
                Integer i = null;
                Integer i2 = null;
                if (true) {
                    try {
                        i = Integer.parseInt(values1[0]);
                    } catch (NumberFormatException e) {
                        strI1=true;
                    }
                    try {
                        i2 = Integer.parseInt(values1[2]);
                    } catch (NumberFormatException e) {
                        strI2=true;
                    }
                    if (strI1 && strI2)
                    { arabic_numbers = false;} else { input=null;
                }}
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
        } catch (NullPointerException e) {
        }
    }
}
