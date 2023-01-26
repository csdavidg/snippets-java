package com.example.snippets.algorithms;

import java.util.HashMap;
import java.util.Map;

public class FindTargetSumNumber {

    public int[] solution(int target, int[] nums) {
        Map<Integer, Integer> pairs = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer firstNumIndex = pairs.get(nums[i]);
            if(firstNumIndex != null && nums[firstNumIndex] != nums[i]) {
                return new int[] {pairs.get(nums[i]), i};
            }
            pairs.putIfAbsent((target - nums[i]), i);
        }
        return new int[]{0, 0};
    }

}
