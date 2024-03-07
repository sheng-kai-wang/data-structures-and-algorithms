import java.util.Arrays;

public class Main {
    
	public static void main(String[] args) {
        
        int[] array1 = new int[]{3, 1, 4, 1, 5, 9, 2, 6, 5};
        int[] array2 = new int[]{2, 7, 1, 8, 3, 6, 5, 4, 9};
        int[] array3 = new int[]{4, 8, 5, 2, 7, 3, 1, 6, 9};
        int[] array4 = new int[]{1, 3, 5, 7, 9, 2, 4, 6, 8};
        
        int[][] allArray = new int[][] {array1, array2, array3, array4};
        for (int[] array : allArray) {
            System.out.println("original array: " + Arrays.toString(array));
            mergesort(array);
            System.out.println("sorted array: " + Arrays.toString(array));
            System.out.println();
        }
	}
	
	public static void mergesort(int[] array) {
        
        // stop the recursion
        int length = array.length;
        if (length <= 1) return;
        
        // split the array
        int mid = length / 2;
        int[] leftArray = new int[mid];
        int[] rightArray = new int[length - mid];
        for (int i = 0; i < length; i++) {
            if (i < mid) leftArray[i] = array[i];
            else rightArray[i - mid] = array[i];
        }
        
        // split the subarray (recursion)
        mergesort(leftArray);
        mergesort(rightArray);
        
        // sort
        sort(leftArray, rightArray, array);
    }
    
    private static void sort(int[] leftArray, int[] rightArray, int[] array) {
        
        // pointers
        int arrayIdx = 0;
        int leftIdx = 0;
        int rightIdx = 0;
        
        // comparision
        while (leftIdx != leftArray.length && rightIdx != rightArray.length) {
            if (leftArray[leftIdx] <= rightArray[rightIdx]) {
                array[arrayIdx] = leftArray[leftIdx];
                leftIdx++;
                arrayIdx++;
            }
            else {
                array[arrayIdx] = rightArray[rightIdx];
                rightIdx++;
                arrayIdx++;
            }
        }
        
        // remaining elements
        while (leftIdx < leftArray.length) {
            array[arrayIdx] = leftArray[leftIdx];
            leftIdx++;
            arrayIdx++;
        }
        while (rightIdx < rightArray.length) {
            array[arrayIdx] = rightArray[rightIdx];
            rightIdx++;
            arrayIdx++;
        }
    }
}
