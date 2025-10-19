class Solution {
    public long subArrayRanges(int[] nums) {
        int n=nums.length;
        long nsl[]  =new long [n];
        long nsr[]=new long [n];
        long ngl[]=new long[n];
        long ngr[]=new long[n];
        Stack<Integer>s=new Stack<>();
        Arrays.fill(nsl,-1);
        Arrays.fill(nsr,n);
        for(int i=0;i<n;i++){
            while(!s.isEmpty() && nums[s.peek()]>nums[i])s.pop();
            if(!s.isEmpty())
                nsl[i]=s.peek();
            s.push(i);
        }
        s.clear();
        for(int i=n-1;i>=0;i--){
            while(!s.isEmpty() && nums[s.peek()]>=nums[i])s.pop();
            if(!s.isEmpty())
                nsr[i]=s.peek();
            s.push(i);
        }s.clear();
        Arrays.fill(ngl,-1);
        Arrays.fill(ngr,n);
        for(int i=0;i<n;i++){
            while(!s.isEmpty() && nums[s.peek()]<nums[i])s.pop();
            if(!s.isEmpty())
                ngl[i]=s.peek();
            s.push(i);
        }
        s.clear();

        for(int i=n-1;i>=0;i--){
            while(!s.isEmpty() && nums[s.peek()]<=nums[i])s.pop();
            if(!s.isEmpty())
                ngr[i]=s.peek();
            s.push(i);
        }int result=0;long min=0, max=0;
        for(int i=0;i<n;i++){
            min+=(long)(nums[i]*(i-nsl[i])*(nsr[i]-i));
            max+=(long)(nums[i]*(i-ngl[i])*(ngr[i]-i));

        }return max-min;
    }
}