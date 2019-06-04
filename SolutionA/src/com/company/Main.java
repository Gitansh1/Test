package com.company;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

            Scanner scanner = new Scanner(System.in);
            int size = scanner.nextInt();     // Size of an array
            size = size + 1;
            int randomNumbers[] = new int[size];

            // Enter the input elements of an array
            for (int i = 1; i < size; i++) {
                randomNumbers[i] = scanner.nextInt();

// To find the duplicate numbers
                if (i > 1) {
                    for (int j = 1; j < i; j++) {
                        if (randomNumbers[i] == randomNumbers[j]) {
                            System.out.println("Duplicate number found, please enter distinct numbers");
                            i = i - 1;
                            break;
                        }
                    }
                }
            }

            int[] sortedNumbers;
            sortedNumbers = sort(randomNumbers);   // Sort the array

            // To find the first positive integer number whose value is equal to index
            boolean a = false;
            for (int i = 1; i < sortedNumbers.length; i++) {
                int M = sortedNumbers[i];
                if (i == M) {
                    System.out.println(M);
                    a = true;
                    break;
                }
            }
            if (a == false) {
                System.out.println("NOT_FOUND");
            }
    }

    public static int[] sort(int[] randomNumbers) {
        return mergeSort(randomNumbers, 1, randomNumbers.length - 1);
    }

    public static int[] mergeSort(int[] numbers, int first, int last) {
        if (first < last) {
            int mid = (first + last) / 2;
            mergeSort(numbers, first, mid);
            mergeSort(numbers, mid + 1, last);
            merge(numbers, first, mid, last);
        }
        return numbers;
    }

    private static int[] merge(int[] numbers, int i, int m, int j) {
        int l = i;        // Initial index of first subarray
        int r = m + 1;    // Initial index of second subarray
        int k = 1;        // Initial index of merged array
        int[] t = new int[numbers.length];

        while (l <= m && r <= j) {
            if (numbers[l] <= numbers[r]) {
                t[k] = numbers[l];
                k++;
                l++;
            } else {
                t[k] = numbers[r];
                k++;
                r++;
            }
        }

        // Copy the remaining elements on left half , if there are any
        while (l <= m) {
            t[k] = numbers[l];
            k++;
            l++;
        }

        // Copy the remaining elements on right half
        while (r <= j) {
            t[k] = numbers[r];
            k++;
            r++;
        }

        // Copy the remaining elements from array to back the numbers array
        l = i;
        k = 1;
        while (l <= j) {
            numbers[l] = t[k];
            l++;
            k++;
        }
        return numbers;
    }
}


