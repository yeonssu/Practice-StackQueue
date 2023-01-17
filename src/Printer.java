import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Printer {
    public static void main(String[] args) {
        int bufferSize = 4;
        int capacities = 10;
        int[] documents = new int[]{7, 5, 4, 2};

        int output = queuePrinter(bufferSize, capacities, documents);
        System.out.println(output); // 8
    }
    // 0007 -> 0070 -> 0700 -> 7000 -> 0004 -> 0045-> 0450-> 4500 -> 5002 -> 0020 -> 0200 -> 2000 -> 0000
    public static int queuePrinter(int bufferSize, int capacities, int[] documents) {
        Queue<Integer> buffer = new LinkedList<>();
        for (int i = 0; i < bufferSize; i++) {
            buffer.add(0);
        }

        // 1초 : 첫번째 요소 맨 뒤에 추가
        int result = 1;
        buffer.poll();
        buffer.add(documents[0]);
        int sum = documents[0];

        // 2초부터 최대용량을 기준으로
        int i=1;
        while(sum!=0){
            if(i==documents.length){
                result = result + bufferSize;
                break;
            }

            if(sum - buffer.peek() + documents[i] <=capacities){ //맨 앞 제거 후 추가 했을 때 수용량보다 작거나 같을 경우
                sum -= buffer.poll();
                buffer.add(documents[i]);
                sum += documents[i];
                i++;
            }else { //맨 앞 제거 후 추가했을 때 수용량보다 클 경우
                sum -= buffer.poll();
                buffer.add(0);
            }
            result++;
        }
        return result;
    }
}
