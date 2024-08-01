package Ml;

import java.util.LinkedList;
import java.util.Queue;

public class Queue_Truck {
    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> q = new LinkedList<>(); // 지정된 다리 길이만큼의 공간

        int sum = 0;
        int time = 0;

        for (int i = 0; i < truck_weights.length; i++) {
            int truck = truck_weights[i];

            while (true) {
                if (q.isEmpty()) {//큐가 비어있는 경우
                    q.offer(truck);
                    sum += truck;
                    time++;
                    break;
                } else if (q.size() == bridge_length)//큐에 트럭이 가득 찬 경우
                {
                    sum -= q.poll();//값 반환 후 삭제
                } else {//큐에 트럭이 가득 차지 않은 경우
                    if (sum + truck > weight)//현재 큐의 무게에 그 다음 트럭의 무게를 합친 값이 weight보다 크다면
                    {
                        q.offer(0);//큐에 0을 넣어주고 원래 있던 트럭을 앞으로 이동해준다
                        time++;
                    } else { // 현재 큐의 무게에 그 다음 트럭의 무게를 더한 값이 weight보다 같거나 작다면
                        q.offer(truck);
                        sum += truck;
                        time++;
                        break;
                    }

                }
            }
        }
        return time + bridge_length;
    }
}
