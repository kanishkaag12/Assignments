package Graphs.Date4Sep2025;

import java.io.*;

public class floodfillAlgo {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[m][n];
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                arr[i][j] = Integer.parseInt(br.readLine());
            }
        }
        String[] input = br.readLine().split(" ");
        int sr = Integer.parseInt(input[0]);
        int sc = Integer.parseInt(input[1]);
        int newColor = Integer.parseInt(br.readLine());

        Solution obj = new Solution();
        System.out.println(obj.helper(arr, sr, sc, newColor));
    }
}

class Solution {
    public void dfs(int[][] image, int sr, int sc, 
    int newColor, int old, int m, int n, boolean[][] vis) {
        if(sr<0 || sr>=m || sc<0 || sc>=n || image[sr][sc]!=old || vis[sr][sc]) return;
        image[sr][sc] = newColor;
        vis[sr][sc] = true;
        int[] dr = {0, 1, 0, -1};
        int[] dc = {1, 0, -1, 0};
        for(int i=0; i<4; i++) {
            int nr = sr + dr[i];
            int nc = sc + dc[i];
            if(nr>=0 && nr<m && nc>=0 && nc<n && image[nr][nc]==old && !vis[nr][nc]) {
                dfs(image, nr, nc, newColor, old, m, n, vis);
            }
        }
        
    }
    public int[][] helper(int[][] image, int sr, int sc, int newColor) {
        // Code here
        int m = image.length;
        int n = image[0].length;
        boolean[][] vis = new boolean[m][n];
        int old = image[sr][sc];
        
        dfs(image, sr, sc, newColor, old, m, n, vis);
        return image;
    }
}