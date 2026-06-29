class Solution {
    public List<String> watchedVideosByFriends(List<List<String>> watchedVideos, int[][] friends, int id, int level) {
        int n = watchedVideos.size();
        List<Integer>[] g = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            g[i] = new ArrayList<>();
        }
        for (int i = 0; i < friends.length; i++) {
            for (int j = 0; j < friends[i].length; j++) {
                g[i].add(friends[i][j]);
            }
        }
        
        int[] dis = new int[n];
        Arrays.fill(dis, -1);   
        Deque<Integer> q = new ArrayDeque<>();
        q.offer(id);
        dis[id] = 0;
        
        while (!q.isEmpty()) {
            int x = q.poll();
            for (int neighbor : g[x]) {   
                if (dis[neighbor] == -1) {
                    dis[neighbor] = dis[x] + 1;
                    q.offer(neighbor);
                }
            }
        }
        
        List<Integer> targetUsers = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (dis[i] == level) {
                targetUsers.add(i);
            }
        }
        
        // 4. 统计这些用户观看的视频频率
        Map<String, Integer> freq = new HashMap<>();
        for (int user : targetUsers) {
            for (String video : watchedVideos.get(user)) {
                freq.put(video, freq.getOrDefault(video, 0) + 1);
            }
        }
        
        List<Map.Entry<String, Integer>> list = new ArrayList<>(freq.entrySet());
        list.sort((a, b) -> {
            if (!a.getValue().equals(b.getValue())) {
                return a.getValue() - b.getValue();
            }
            return a.getKey().compareTo(b.getKey());
        });
        
        List<String> res = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : list) {
            res.add(entry.getKey());
        }
        return res;
    }
}