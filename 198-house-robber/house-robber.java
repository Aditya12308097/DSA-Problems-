class Solution {
    public int solve(int i, int[] arr){
        if(arr.length == 1) return arr[0];
        if(i >= arr.length) return 0;

        int include = arr[i] + solve(i+2,arr);
        int exclude = 0 + solve(i+1,arr);
        return Math.max(include, exclude);
    }
    public int solveUsingDP(int i, int[] dp ,int[] arr){
        if(arr.length == 1) return arr[0];
        if(i >= arr.length) return 0;
        if(dp[i] != -1) return dp[i];
        int include = arr[i] + solveUsingDP(i+2,dp,arr);
        int exclude = 0 + solveUsingDP(i+1,dp,arr);
        dp[i] = Math.max(include,exclude);
        return dp[i];
    }
    public int rob(int[] nums) {
        // int ans = solve(0,nums);
        // return ans;
        //So Use DP because it has subproblems which are re-calculating many times
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp,-1);
        int ans = solveUsingDP(0,dp,nums);
        return ans;

    }
}