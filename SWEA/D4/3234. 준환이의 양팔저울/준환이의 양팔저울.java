import java.io.*;
import java.util.*;

class Solution {
	static int[] arr;
	static int answer;
	static int N;
	static boolean[] visited;
	static int index;
	static int[] sorted;
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
     
        int T = Integer.parseInt(br.readLine());
        
        for (int test_case = 1; test_case <= T; test_case++) {
        	N = Integer.parseInt(br.readLine());
        	arr = new int[N];
        	visited = new boolean[N];
        	index = 0;
        	sorted = new int[N];
        	
        	st = new StringTokenizer(br.readLine());
        	for (int i=0; i<N; i++) {
        		arr[i] = Integer.parseInt(st.nextToken());
        	}
        	
        	answer = 0;
        	check(0);
        	
        	bw.write("#" + test_case + " " + answer + "\n");
        }
        
        bw.flush();
        bw.close();
        br.close();
    }
    
    public static void check(int depth) {
    	if (depth == N) {
    		dfs(0,0,0);
    	}
    	
    	for (int i=0; i<N; i++) {
    		if (!visited[i]) {
    			visited[i] = true;
    			sorted[depth] = arr[i];
    			check(depth+1);
    			visited[i] = false;
    		}
    	}
    }
    
    public static void dfs(int leftSum, int rightSum, int depth) {
    	if (depth == N) {
    		if (leftSum >= rightSum) {
        		answer++;
        		return;
        	}
    	}
    	
    	if (leftSum < rightSum) {
    		return;
    	}
    	
    	dfs(leftSum + sorted[depth] , rightSum, depth+1);
		dfs(leftSum, rightSum + sorted[depth], depth+1);

    }
}