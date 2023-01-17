import java.util.ArrayList;
import java.util.Stack;

public class Browser {
    public static void main(String[] args) {
        String[] actions = new String[]{"B", "C", "-1", "D", "A", "-1", "1", "-1", "-1"};
        String start = "A";
        ArrayList<Stack> output = browserStack(actions, start);
    }
    public static ArrayList<Stack> browserStack(String[] actions, String start) {
        Stack<String> prevStack = new Stack<>();
        Stack<String> nextStack = new Stack<>();
        Stack<String> current = new Stack<>();
        ArrayList<Stack> result = new ArrayList<>();

        current.push(start);
        for (String s : actions) {
            if (s.equals("-1") && !prevStack.isEmpty()) {
                nextStack.push(current.pop());
                current.push(prevStack.pop());
            }
            if (s.equals("1") && !nextStack.isEmpty()) {
                prevStack.push(current.pop());
                current.push(nextStack.peek());
                nextStack.pop();
            }
            else if(s.equals("1")||s.equals("-1")){
                continue;
            }
            else{
                prevStack.push(current.pop()); //현재페이지 빼고 이전페이지로
                current.push(s);    //새페이지 열기
                nextStack.clear();
            }
        }

        result.add(prevStack);
        result.add(current);
        result.add(nextStack);

        return result;
    }
}
