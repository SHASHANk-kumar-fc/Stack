class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n=nums.length;
        int ans[] =new int[n];
        Arrays.fill(ans,-1);
        Stack<Integer>s=new Stack<>();
        for(int i=(n-1)*2;i>=0;i--){
            while(!s.isEmpty() && s.peek()<=nums[i%n])
                s.pop();
            if(!s.isEmpty() && i<n )
                ans[i]=s.peek();
            s.push(nums[i%n]);
        }return ans;
    }
}