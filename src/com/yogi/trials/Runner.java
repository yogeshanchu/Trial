package com.yogi.trials;

import java.util.*;

public class Runner {

    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        set.add(1);
        set.add(1);
        set.add(1);
        set.add(2);

        set2.add(1);
        set2.add(3);
        System.out.println(Arrays.toString(set.toArray()));

        Set<Set<Integer>> setofSet = new HashSet<>( );
        setofSet.add(set);
        setofSet.add(set2);
        System.out.println(Arrays.toString(setofSet.toArray()));

        System.out.println(threeSum (new int[]{-1,0,1,2,-1,-4}));
    }


    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> returns ;
        Set<List<Integer>> intermediate = new HashSet<>();

        for (int i=0; i<nums.length;i++){

            for (int j= i+1; j < nums.length; j++){

                for (int k = j+1; k < nums.length; k++ ){

                    if (nums[i] + nums[j] + nums[k] == 0 ){
                        List<Integer> temp = new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[k]);
                        System.out.println(Arrays.toString(temp.toArray()));
                        intermediate.add(temp);
                        temp = null;
                    }

                }
            }
        }
        returns = new ArrayList(intermediate);

        return returns;
    }



}
