class Solution {
    public int largestPathValue(String colors, int[][] edges) {
        List<List<Integer>> al = new ArrayList<>();
    List<int[]> cnt = new ArrayList<>();
    int n = colors.length();
    for (int i = 0; i < n; i++) {
        al.add(new ArrayList<>());
        cnt.add(new int[26]);
    }
    int[] indegrees = new int[n];
    for (int[] e : edges) {
        al.get(e[0]).add(e[1]);
        indegrees[e[1]]++;
    }
    List<Integer> q = new ArrayList<>();
    for (int i = 0; i < n; i++) {
        if (indegrees[i] == 0)
            q.add(i);
    }
    int res = 0, processed = 0;
    while (!q.isEmpty()) {
        List<Integer> q1 = new ArrayList<>();
        for (int i : q) {
            processed++;
            res = Math.max(res, ++cnt.get(i)[colors.charAt(i) - 'a']);
            for (int j : al.get(i)) {
                for (int k = 0; k < 26; k++)
                    cnt.get(j)[k] = Math.max(cnt.get(j)[k], cnt.get(i)[k]);
                if (--indegrees[j] == 0)
                    q1.add(j);
            }
        }
        q = q1;
    }
    return processed != n ? -1 : res;
    }
}
