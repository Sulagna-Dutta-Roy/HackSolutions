import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class CandidateCode {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        int[][] grid = new int[n][n];
        for (int i = 0; i < n; i++) {
            String[] line = scanner.nextLine().split("#");
            for (int j = 0; j < n; j++) {
                grid[i][j] = Integer.parseInt(line[j]);
            }
        }
List<String> result = new ArrayList<>();
        int maxMin = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int min = Integer.MAX_VALUE;
                for (int x = Math.max(i-1, 0); x <= Math.min(i + 1, n-1); x++) {
                    for (int y = Math.max(j-1, 0); y <= Math.min(j + 1, n-1); y++) {
                        min = Math.min(min, grid[x][y]);
                    }
                }
                if (min > maxMin) {
                    maxMin = min;
                    result.clear();
                    result.add((i+1) + "#" + (j+1));
                } else if (min == maxMin) {
                    result.add((i+1) + "#" + (j+1));
                }
            }
        }
        for (String position : result) {
            System.out.println(position);
        }
    }
}
