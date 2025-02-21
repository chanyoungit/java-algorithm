import java.io.*;
import java.util.*;

class Solution {
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
     
        int T = 10;
        
        for (int test_case = 1; test_case <= T; test_case++) {
        	int N = Integer.parseInt(br.readLine());
        	char[] ch = br.readLine().toCharArray();
        	char[] arr = br.readLine().toCharArray();
        	int answer = 0;
        	
        	for (int i=0; i<=arr.length - ch.length; i++) {
        		if (arr[i] == ch[0]) {
        			int index = 0;
        			for (int j=i; j<i+ch.length; j++) {
        				if (arr[j] == ch[index]) {
        					index++;
        					if (index == ch.length) {
        						answer++;
        						break;
        					}
        				} else {
        					break;
        				}
        			}
        		}
        	}
        	
        	bw.write("#" + test_case + " " + answer + "\n");
        }
        
        bw.flush();
        bw.close();
        br.close();
    }
}