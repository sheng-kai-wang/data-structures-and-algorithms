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
        
        // split the array
        int length = array.length;
        for (int size = 1; size < length; size *= 2) {
            for (int left = 0; left < length; left += (size * 2)) {
                int mid = Math.min(left + size, length); // the separation of two subarrays
                int right = Math.min(mid + size, length); // the rightmost subarray
                sort(array, left, mid, right);
            }
        }
    }
    
    private static void sort(int[] array, int left, int mid, int right) {
        
        int[] leftArray = new int[mid - left];
        int[] rightArray = new int[right - mid];
        
        // put the original elements into two temporary arrays
        for (int leftIdx = 0; leftIdx < leftArray.length; leftIdx++) {
            leftArray[leftIdx] = array[left + leftIdx];
        }
        for (int rightIdx = 0; rightIdx < rightArray.length; rightIdx++) {
            rightArray[rightIdx] = array[mid + rightIdx];
        }
        
        // comparision
        int allIdx = left;
        int leftIdx = 0;
        int rightIdx = 0;
        while ((leftArray.length - leftIdx) > 0 && (rightArray.length - rightIdx) > 0) {
            if (leftArray[leftIdx] <= rightArray[rightIdx]) {
                array[allIdx] = leftArray[leftIdx];
                leftIdx++;
                allIdx++;
            }
            else {
                array[allIdx] = rightArray[rightIdx];
                rightIdx++;
                allIdx++;
            }
        }
            
        // remaining elements
        while ((leftArray.length - leftIdx) > 0) {
            array[allIdx] = leftArray[leftIdx];
            leftIdx++;
            allIdx++;
        }
        while ((rightArray.length - rightIdx) > 0) {
            array[allIdx] = rightArray[rightIdx];
            rightIdx++;
            allIdx++;
        }
    }
}
