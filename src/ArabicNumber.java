
public class ArabicNumber extends Number {

    private int value1;
    private int value2;
    private int result;

    ArabicNumber(int value1, int value2) {
        if (value1 > 0 && value1 < 11) {
            this.value1 = value1;
        } else {
            System.out.println("");
        }
        if (value1 > 0 && value1 < 11) {
            this.value2 = value2;
        } else {
            System.out.println("");
        }
    }

    public void sum() {
        this.result = value1 + value2;
    }

    public void sub() {
        this.result = value1 - value2;
    }

    public void div() {
        this.result = value1 / value2;
    }

    public void mul() {
        this.result = value1 * value2;
    }

    @Override
    public int getResult() {
        return result;
    }

    @Override
    public String getStringResult() {
        return "" + result;
    }
}
