class Solution {
    public int trap(int[] arr) {
        int ans=0;
        int n=arr.length;
        int rmax=Integer.MIN_VALUE;
        int lmax=Integer.MIN_VALUE;
        int r=n-1;
        int l=0;
        while(l<r){
            lmax=Math.max(lmax,arr[l]);
            rmax=Math.max(rmax,arr[r]);
            if(lmax<=rmax){
                ans+=lmax-arr[l];
                l++;}
            else {
                ans+=rmax-arr[r];
                r--;
            }

        }return ans;
    }
}