package Programmers;

public class Pro_숫자의표현 {
    public int solution(int n) {
        int answer = 0;
        int sum = 0;

        for(int j=1; j<=n; j++){
            sum = 0;
            for(int i=j; i<=n; i++){
                sum += i;

                if(sum == n){
                    answer++;
                    break;
                }
                else if( sum > n){
                    break;
                }
            }
        }
        return answer;
    }
}
