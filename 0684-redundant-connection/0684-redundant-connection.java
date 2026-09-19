class Solution {
    public int[] findRedundantConnection(int[][] edges) {

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i <= edges.length; i++) {
            adj.add(new ArrayList<>());
        }

        boolean[] vis = new boolean[edges.length + 1];

        for (int[] edge : edges) {

            int u = edge[0];
            int v = edge[1];

            // Check whether u and v are already connected
            Arrays.fill(vis, false);

            if (dfs(u, v, adj, vis)) {
                return edge;
            }

            // No cycle, so add this edge
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        return new int[0];
    }

    static boolean dfs(int curr, int target,
                       ArrayList<ArrayList<Integer>> adj,
                       boolean[] vis) {

        if (curr == target) {
            return true;
        }

        vis[curr] = true;

        for (int nbr : adj.get(curr)) {
            if (!vis[nbr]) {
                if (dfs(nbr, target, adj, vis)) {
                    return true;
                }
            }
        }

        return false;
    }
}