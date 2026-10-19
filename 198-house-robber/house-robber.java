class Solution {
    public int solveUsingRec(int i, int[] arr){
        if(arr.length == 1) return arr[0];
        if(i >= arr.length) return 0;

        int include = arr[i] + solveUsingRec(i+2,arr);
        int exclude = 0 + solveUsingRec(i+1,arr);
        return Math.max(include, exclude);
    }
    public int solveUsingDP(int i, int[] dp ,int[] arr){
        //solving using memoisation which is top down approach
        if(arr.length == 1) return arr[0];
        if(i >= arr.length) return 0;
        if(dp[i] != -1) return dp[i];
        int include = arr[i] + solveUsingDP(i+2,dp,arr);
        int exclude = 0 + solveUsingDP(i+1,dp,arr);
        dp[i] = Math.max(include,exclude);
        return dp[i];
    }
    public int solveUsingTabulation(int[] nums){
        //step 1 :  analyse type of dp that is 1d dp and initialse it
        int n = nums.length;
        int[] dp =  new int[n+2];
        Arrays.fill(dp,-1);
        
        //step 2 : analyse the base cases : so if i >= n returns 0 
        dp[n] = 0;
        dp[n+1] = 0;
        //step 3 :  reverse the flow of loop used in recursive code and copy the code
        for(int i = n-1;i>=0;i--){
            int include = nums[i] + dp[i+2];
            int exclude = 0 + dp[i+1];
            dp[i] = Math.max(include,exclude);
        }
        //step 4 :return the answer , which you have passed as starting point in recursive code
        return dp[0];
    }

    //space optimisation
    public int solve(int[] nums){
        int next1 = 0;
        int next2 = 0;
        int curr = 0;
        for(int i=nums.length-1;i>=0;i--){
            int include = nums[i] + next2;
            int exclude = 0 + next1;
            curr = Math.max(include,exclude);
            next2 = next1;
            next1 = curr;

        }
        return curr; 
    }
    public int rob(int[] nums) {
        // int ans = solve(0,nums);
        // return ans;
        //So Use DP because it has subproblems which are re-calculating many times
        // int n = nums.length;
        // int[] dp = new int[n];
        // Arrays.fill(dp,-1);
        // int ans = solveUsingDP(0,dp,nums);
        // return ans;

        //now lets move onto next step , that is tabulation
        // int ans = solveUsingTabulation(nums);
        int ans = solve(nums);
        return ans;

    }
}