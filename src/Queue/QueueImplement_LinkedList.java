package Queue;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class QueueImplement_LinkedList {
    public static void main(String[] args) throws IOException {
        Queue<Integer> queue = new LinkedList<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int last = 0;

        for (int i = 0; i < N; i++) {
            String a = br.readLine();
            String[] arr = a.split(" ");

            if (arr[0].equals("push")) {
                last = Integer.parseInt(arr[1]);
                queue.add(last);
            }
            if (arr[0].equals("pop")) {
                if (queue.isEmpty()) bw.write(-1 + "\n");
                else bw.write(queue.poll() + "\n");
                bw.flush();
            }
            if (arr[0].equals("size")) {
                bw.write(queue.size() + "\n");
                bw.flush();
            }
            if (arr[0].equals("empty")) {
                if (queue.isEmpty()) bw.write(1+"\n");
                else bw.write(0+"\n");
                bw.flush();
            }
            if (arr[0].equals("front")) {
                if (queue.isEmpty()) bw.write(-1 + "\n");
                else bw.write(queue.peek() + "\n");
                bw.flush();
            }
            if (arr[0].equals("back")) {
                if (queue.isEmpty()) bw.write(-1 + "\n");
                else bw.write(last+"\n");
                bw.flush();
            }
        }
    }
}
