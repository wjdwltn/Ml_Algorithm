package Ml;

import java.util.*;

public class Pro_과제진행하기 {
    public String[] solution(String[][] plans) {
        List<String> answer = new ArrayList<>();
        Stack<String[]> stop = new Stack<>();
        Arrays.sort(plans,(a,b)->ToMinute(a[1])-ToMinute(b[1]));

        for(int i=0; i<plans.length-1; i++){
            String p_name = plans[i][0];
            int p_start = ToMinute(plans[i][1]);
            int p_playtime = Integer.parseInt(plans[i][2]);
            int next = ToMinute(plans[i+1][1]);

            if(next-p_start < p_playtime){
                stop.push(new String[]{p_name, p_playtime-(next-p_start)+""});
                continue;
            }
            //과제가 중간에 멈추지 않고 계속 진행됐다면
            answer.add(p_name);
            int remain = next - (p_start + p_playtime);
            while(!stop.isEmpty()){
                String[] work = stop.pop();
                int stop_re = Integer.parseInt(work[1]);
                if(remain >=stop_re){
                    answer.add(work[0]);
                    remain-=stop_re;
                }
                else{
                    stop.push(new String[]{work[0],stop_re-remain+""});
                    break;
                }
            }
        }
        answer.add(plans[plans.length-1][0]);
        while(!stop.isEmpty()){
          answer.add(stop.pop()[0]);
        }
        return answer.toArray(new String[answer.size()]);
    }
    public int ToMinute (String time){
        String[] t = time.split(":");
        int h = Integer.parseInt(t[0])*60;
        int m = Integer.parseInt(t[1]);
        return h+m;
    }
}
