import java.io.IOException;

public class Calculator {
    Numbers iNumbers;
    public Calculator(boolean flag) throws IOException {
        iNumbers = new Numbers(flag);
    }
    public String getResult(int a, String oper,int b) throws Exception {
        switch (oper){
            case "+":
                return iNumbers.numberToString(Sum(a,b));
            case "/":
                return iNumbers.numberToString(division(a,b));
            case "*":
                return iNumbers.numberToString(multi(a,b));
            case "-":
                return iNumbers.numberToString(diff(a,b));
            default:{
                throw new Exception("Error operation: " + oper);
            }
        }
    }
    public int Sum(int a,int b){
        return a + b;
    }
    public int division(int a,int b){
        return a / b;
    }
    public int multi(int a, int b){
        return a * b;
    }
    public int diff(int a, int b){
        return a - b;
    }
}