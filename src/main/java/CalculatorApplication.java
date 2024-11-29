import java.util.*;

public class CalculatorApplication {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        Calculator cal = new Calculator();

        cal.run(scan.nextLine());
    }
}
