import java.util.*;

public class Calculator {

    public int run(String input) {
        Queue<String> queue = new LinkedList<>(Arrays.stream(input.split("")).toList());
        return parenthesesCheck(queue);
    }

    // 괄호 만나면 해당 괄호 값 정수로 반환
    public int parenthesesCheck(Queue<String> queue){
        StringBuilder sb = new StringBuilder();

        while(!queue.isEmpty()){
            String element = queue.poll();
            if(element.equals("(")){
                sb.append(parenthesesCheck(queue));
            }else if(element.equals(")")){
                break;
            }else {
                sb.append(element);
            }
        }

        return calculation(sb.toString());
    }

    // 괄호 없는 다항식 계산
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