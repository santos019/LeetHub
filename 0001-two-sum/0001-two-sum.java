class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] answer = new int[2];
        for(int i = 0; i < nums.length - 1; i++) {
            int value = target - nums[i];
            int index = IntStream.range(i + 1, nums.length)
                                .filter(v -> nums[v] == value)
                                .findFirst()
                                .orElse(-1);
            if(index == -1 ) continue;
            else {
                answer[0] = i;
                answer[1] = index;
                break;
            }
        }
                return answer;

    }
}