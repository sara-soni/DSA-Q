class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int  i =0; i <nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)-> Integer.compare(map.get(a),map.get(b)));
        for(int val : map.keySet()){
            pq.add(val);
            if(pq.size()>k){
                pq.poll();
            }
        }
        int[] result = new int[k];
        for(int i =k-1;i >= 0;i--){
            result[i] = pq.poll();
        }
        return result;

        
    }
}