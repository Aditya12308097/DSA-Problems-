class Solution {
    public int solveUsingRec(int[] coins, int amount){
        if(amount == 0) 
            return 0;
        
        int mini = Integer.MAX_VALUE;
        for(int i=0;i<coins.length;i++){
            if(coins[i] <= amount){
                int res = solveUsingRec(coins,amount - coins[i]);
                if(res != Integer.MAX_VALUE){
                    mini = Math.min(mini,1+res);
                }
            }
        }
        return mini;
    }
    // Rec + Memoisation
    public int solveUsingMem(int[] coins, int amount, int[] dp){
        if(amount == 0) 
            return 0;
        if(dp[amount] != -1) return dp[amount];
        int mini = Integer.MAX_VALUE;
        for(int i=0;i<coins.length;i++){
            if(coins[i] <= amount){
                int res = solveUsingMem(coins,amount - coins[i],dp);
                if(res != Integer.MAX_VALUE){
                    mini = Math.min(mini,1+res);
                }
            }
        }
        dp[amount] = mini;
        return mini;
    }
    //tabulation
    public int solveUsingTab(int[] nums, int amount){
        int n = amount;
        int[] dp = new int[n+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0] = 0;
        for(int value = 1;value<= amount;value++){
            int mini = Integer.MAX_VALUE;
            for(int i=0;i<nums.length;i++){
                if(nums[i] <= value){
                    int res = dp[value - nums[i]];
                    if(res != Integer.MAX_VALUE){
                        mini = Math.min(mini,1+res);
                    }
                }
            }
            dp[value] = mini;
        }
        return dp[amount];
    }
    public int coinChange(int[] coins, int amount) {
        // solve using recusion
        // int n = amount;
        // int[] dp = new int[n+1];
        // Arrays.fill(dp,-1);
        // int ans = solveUsingRec(coins,amount);
        // int ans = solveUsingMem(coins,amount,dp);

        int ans = solveUsingTab(coins,amount);
        if(ans == Integer.MAX_VALUE) return -1;
        return ans;
    }
}