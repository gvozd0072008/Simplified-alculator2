public class RomesNumer extends Number {
    private int anInt;
    private int anInt2;
    private int resultInt;
    private String sign = "";
    private String resultString;
    private final String[] roman = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};

    RomesNumer(String value1, String value2) {

            this.anInt = convertToInt(value1);
            this.anInt2 = convertToInt(value2);


    }

    private String convertResultToRomes(int n, int r) {
        r = n % 10;
        if (r != 0) {
            try {
                return convertResultToRomes(n - r, 0) + roman[r - 1];
            } catch (ArrayIndexOutOfBoundsException e) {
                sign = "-";
                return convertResultToRomes(n - r, 0) + roman[(r + 1) * -1];
            }
        }
        if (n > 0) {
            n = n - 10;
            return convertResultToRomes(n, 0) + "X";
        } else if (n < 0) {
            n = n + 10;
            return convertResultToRomes(n, 0) + "X";
        } else {
            return sign;
        }
    }

    @Override
    public void sum() {
        resultInt = anInt + anInt2;
        resultString = convertResultToRomes(resultInt, resultInt);
    }

    @Override
    public void sub() {
        resultInt = anInt - anInt2;
        resultString = convertResultToRomes(resultInt, resultInt);
    }

    @Override
    public void div() {
        resultInt = anInt / anInt2;
        resultString = convertResultToRomes(resultInt, resultInt);
    }

    @Override
    public void mul() {
        resultInt = anInt * anInt2;
        resultString = convertResultToRomes(resultInt, resultInt);
    }

    @Override
    public int getResult() {
        return resultInt;
    }

    public String getStringResult() {
        return resultString;
    }

    private int convertToInt(String romesValue) {
        char[] valueChar = romesValue.toCharArray();
        int[] valuesInt = new int[valueChar.length];
        for (int i = 0; i < valueChar.length; i++) {
            switch (valueChar[i]) {
                case 'I':
                    valuesInt[i] = 1;
                    break;
                case 'i':
                    valuesInt[i] = 1;
                    break;
                case 'V':
                    valuesInt[i] = 5;
                    break;
                case 'v':
                    valuesInt[i] = 5;
                    break;
                case 'X':
                    valuesInt[i] = 10;
                    break;
                case 'x':
                    valuesInt[i] = 10;
                    break;
                default:
                    break;
            }
        }
        int result = valuesInt[0];
        for (int i = 0; i < valuesInt.length && valuesInt.length > i + 1; i++) {
            if (valuesInt[i] >= valuesInt[i + 1]) {
                result += valuesInt[i + 1];
            } else if (valuesInt[i] < valuesInt[i + 1]) {
                result = result + valuesInt[i + 1] - 2;
            }
        }
        return result;
    }
}
