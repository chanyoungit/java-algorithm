import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        HashSet<String> set = new HashSet<>();
        String str = br.readLine();

        for (int i = 1; i <= str.length(); i++) {
            for (int j = 0; j <= str.length() - i; j++) {
                set.add(str.substring(j, j + i));
            }
        }

        bw.write(set.size() + "");
        bw.close();
    }
}