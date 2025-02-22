import java.io.*;
import java.util.*;

class Solution {
	static ArrayList<Integer>[] al;
	static int answer;
	static int maxDepth;
	static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = 10;
        
        for (int test_case = 1; test_case <= T; test_case++) {
        	st = new StringTokenizer(br.readLine());
        	int size = Integer.parseInt(st.nextToken());
        	int startNumber = Integer.parseInt(st.nextToken());
        	
        	visited = new boolean[101];
        	al = new ArrayList[101];
        	for (int i=1; i<=100; i++) {
        		al[i] = new ArrayList<Integer>();
        	}
        	
        	st = new StringTokenizer(br.readLine());
        	for (int i=0; i<size/2; i++) {
        		int a = Integer.parseInt(st.nextToken());
        		int b = Integer.parseInt(st.nextToken());
        		
        		al[a].add(b);
        	}
        	
        	answer = -1;
        	maxDepth = 0;
        	bfs(startNumber, 0);
        	
        	bw.write("#" + test_case + " " + answer + "\n");
        }
        
        bw.flush();
        bw.close();
        br.close();
    }
    
    public static void bfs(int number, int depth) {
    	visited[number] = true;
    	Queue<int[]> queue = new LinkedList<>();
    	queue.add(new int[] {number, depth});
    	
    	while(!queue.isEmpty()){
    		int[] a = queue.poll();
    		int value = a[0];
    		int nowDepth = a[1];
    		
    		if (maxDepth < nowDepth) {
    			maxDepth = nowDepth;
    			answer = value;
    		} else if (maxDepth == nowDepth) {
    			answer = Math.max(answer, value);
    		}
    		
    		for (int i : al[value]) {
    			if (!visited[i]) {
    				visited[i] = true;
    				queue.add(new int[] {i, nowDepth+1});
    			}
    		}
    	}
    }
}