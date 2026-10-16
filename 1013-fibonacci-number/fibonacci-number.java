class Solution {
    public int usingRecursion(int n){
        if(n ==0) return 0;
        if(n==1) return 1;
        int sum = usingRecursion(n-1)  + usingRecursion(n-2);
        return sum;
    }
    public int fib(int n) {
        // first using recursion
        return usingRecursion(n);
    }
}