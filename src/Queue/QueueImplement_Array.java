package Queue;

import java.io.*;

public class QueueImplement_Array {
    static int[] queue = new int[10001];
    static int first = 0;
    static int last = 0;

    static void push(int x){
        queue[last] = x;
        last++;
    }
    static int pop(){
        if (last-first==0) return -1;
        int x = queue[first];
        first++;
        return x;
    }
    static int size(){
        return last-first;
    }
    static int empty(){
        if (last-first==0) return 1;
        else return 0;
    }
    static int front(){
        if (last-first==0) return -1;

        return queue[first];
    }
    static int back(){
        if (last-first==0) return -1;

        return queue[last-1];
    }
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        queue = new int[N];

        for (int i = 0; i < N; i++) {
            String a = br.readLine();
            String[] arr = a.split(" ");

            if(arr[0].equals("push")) {
                push(Integer.parseInt(arr[1]));
            }
            if(arr[0].equals("pop")) {
                bw.write(pop()+"\n");
                bw.flush();
            }
            if(arr[0].equals("size")){
                bw.write(size()+"\n");
                bw.flush();
            }
            if(arr[0].equals("empty")){
                bw.write(empty()+"\n");
                bw.flush();
            }
            if(arr[0].equals("front")){
                bw.write(front()+"\n");
                bw.flush();
            }
            if(arr[0].equals("back")){
                bw.write(back()+"\n");
                bw.flush();
            }
        }
        bw.close();
    }
}
