class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low=1;
        int high=findMax(piles);
        while(low<=high){
            int mid=(low+high)/2;
            int totalHours= calculateToatlHours(piles,mid);
            if(totalHours<=h){
                high=mid-1;

            }
            else{
                low=mid+1;
            }
        }
        return low;
    }
    public int findMax(int[] piles){
        int maxx=Integer.MIN_VALUE;
        for(int i=0;i<piles.length;i++){
            maxx=Math.max(maxx,piles[i]);
        }
        return maxx;
    }
    public int calculateToatlHours(int[]piles,int hourly){
        int totalHours=0;
        for(int i=0;i<piles.length;i++){
            totalHours +=Math.ceil((double)piles[i]/(double)hourly);
        }
        return totalHours;
    }
}