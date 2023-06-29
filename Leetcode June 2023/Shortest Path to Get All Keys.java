class Solution {
    public int shortestPathAllKeys(String[] grid) {
      int n = grid.length;
        int m = grid[0].length();
        char[][] s = new char[n][m];
        int x0 = -1;
        int y0 = -1;
        int status = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                s[i][j] = grid[i].charAt(j);
                if (s[i][j] == '@') {
                    x0 = i;
                    y0 = j;
                } else if (s[i][j] >= 'A' && s[i][j] <= 'F') {
                    status |= 1 << (s[i][j] - 'A');
                }
            }
        }
        return bfs(s, x0, y0, status);
    }

    int[] dx = {1, -1, 0, 0};
    int[] dy = {0, 0, 1, -1};

    int bfs(char[][] s, int x0, int y0, int status0) {
        if (status0 == 0) {
            return 0;
        }
        int n = s.length;
        int m = s[0].length;
        int p = 1 << 6;
        Queue<Integer> q = new LinkedList<>();
        HashSet<Integer> visited = new HashSet<>();
        int index = (x0 * m + y0) * p + status0;
        q.offer(index);
        int count = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                index = q.poll();
                status0 = index % p;
                index /= p;
                x0 = index / m;
                y0 = index % m;
                for (int i = 0; i < 4; i++) {
                    int x = x0 + dx[i];
                    int y = y0 + dy[i];
                    if (x < 0 || y < 0 || x >= n || y >= m || s[x][y] == '#') {
                        continue;
                    }
                    int status = status0;
                    if (s[x][y] >= 'a' && s[x][y]<= 'z') {
                        status &= ~(1 << (s[x][y] - 'A'));
                        if (status == 0) {
                            return count + 1;
                        }
                    } else if (s[x][y] >= 'A' && s[x][y]<= 'Z' && (status & (1 << (s[x][y] - 'A'))) != 0) {
                        continue;
                    }
                    index = (x * m + y) * p + status;
                    if (!visited.contains(index)) {
                        q.offer(index);
                        visited.add(index);
                    }
                }
            }
            count++;
        }
        return -1;  
    }
}
