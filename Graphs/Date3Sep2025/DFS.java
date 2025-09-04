//https://www.geeksforgeeks.org/problems/depth-first-traversal-for-a-graph/1

package Graphs.Date3Sep2025;

import java.io.*;
import java.util.*;

public class dfs {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Solution sol = new Solution();

        int V = Integer.parseInt(br.readLine().trim());
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        int E = Integer.parseInt(br.readLine().trim());
        for (int i = 0; i < E; i++) {
            String[] parts = br.readLine().trim().split("\\s+");
            int u = Integer.parseInt(parts[0]);
            int v = Integer.parseInt(parts[1]);
            adj.get(u).add(v);
            adj.get(v).add(u); // For undirected graph
        }

        ArrayList<Integer> dfsResult = sol.helper(adj);
        System.out.println(dfsResult);
    }
}
class Solution {
    public void dfs(boolean[] vis, int curr, ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> list) {
        vis[curr] = true;
        list.add(curr);
        for(int i=0; i<adj.get(curr).size(); i++) {
            int c = adj.get(curr).get(i);
            if(!vis[c]) {
                dfs(vis, c, adj, list);
            }
        }
    }
    // Function to return a list containing the DFS traversal of the graph.
    public ArrayList<Integer> helper(ArrayList<ArrayList<Integer>> adj) {
        // Code here
        ArrayList<Integer> list = new ArrayList<>();
        int n = adj.size();
        boolean[] vis = new boolean[n];
        dfs(vis, 0, adj, list);
        return list;
    }
}