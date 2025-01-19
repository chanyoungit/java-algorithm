import java.io.*;
import java.util.*;

public class Solution {
	static char[][] arr;
	static int N;
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
        	N = Integer.parseInt(br.readLine());
        	arr = new char[N][N];
        	boolean answer = false;
        	for (int i=0; i<N; i++) {
        		arr[i] = br.readLine().toCharArray();
        	}
        	
        	for (int i=0; i<N; i++) {
        		for (int j=0; j<N; j++) {
        			if (arr[i][j] == 'o') {
        				answer = isPrime1(i,j);
        				if (isPrime(i,j) || isPrime1(i,j) || isPrime2(i,j) || isPrime0(i,j)) {
        					bw.write("#" + test_case + " YES\n");
        					answer = true;
        					break;
        				}
        			}
        		}
        		if (answer) {
        			break;
        		}
        	}        	
        	if (!answer) {
        		bw.write("#" + test_case + " NO\n");
        	}
        }

        bw.flush();
        bw.close();
        br.close();
    }
    public static boolean isPrime0 (int a, int b) {
    	int cnt = 0;
    	int i = a;
    	int j = b;
    	
    	while (cnt < 5) {
    		if (i>=N) {
    			return false;
    		}
    		
    		if (arr[i][j] != 'o') {
    			return false;
    		}
    		cnt++;
    		i++;
    	}
    	
    	return true;
    }
    
    public static boolean isPrime (int a, int b) {
    	int cnt = 0;
    	int i = a;
    	int j = b;
    	
    	while (cnt < 5) {
    		if (j>=N) {
    			return false;
    		}
    		
    		if (arr[i][j] != 'o') {
    			return false;
    		}
    		cnt++;
    		j++;
    	}
    	
    	return true;
    }
    
    public static boolean isPrime1 (int a, int b) {
    	int cnt = 0;
    	int i = a;
    	int j = b;
    	
    	while (cnt < 5) {
    		if (i>=N || j >=N) {
    			return false;
    		}
    		
    		if (arr[i][j] != 'o') {
    			return false;
    		}
    		cnt++;
    		i++;
    		j++;
    	}
    	
    	return true;
    }
    
    public static boolean isPrime2 (int a, int b) {
    	int cnt = 0;
    	int i = a;
    	int j = b;
    	
    	while (cnt < 5) {
    		if (i>=N || j < 0) {
    			return false;
    		}
    		
    		if (arr[i][j] != 'o') {
    			return false;
    		}
    		cnt++;
    		i++;
    		j--;
    	}
    	
    	return true;
    }
}