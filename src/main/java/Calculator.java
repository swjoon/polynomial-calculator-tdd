import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Calculator {

    public int run(String input) {
       // List<String> list = new ArrayList<>(Arrays.stream(input.split("")).toList());
        return calculation(input);
    }

    public int calculation(String polynomial){
        List<String> elements = new ArrayList<>(Arrays.stream(polynomial.split(" ")).toList());
        List<Integer> num = new ArrayList<>();
        List<String> operator = new ArrayList<>();

        for(String e : elements){
            if(e.equals("+") || e.equals("-") ||e.equals("*") ||e.equals("/")){
                operator.add(e);
            }else{
                num.add(Integer.parseInt(e));
            }
        }

        for(int i = 0; i < operator.size(); i++){
            if(operator.get(i).equals("*")){
                operator.remove(i);
                num.set(i,product(num.get(i),num.remove(i+1)));
                i--;
            }else if(operator.get(i).equals("/")){
                operator.remove(i);
                num.set(i,division(num.get(i),num.remove(i+1)));
                i--;
            }
        }

        for(int i = 0; i < operator.size(); i++){
            if(operator.get(i).equals("+")){
                operator.remove(i);
                num.set(i,plus(num.get(i),num.remove(i+1)));
                i--;
            }else if(operator.get(i).equals("-")){
                operator.remove(i);
                num.set(i,minus(num.get(i),num.remove(i+1)));
                i--;
            }
        }

        return num.get(0);
    }


    public int plus(int a, int b) {
        return a + b;
    }

    public int minus(int a, int b){
        return a - b;
    }

    public int product(int a, int b){
        return a * b;
    }

    public int division(int a, int b){
        return a / b;
    }
}

// 재귀
// 1. 괄호 없는 상태 계산 메소드
// 2. 괄호 확인시 재귀 발동 -> 닫는 괄호 확인시 해당 문자열 1번 계산 후 반환
// 3. (1 + 2 * (1 + 2 / 3 - 4 * 5))