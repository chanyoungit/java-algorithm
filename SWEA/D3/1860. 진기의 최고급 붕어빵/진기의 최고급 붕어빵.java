import java.io.*;
import java.util.*;

class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
        	st = new StringTokenizer(br.readLine());
        	int N = Integer.parseInt(st.nextToken());		// 사람수
        	int M = Integer.parseInt(st.nextToken());		// 만드는 시간
        	int K = Integer.parseInt(st.nextToken());		// 붕어빵 개수
        	
        	int[] time = new int[N];		// 손님 도착하는 시간
        	
        	st = new StringTokenizer(br.readLine());
        	for (int i=0; i<N; i++) {
        		time[i] = Integer.parseInt(st.nextToken());
        	}
        	
        	Arrays.sort(time);
        	
        	boolean bl = true;
        	int made = 0;			// 만든 붕어빵의 개수		
        	int cnt = 0;			// 붕어빵 받은 사람 수
        	int idxTime = 0;		// time 현재 인덱스
        	int lastTime = time[N-1];
        	
        	if(time[0] == 0) {
        		bl = false;
        	} else {
        		for (int i=1; i<=lastTime; i++) {
        			if (i % M == 0) {
        				made += K;
        			}
        			
        			if (idxTime < N) {
        				if (i == time[idxTime]) {
        					if (made == 0) {
        						bl = false;
        						break;
        					}
        					made--;
        					idxTime++;
        				}
        			} else {
        				bl = false;
        				break;
        			}
        		}
        	}
        	
        	
        	if (bl) {
        		bw.write("#" + test_case + " Possible\n");
        	} else {
        		bw.write("#" + test_case + " Impossible\n");
        	}
        }
        
        bw.flush();
        bw.close();
        br.close();
    }
}