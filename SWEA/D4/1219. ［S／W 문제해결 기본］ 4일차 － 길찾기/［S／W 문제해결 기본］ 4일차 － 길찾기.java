import java.io.*;
import java.util.*;

class Solution {
	static ArrayList<Integer>[] al;
	static boolean[] visited;
	static boolean bl;
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
     
        int T = 10;
        
        for (int test_case = 1; test_case <= T; test_case++) {
        	st = new StringTokenizer(br.readLine());
        	int seq = Integer.parseInt(st.nextToken());
        	int N = Integer.parseInt(st.nextToken());
        	
        	bl = false;
        	visited = new boolean[100];
        	al = new ArrayList[100];
        	for (int i=0; i<100; i++) {
        		al[i] = new ArrayList<>();
        	}
        	
        	st = new StringTokenizer(br.readLine());
        	for (int i=0; i<N; i++) {
        		int a = Integer.parseInt(st.nextToken());
        		int b = Integer.parseInt(st.nextToken());
        		
        		al[a].add(b);
        	}
        	
        	bfs(0);
        	
        	if(bl) {
        		bw.write("#" + test_case + " 1\n");
        	} else {
        		bw.write("#" + test_case + " 0\n");
        	}
        }
        
        bw.flush();
        bw.close();
        br.close();
    }
    
    public static void bfs(int start) {
    	visited[start] = true;
    	Queue<Integer> queue = new LinkedList<>();
    	queue.add(start);
    	
    	while(!queue.isEmpty()) {
    		int a = queue.poll();
    		if (a == 99) {
    			bl = true;
    			return;
    		}
    		
    		for (int i : al[a]) {
    			if (!visited[i]) {
    				visited[i] = true;
    				queue.add(i);
    			}
    		}
    	}
    }
}