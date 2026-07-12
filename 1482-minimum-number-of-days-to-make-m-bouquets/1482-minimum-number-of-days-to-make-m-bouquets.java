class Solution {

    public int minDays(int[] bloomDay, int m, int k) {

        if((long)m * k > bloomDay.length){
            return -1;
        }

        int low = findMin(bloomDay);
        int high = findMax(bloomDay);

        while(low <= high){

            int mid = low + (high - low) / 2;

            int bouquets = countBouquets(bloomDay, mid, k);

            if(bouquets >= m){
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }

        return low;
    }

    public int findMin(int[] bloomDay){

        int mini = Integer.MAX_VALUE;

        for(int i = 0; i < bloomDay.length; i++){
            mini = Math.min(mini, bloomDay[i]);
        }

        return mini;
    }

    public int findMax(int[] bloomDay){

        int maxi = Integer.MIN_VALUE;

        for(int i = 0; i < bloomDay.length; i++){
            maxi = Math.max(maxi, bloomDay[i]);
        }

        return maxi;
    }

    public int countBouquets(int[] bloomDay, int day, int k){

        int bouquets = 0;
        int count = 0;

        for(int i = 0; i < bloomDay.length; i++){

            if(bloomDay[i] <= day){

                count++;

                if(count == k){
                    bouquets++;
                    count = 0;
                }
            }
            else{
                count = 0;
            }
        }

        return bouquets;
    }
}