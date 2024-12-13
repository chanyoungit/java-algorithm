import java.io.*;
import java.util.*;

class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = 10;

        for (int test_case = 1; test_case <= T; test_case++) {
        	int N = Integer.parseInt(br.readLine());
        	int[] arr = new int[8];
        	
        	st = new StringTokenizer(br.readLine());
        	for (int i=0; i<8; i++) {
        		arr[i] = Integer.parseInt(st.nextToken());
        	}
        	
        	int minus = 1;
        	boolean bl = true;
        	
        	while(true) {
        		arr[0] -= minus;
        		int temp = arr[0];
        		if (temp <= 0) {
        			temp = 0;
        			bl = false;
        		}
        		
        		for (int i=1; i<8; i++) {
        			arr[i-1] = arr[i];
        		}
        		arr[7] = temp;
        		
        		if (!bl) {
        			break;
        		}

        		minus++;
        		if (minus == 6) {
        			minus = 1;
        		}
        	}
        	
        	bw.write("#" + test_case + " ");
        	for (int i=0; i<8; i++) {
        		bw.write(arr[i] + " ");
        	}
        	bw.write("\n");
        }
        
        bw.flush();
        bw.close();
        br.close();
    }
}