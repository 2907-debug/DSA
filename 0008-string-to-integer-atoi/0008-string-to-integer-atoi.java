class Solution {
    public int myAtoi(String s) {
        int i =0;
        int n =s.length();
        while(i<n&&s.charAt(i)==' '){

            i++;
        }
        int sign=1;
        if(i<n&&s.charAt(i)=='+'){
            i++;
        }
        
        else if(i<n&& s.charAt(i)=='-'){
            sign=-1;
            i++;
        }
        long answer=0;
        while(i<n&& getNumber(s.charAt(i))!= -1){
            
            int digit= getNumber(s.charAt(i));
            answer=answer*10+digit;
             if (sign == 1 && answer > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }

            // Negative overflow
            if (sign == -1 && -answer < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }

            i++;

        }
        return (int)(sign*answer);



    }
    public int getNumber(char ch ){
        if(ch>='0'&&ch<='9'){
            return ch-'0';
        }
        return -1;
    }
}