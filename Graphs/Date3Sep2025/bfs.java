package Graphs.Date3Sep2025;

//https://www.geeksforgeeks.org/problems/bfs-traversal-of-graph/1

import java.util.*;

import java.io.*;
import java.util.*;

public class bfs {
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
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            adj.get(u).add(v);
            adj.get(v).add(u); // undirected graph
        }

        ArrayList<Integer> bfsResult = sol.bfs(adj);

        // Print BFS traversal
        StringBuilder sb = new StringBuilder();
        for (int node : bfsResult) {
            sb.append(node).append(" ");
        }
        System.out.println(sb.toString().trim());
    }
}

class Solution {
    // Function to return Breadth First Search Traversal of given graph.
    public ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {
        // code here
        ArrayList<Integer> list = new ArrayList<>();
        int n = adj.size();
        boolean[] vis = new boolean[n];
        
        Queue<Integer> q = new LinkedList<>();
        vis[0] = true;
        q.add(0);
        list.add(0);
        while(!q.isEmpty()) {
            int curr = q.poll();
            for(int i=0; i<adj.get(curr).size(); i++) {
                int c = adj.get(curr).get(i);
                if(!vis[c]){
                    vis[c] = true;
                    q.add(c);
                    list.add(c);
                    
                }
            }
        }
        return list;
    }
}