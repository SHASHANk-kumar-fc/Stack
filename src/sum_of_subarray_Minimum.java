class Solution {
    public int sumSubarrayMins(int[] arr) {
        int n=arr.length;

        long mod = 1_000_000_007L;
        int []nsl=new int[n];
        int []nsr=new int[n];
        Stack<Integer>s=new Stack<>();
        Arrays.fill(nsl,-1);
        for(int i=0;i<n;i++){
            while(!s.isEmpty() && arr[s.peek()]>arr[i])s.pop();
            if(!s.isEmpty())
                nsl[i]=s.peek();
            s.push(i);
        }
        s.clear();
        Arrays.fill(nsr,n);
        for(int i=n-1;i>=0;i--){
            while(!s.isEmpty() && arr[s.peek()]>=arr[i])s.pop();
            if(!s.isEmpty())
                nsr[i]=s.peek();
            s.push(i);
        }long sum=0;
        for(int i=0;i<n;i++){
            int left=i-nsl[i];
            int right=nsr[i]-i;
            sum+=(long)(arr[i]*left%mod*right%mod);
            sum%=mod;
        }return (int)sum;
    }
}