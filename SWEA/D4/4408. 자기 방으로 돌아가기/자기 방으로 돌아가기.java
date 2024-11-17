import java.io.*;
import java.util.*;

class Solution {
	
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        int T = Integer.parseInt(br.readLine());
        
        for (int test_case = 1; test_case <= T; test_case++) {
        	int[] corr = new int[201];
        	
        	int N = Integer.parseInt(br.readLine());
        	for (int i=0; i<N; i++) {
        		st = new StringTokenizer(br.readLine());
        		int a = Integer.parseInt(st.nextToken());
        		int b = Integer.parseInt(st.nextToken());
        		
        		if (a>b) {
        			int temp = a;
        			a = b;
        			b = temp;
        		}
        		
        		int s = 0;
        		int e = 0;
        		
        		if (a%2 == 0) {
        			s = a/2;
        		} else {
        			s = a/2 + 1;
        		}
        		
        		if (b%2 == 0) {
        			e = b/2;
        		} else {
        			e = b/2 + 1;
        		}
        		
        		for (int j=s; j<=e; j++) {
        			corr[j]++;
        		}
        	}
        	
        	int max = 0;
        	for (int i=1; i<201; i++) {
        		if (max < corr[i]) {
        			max = corr[i];
        		}
        	}
        	
        	bw.write("#" + test_case + " " + max + "\n");
        }
        
        bw.flush();
        bw.close();
        br.close();
    }
}