class Solution {
    static ArrayList<Integer> nextSmallerEle(int[] arr) {
        int n=arr.length;
        Stack<Integer>s=new Stack<>();
        ArrayList<Integer>l=new ArrayList<>(Collections.nCopies(n,-1));
        for(int i=n-1;i>=0;i--){
            while(!s.isEmpty() &&s.peek()>=arr[i]){
                s.pop();
            }
            if(!s.isEmpty())
                l.set(i,s.peek());
            s.push(arr[i]);
        }
        return l;
    }
}