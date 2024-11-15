import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();
        int answer = 0;

        HashSet<Integer> set = new HashSet<>();

        ArrayList<Integer> al_A = new ArrayList<>();
        ArrayList<Integer> al_B = new ArrayList<>();
        for (int i=0; i<a; i++) {
            al_A.add(sc.nextInt());
        }

        for (int i=0; i<b; i++) {
            al_B.add(sc.nextInt());
        }

        for (int i : al_A){
            set.add(i);
        }

        for (int i: al_B) {
            set.remove(i);
        }

        answer += set.size();

        set.clear();

        for (int i : al_B) {
            set.add(i);
        }

        for (int i : al_A) {
            set.remove(i);
        }

        answer += set.size();

        System.out.println(answer);
    }
}