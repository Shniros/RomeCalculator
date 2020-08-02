import java.util.Scanner;
//last commit
public class Demo {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        String mathLine = scan.nextLine();


        try {
            ReadString rs = new ReadString(mathLine);
            Calculator calc = new Calculator(rs.isRomeNumbers());
            String ansLine = calc.getResult(rs.nextNumber(),rs.nextOperation(),rs.nextNumber());

            System.out.println("Result: " + ansLine);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
