import java.io.*;
import java.util.*;

public class Solution {
	static int N;
	static int answer;
	static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        
        for (int test_case = 1; test_case <= T; test_case++) {
        	N = Integer.parseInt(br.readLine());
        	arr = new int[N];
        	answer = 0;
        	
        	dfs(0);
        	
        	bw.write("#" + test_case + " " + answer + " \n");
        }
       
        bw.flush();
        bw.close();
        br.close();
    }
    
    public static void dfs(int depth) {
    	if (depth >= N) {
    		answer++;
    		return;
    	}
    	
    	for (int i=0; i<N; i++) {
    		arr[depth] = i;
    		if (isPossible(depth)) {
    			dfs(depth+1);
    		}
    	}
    }
    
    public static boolean isPossible(int depth) {
    	for (int i=0; i< depth; i++) {
    		if (arr[i] == arr[depth]) {
    			return false;
    		}
    		
    		if (Math.abs(i-depth) == Math.abs(arr[i] - arr[depth])) {
    			return false;
    		}
    	}
    	
    	return true;
    }
}