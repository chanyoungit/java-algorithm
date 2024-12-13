import java.io.*;
import java.util.*;

class Solution {
	static ArrayList<Integer>[] al;
	static int answer;
	static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
        	st = new StringTokenizer(br.readLine());
        	int N = Integer.parseInt(st.nextToken());
        	int M = Integer.parseInt(st.nextToken());
        	
        	visited = new boolean[N+1];
        	al = new ArrayList[N+1];
        	for (int i=1; i<=N; i++) {
        		al[i] = new ArrayList<>();
        	}
        	
        	for (int i=0; i<M; i++) {
        		st = new StringTokenizer(br.readLine());
        		int x = Integer.parseInt(st.nextToken());
        		int y = Integer.parseInt(st.nextToken());
        		al[x].add(y);
        		al[y].add(x);
        	}
        	
        	answer = 1;
        	for (int i=1; i<=N; i++) {
        		if (!visited[i]) {
        			visited[i] = true;
        			dfs(i, 1);
        			visited[i] = false;
        		}
        	}
        	
        	bw.write("#" + test_case + " " + answer + "\n");
        }
        
        bw.flush();
        bw.close();
        br.close();
    }
    
    public static void dfs(int a, int depth) {
    	answer = Math.max(answer, depth);
    	
    	for (int i : al[a]) {
    		if(!visited[i]) {
    			visited[a] = true;
    			dfs(i, depth+1);
    			visited[a] = false;
    		}
    	}

    }
}