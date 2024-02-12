package org.example;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class CombinationSum {
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currentCombination = new ArrayList<>();

        backtrack(candidates, target, 0, currentCombination, result);

        return result;
    }

    private static void backtrack(int[] candidates, int target, int start, List<Integer> currentCombination, List<List<Integer>> result) {
        if (target < 0) {
            return;
        }

        if (target == 0) {
            result.add(new ArrayList<>(currentCombination));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            currentCombination.add(candidates[i]);
            backtrack(candidates, target - candidates[i], i, currentCombination, result);
            currentCombination.remove(currentCombination.size() - 1);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input candidates
        System.out.print("Enter candidate integers separated by spaces: ");
        String candidatesInput = scanner.nextLine();
        int[] candidates = Arrays.stream(candidatesInput.split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        // Input target
        System.out.print("Enter the target integer: ");
        int target = scanner.nextInt();

        List<List<Integer>> result = combinationSum(candidates, target);

        System.out.println("Combinations that sum up to the target:");
        for (List<Integer> combination : result) {
            System.out.println(combination);
        }
    }
}

