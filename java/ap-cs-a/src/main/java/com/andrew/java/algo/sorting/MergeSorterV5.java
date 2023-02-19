package com.andrew.java.algo.sorting;

import java.util.ArrayList;
import java.util.List;

public class MergeSorterV5 {

    private MergeSorterV5() {
    }

    public static void mergeSort(List<CashDonor> donors) {
        int listSize = donors.size() - 1;
        if (listSize >= 2) {
            int mid = listSize / 2;
            List<CashDonor> left = new ArrayList<>(donors.subList(0, mid + 1));
            List<CashDonor> right = new ArrayList<>(donors.subList(mid + 1, listSize + 1));
            mergeSort(left);
            mergeSort(right);
            merge(donors, left, right);
        }
    }

    private static void merge(List<CashDonor> donors, List<CashDonor> left, List<CashDonor> right) {
        int leftIndex = 0;
        int rightIndex = 0;
        int indexToInsert = 0;
        int leftSize = left.size();
        int rightSize = right.size();
        CashDonor leftDonor;
        CashDonor rightDonor;

        while (leftIndex < leftSize && rightIndex < rightSize) {
            leftDonor = left.get(leftIndex);
            rightDonor = right.get(rightIndex);

            if (leftDonor.compareTo(rightDonor) < 0) {
                donors.set(indexToInsert, leftDonor);
                indexToInsert++;
                leftIndex++;
            } else if (rightDonor.compareTo(leftDonor) < 0) {
                donors.set(indexToInsert, rightDonor);
                indexToInsert++;
                rightIndex++;
            } else {
                donors.set(indexToInsert, rightDonor);
                donors.set(indexToInsert + 1, rightDonor);
                indexToInsert += 2;
                rightIndex++;
                leftIndex++;
            }
        }

        while (leftIndex < leftSize) {
            donors.set(indexToInsert, left.get(leftIndex));
            indexToInsert++;
            leftIndex++;
        }

        while (rightIndex < rightSize) {
            donors.set(indexToInsert, right.get(rightIndex));
            indexToInsert++;
            rightIndex++;
        }
    }

}
