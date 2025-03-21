import java.io.*;
import java.util.*;

import javax.swing.text.DefaultEditorKit.InsertBreakAction;

public class Solution {
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = 10;
        
        for (int test_case = 1; test_case <= T; test_case++) {
        	int N = Integer.parseInt(br.readLine());
        	int[] arr = new int[N];
        	
        	st = new StringTokenizer(br.readLine());
        	for (int i=0; i<N; i++) {
        		arr[i] = Integer.parseInt(st.nextToken());
        	}
        	
        	int answer = 0;
        	for (int i=2; i<N-2; i++) {
        		int leftMax = Math.max(arr[i-1], arr[i-2]);
        		int rightMax = Math.max(arr[i+1], arr[i+2]);
        		int max = Math.max(leftMax, rightMax);
        		
        		if (arr[i] > max) {
        			answer += (arr[i] - max);
        		}
        	}
        	
        	bw.write("#" + test_case + " " + answer + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}