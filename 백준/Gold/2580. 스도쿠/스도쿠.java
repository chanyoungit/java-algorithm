import java.io.*;
import java.util.*;

public class Main {

    static int[][] sudoku;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        sudoku = new int[9][9];

        for (int i = 0; i < 9; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < 9; j++) {
                sudoku[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0);
        bw.write(sb.toString());
        bw.close();
    }

    public static void dfs(int row, int col) {
        if (col >= 9) {
            dfs(row + 1, 0);
            return ;
        }

        if (row >= 9) {
            sb = new StringBuilder();

            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    sb.append(sudoku[i][j] + " ");
                }
                sb.append("\n");
            }
            return;
        }

        if (sudoku[row][col] == 0) {
            for (int i = 1; i <= 9; i++) {
                if (check(row, col, i)) {
                    sudoku[row][col] = i;
                    dfs(row, col + 1);
                }
            }
            sudoku[row][col] = 0;
            return;
        }

        dfs(row, col + 1);
    }

    public static boolean check(int row, int col, int value) {
        for (int i = 0; i < 9; i++) {
            if (sudoku[row][i] == value) {
                return false;
            }
        }

        for (int i = 0; i < 9; i++) {
            if (sudoku[i][col] == value) {
                return false;
            }
        }

        row = (row / 3) * 3;
        col = (col / 3) * 3;

        for (int i = row; i <= row + 2; i++) {
            for (int j = col; j <= col + 2; j++) {
                if (sudoku[i][j] == value) {
                    return false;
                }
            }
        }

        return true;
    }
}