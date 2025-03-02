import java.io.*;
import java.util.*;

class Solution {
	static char[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = 10;

        for (int test_case = 1; test_case <= T; test_case++) {
        	int t = Integer.parseInt(br.readLine());
        	arr = new char[100][100];
        	
        	for (int i=0; i<100; i++) {
        		arr[i] = br.readLine().toCharArray();
        	}
        	
        	for (int i=100; i>0; i--) {		// 글자수
        		if(solve(i)) {
        			bw.write("#" + t + " " + i + "\n");
        			break;
        		}
        	}
        }
        
        bw.flush();
        bw.close();
        br.close();
    }
    
    public static boolean solve(int a) {
    	StringBuilder sb = new StringBuilder();
    	
    	for (int i=0; i<100; i++) {
    		for (int j=0; j<=100-a; j++) {
    			
    			String str = "";
    			for (int k=j; k<j+a; k++) {		// 가로
    				str += arr[i][k];
    			}
    			
    			sb.append(str);
    			String reverseStr = sb.reverse().toString();
    			
    			if (str.equals(reverseStr)) {
    				return true;
    			}
    			
    			sb.setLength(0);
    			
    			str = "";
    			for (int k=j; k<j+a; k++) {		// 세로
    				str += arr[k][i];
    			}
    			
    			sb.append(str);
    			reverseStr = sb.reverse().toString();
    			
    			if (str.equals(reverseStr)) {
    				return true;
    			}
    			
    			sb.setLength(0);
    		}
    	}
    	
    	return false;
    }
}