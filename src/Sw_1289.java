import java.util.*;
import java.io.*;

public class Sw_1289 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        char after;
        int count;
        for(int i=0; i<T; i++){
            String origin  = br.readLine();
            after='0';
            count=0;
            for(int j=0; j<origin.length(); j++){
                if(origin.charAt(j)  != after){
                    after = origin.charAt(j);
                    count++;
                }
            }
            System.out.printf("#%d %d\n", i, count);

        }

    }
}
//*
// 입력받은 t의 for문을 돌려서 해당 위치의 숫자가 1이면
// check = 1; count++;
// 그 다음이 check랑 같으면 continue; 다르면 count ++
// */