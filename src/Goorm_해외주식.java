import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Goorm_해외주식 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N= Integer.parseInt(br.readLine());
        int[][] arr = new int[N][2];
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            double amount = Double.parseDouble(st.nextToken());
            double price = Double.parseDouble(st.nextToken());
            int sum =(int) (amount * price*10);
            arr[i][0] = i;
            arr[i][1] = sum;
        }

        // Arrays.sort(arr,new Comparator<int[]>(){
        // 		public int compare(int[] o1, int[] o2){
        // 				if(o1[1] == o2[1]){
        // 						return o1[0]-o2[0];
        // 				}
        // 				else return o2[1]-o1[1];
        // 		}
        // }); // 시간초과되는문제있음

        Arrays.sort(arr, (o1, o2) -> o1[1] == o2[1] ? o1[0] - o2[0] : o2[1] - o1[1]);

        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i][0]+1);
            sb.append(" ");
        }
        System.out.println(sb);
    }
}
