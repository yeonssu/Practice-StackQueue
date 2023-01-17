import java.util.*;

public class Box {
    public static void main(String[] args) {
        Integer[] boxes1 = new Integer[]{5};
        int output = paveBox(boxes1);
        System.out.println(output); // 5

        Integer[] boxes2 = new Integer[]{1, 5, 7, 9};
        int output2 = paveBox(boxes2);
        System.out.println(output2); // 1
    }
    public static int paveBox(Integer[] boxes) {
        Queue<Integer> line = new LinkedList<>(Arrays.asList(boxes));
        ArrayList<Integer> result = new ArrayList<>();
        if(line.isEmpty()) return 0; //빈배열을 입력받은 경우

        int num = line.poll(); //첫번째사람
        int count = 1; //같이 나갈 수 있는 인원 카운트
        while (!line.isEmpty()){

            int compare = line.poll();
            if(compare > num){
                result.add(count);
                num = compare;
                count = 1;
            }else{
                count++;
            }
            //마지막요소의 count 추가
            if (line.size()==0) result.add(count);
        }
        System.out.println(result);
        if(result.isEmpty()) return 1;//while문이 실행되지 않았을 경우
        return Collections.max(result);
    }
}
