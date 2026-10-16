class Solution {
    public int usingRecursion(int n){
        if(n ==0) return 0;
        if(n==1) return 1;
        int sum = usingRecursion(n-1)  + usingRecursion(n-2);
        return sum;
    }
    public int usingDP(int n,int[] dp){
        if(n ==0) return 0;
        if(n==1) return 1;
        if(dp[n] != -1){
            return dp[n];
        }
        int sum = usingDP(n-1,dp)  + usingDP(n-2,dp);
        dp[n] = sum;
        return dp[n];
    }
    public int fib(int n) {
        // first using recursion then using DP
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);

        return usingDP(n,dp);
    }
}