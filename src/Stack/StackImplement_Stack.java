package Stack;

import java.io.*;
import java.util.Stack;

public class StackImplement_Stack {
    public static void main(String[] args) throws IOException {
        Stack<Integer> stack = new Stack<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            String a = br.readLine();
            String[] arr = a.split(" ");
            if(arr[0].equals("push")) stack.push(Integer.parseInt(arr[1]));
            if(arr[0].equals("pop")) {
                if(!stack.isEmpty()) bw.write(stack.pop() + "\n");
                else bw.write(-1 + "\n");
                bw.flush();
            }
            if(arr[0].equals("size")) {
                bw.write(stack.size() + "\n");
                bw.flush();
            }
            if(arr[0].equals("empty")) {
                if(stack.empty()) bw.write(1 + "\n");
                else bw.write(0 + "\n");
                bw.flush();
            }
            if(arr[0].equals("top")) {
                if(stack.empty()) bw.write(-1+"\n");
                else bw.write(stack.peek()+"\n");
                bw.flush();
            }
        }
        bw.close();
    }
}
