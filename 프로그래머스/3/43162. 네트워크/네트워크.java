class Solution {
    static boolean[] visited;
    public int solution(int n, int[][] computers) {
        int answer = 0;
        visited = new boolean[n];
        for(int i = 0 ; i < n ; i++){
            if(!visited[i]){
                DFS(i,n, computers);
                answer++;
            }
        }
        
        return answer;
    }
    
    private static void DFS(int i, int n , int[][] computers){
        visited[i] = true;
        for(int a = 0 ; a < n ; a++){
            if(i!=a && computers[a][i] == 1 && !visited[a]){
                DFS(a, n, computers);
            }
        }
    }
}