import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        
        for (int test_case = 1; test_case <= T; test_case++) {
        	int t = Integer.parseInt(br.readLine());
        	st = new StringTokenizer(br.readLine());
        	
        	int[] arr = new int[101];
        	for (int i=0; i<1000; i++) {
        		arr[Integer.parseInt(st.nextToken())]++;
        	}
        	
        	int max = 0;
        	for (int i=0; i<=100; i++) {
        		if (arr[max] <= arr[i]) {
        			max = i;
        		}
        	}
        	
        	bw.write("#" + t + " " + max + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}