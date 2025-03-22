import java.io.*;
import java.util.*;

public class Solution {
    static int chance;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = 10;

        for (int test_case = 1; test_case <= T; test_case++) {
        	int[] arr = new int[100];
        	
            int N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            for (int i=0; i<100; i++) {
            	arr[i] = Integer.parseInt(st.nextToken());
            }
            
            while (N>0) {
            	int max = 0;
            	int min = 0;
            	
            	for (int i=0; i<100; i++) {
            		if (arr[max] < arr[i]) {
            			max = i;
            		}
            		
            		if (arr[min] > arr[i]) {
            			min = i;
            		}
            	}
            	arr[max]--;
        		arr[min]++;
        		N--;
            }
            
            int max = 0;
        	int min = 0;
        	
        	for (int i=0; i<100; i++) {
        		if (arr[max] < arr[i]) {
        			max = i;
        		}
        		
        		if (arr[min] > arr[i]) {
        			min = i;
        		}
        		
        	}
        	
        	int answer = arr[max] - arr[min];
        	bw.write("#" + test_case + " " + answer + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}