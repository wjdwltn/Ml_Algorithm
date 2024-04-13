import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Reverse_9093 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder answer = new StringBuilder();
        for(int i=0; i<T; i++) {
            String str = br.readLine(); // 문장 입력받기
            String[] arrs = str.split(" ");

            for(String arr : arrs ){
                StringBuilder sb = new StringBuilder(arr);
                answer.append(sb.reverse()).append(" ");
            }
            answer.append("\n");
        }
        System.out.println(answer);
    }
}
