package LeetCode;

public class CountPrimes  {

    public int countPrimes(int n) {
        int sum = 0;
        boolean flag[] = new boolean[n+1];
        for (int i=1;i<=n;i++) flag[i] = true;
        for(int i=2;i<=Math.sqrt(n);i++) {
            if(flag[i]) {
                for(int j=i;i*j<=n;j++) 
                   flag[i*j] = false;
            }
        }
        for (int i = 2; i < n; i++){
            if(flag[i])
                sum++;
        }
     return sum;
    }

}

