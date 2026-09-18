class Solution {
    public int fib(int n) {

        if(n==0){
            return 0;
        }
        if(n==1){
            return 1;
        }
        else{
            int a1=fib(n-1);
            int a2=fib(n-2);
            int a3=a1+a2;
            return  a3;
        }
    }
}