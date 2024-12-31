import java.io.*;
import java.util.*;

class Solution {
	static int x;
	static int y;
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
     
        int T = Integer.parseInt(br.readLine());
        
        for (int test_case = 1; test_case <= T; test_case++) {
        	st = new StringTokenizer(br.readLine());
        	int p = Integer.parseInt(st.nextToken());
        	int q = Integer.parseInt(st.nextToken());
        	
        	x = 0;
        	y = 0;
        	search(p, q);
        	
        	int now = 1;
        	int plus = 1;
        	
        	int c = x + y -1;
        	while (c>0) {
        		c--;
        		now += plus;
        		plus++;
        	}
        	
        	
        	now += c-y;
        	bw.write("#" + test_case + " " + now + "\n");
        }
        
        bw.flush();
        bw.close();
        br.close();
    }
    
    public static void search(int a, int b) {
    	int sum = 0;
    	int index = 0;
    	for (int i=1; i<10000; i++) {
    		sum+=i;
    		if (sum >= a) {
    			index = i;
    			break;
    		}
    	}
    	
    	int ax = 1;
    	int ay = index;
    	int gap = sum - a;
    	while (gap > 0) {
    		gap--;
    		ax++;
    		ay--;
    	}
    	
    	sum = 0;
    	index = 0;
    	for (int i=1; i<10000; i++) {
    		sum+=i;
    		if (sum >= b) {
    			index = i;
    			break;
    		}
    	}
    	
    	int bx = 1;
    	int by = index;
    	gap = sum - b;
    	while (gap > 0) {
    		gap--;
    		bx++;
    		by--;
    	}
    	
    	y = ax + bx;
    	x = ay + by;
    }
}