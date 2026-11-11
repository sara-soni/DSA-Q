class Solution {
    public int majorityElement(int[] nums) {
        int n=nums.length;
        TreeMap<Integer,Integer> h = new TreeMap<>();
        for(int i: nums){
            h.put(i,h.getOrDefault(i,0)+1);
        }
        for(int key: h.keySet()){
            if(h.get(key)>n/2){
                return key;
            }
        }
        return -1;
    }
}