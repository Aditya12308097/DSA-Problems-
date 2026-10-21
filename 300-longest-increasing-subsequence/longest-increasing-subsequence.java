class Solution {
    public int solveUsingRec(int[] arr, int curr, int prev){
        //base case
        if(curr >= arr.length){
            return 0;
        }
        //we have 2 choices , either include or exlude

        //can we include every number ? NO , we can include greater element from previous one
        int include = 0;
        if(prev == -1 || arr[curr] > arr[prev]){
            include = 1 + solveUsingRec(arr,curr+1,curr);
        }
        int exclude = 0 + solveUsingRec(arr,curr+1,prev);

        int finalAns = Math.max(include,exclude);
        return finalAns;

    }
    //Now using memoisation
    public int solveUsingMem(int[] arr, int curr, int prev, int[][] dp){
        //base case
        if(curr >= arr.length){
            return 0;
        }

        if(dp[curr][prev+1] != -1){
            return dp[curr][prev+1];
        }
        //we have 2 choices , either include or exlude
        //can we include every number ? NO , we can include greater element from previous one
        int include = 0;
        if(prev == -1 || arr[curr] > arr[prev]){
            include = 1 + solveUsingMem(arr,curr+1,curr,dp);
        }
        int exclude = 0 + solveUsingMem(arr,curr+1,prev,dp);

        int finalAns = Math.max(include,exclude);
        dp[curr][prev+1] = finalAns;
        return finalAns;
    }
    public int lengthOfLIS(int[] nums) {
        int prev = -1;
        int curr = 0;
        int n = nums.length;
        // int ans = solveUsingRec(nums,curr,prev);

        // dp array's size --> depends on prev and curr
        int[][] dp =  new int[n+1][n+1];
        for(int i=0;i<n+1;i++){
            Arrays.fill(dp[i],-1);
        }
        int ans = solveUsingMem(nums,curr,prev,dp);
        return ans;
    }
}