class Solution {
    public int[] asteroidCollision(int[] arr) {
        int n=arr.length;

        Stack<Integer>s=new Stack<>();
        for(int i=0;i<n;i++){
            while(!s.isEmpty() && s.peek()>0 &&arr[i]<0
                    && Math.abs(s.peek())<Math.abs(arr[i])){
                s.pop();
            }if(!s.isEmpty() &&s.peek()>0 &&arr[i]<0 ){
                if(Math.abs(s.peek())==Math.abs(arr[i]))
                    s.pop();continue;
            }
            s.push(arr[i]);
        }
        int[] res = new int[s.size()];
        for (int i = s.size() - 1; i >= 0; i--) {
            res[i] = s.pop();
        }
        return res;
    }
}