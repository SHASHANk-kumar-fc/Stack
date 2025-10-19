class Solution {
    public int maxArea(int[] height) {
        int n=height.length;
        int max=0;
        int l=0,r=n-1;

        while(l<r){

            max=Math.max((r-l)*Math.min(height[l],height[r]),max);
            if(height[l]<=height[r]){
                l++;
            }else r--;

        }return max;
    }
}