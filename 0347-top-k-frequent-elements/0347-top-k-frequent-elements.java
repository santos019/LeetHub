class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        final int len = nums.length;
        Map<Integer, Integer> count = new HashMap<>();
        
        for(int i = len/2 -1; i >= 0; i--) {
            heapify(nums, i, len); 
        }
        
        for(int i = 0; i < len; i++) {
            int tmp = nums[0];
            nums[0] = nums[len -1 -i];
            nums[len -1 - i] = tmp;

            if(count.containsKey(tmp)) {
                count.put(tmp, count.get(tmp) + 1);
            } else {
                count.put(tmp, 1);
            }
            
            heapify(nums, 0, len - i - 1);
        }

        PriorityQueue<Map.Entry <Integer, Integer>> minHeap = new PriorityQueue<>((a, b) -> a.getValue() - b.getValue());
        for(Map.Entry<Integer,Integer> entry : count.entrySet()) {
            minHeap.add(entry);
            if(minHeap.size() > k) {
                minHeap.poll();
            }
        }

        int res[] = new int[k];
        int index = 0;
        while(!minHeap.isEmpty()) {
            res[index++] = minHeap.poll().getKey();
        }

        return res;
    }
    
    public void heapify(final int[] nums, final int i, final int stop) {
        int largest = i;
        int leftChild = 2 * i + 1;
        int rightChild = 2 * i + 2;
        
        if(leftChild < stop && nums[largest] < nums[leftChild]) {
            largest = leftChild;
        }
        
        if(rightChild < stop && nums[largest] < nums[rightChild]) {
            largest = rightChild;
        }
        
        if(largest != i) {
            int tmp = nums[largest];
            nums[largest] = nums[i];
            nums[i] = tmp;
            heapify(nums, largest, stop);
        }
    }
}