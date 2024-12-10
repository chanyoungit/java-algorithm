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
        	int N = Integer.parseInt(st.nextToken());
        	int B = Integer.parseInt(st.nextToken());
        	
        	int[] arr = new int[N];
        	
        	st = new StringTokenizer(br.readLine());
        	for (int i=0; i<N; i++) {
        		arr[i] = Integer.parseInt(st.nextToken());
        	}
        	
        	HashSet<Integer> set = new HashSet<>();
        	set.add(0);
        	
        	for (int i=0; i<N; i++) {
        		HashSet<Integer> newSet = new HashSet<>();
        		for (int j: set) {
        			newSet.add(j + arr[i]);
        		}
        		set.addAll(newSet);
        	}
        	
        	int min = Integer.MAX_VALUE;
        	for (int i : set) {
        		if (i >= B) {
        			int gap = i - B;
        			min = Math.min(min, gap);
        		}
        	}
        	
        	bw.write("#" + test_case + " " + min + "\n");
        }
        
        bw.flush();
        bw.close();
        br.close();
    }
}