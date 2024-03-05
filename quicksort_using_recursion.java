import java.util.Arrays;

public class Main {
	
	public static void main(String[] args) {
        int[] array = new int[]{3, 1, 4, 1, 5, 9, 2, 6, 5};
	    // int[] array = new int[]{2, 7, 1, 8, 3, 6, 5, 4, 9};
	    // int[] array = new int[]{4, 8, 5, 2, 7, 3, 1, 6, 9};
	    // int[] array = new int[]{1, 3, 5, 7, 9, 2, 4, 6, 8};
	    quicksort(array, 0, array.length - 1);
	    System.out.println("Sorted list: " + Arrays.toString(array));
	}
	
	public static void quicksort(int[] array, int left, int right) {
        
        // stop the recursion
        int subArrayLength = right - left;
        if (subArrayLength < 1) return;
        else if (subArrayLength == 1) {
            if (array[left] <= array[right]) return;
            int temp = array[left];
            array[left] = array[right];
            array[right] = temp;
            return;
        }
        
        // select the pivot (median of three values)
        int pivot = right - 1;
        int mid = (subArrayLength / 2) + left;
        int[] pivotArray = sortThreeValues(array[left], array[mid], array[right]);
        array[left] = pivotArray[0];
        array[right] = pivotArray[2];
        array[mid] = array[pivot];
        array[pivot] = pivotArray[1];
        
        // compare with the pivot
        int l = left;
        int r = right;
        while (l != r) {
            while ((array[pivot] <= array[r]) && l < r) r--;
            while ((array[l] <= array[pivot]) && l < r) l++;
            
            // stop the comparison
            if (l == r) break;
            
            // swap the left and right
            int temp = array[l];
            array[l] = array[r];
            array[r] = temp;
        }
        
        // move the pivot
        int pivotValue = array[pivot];
        if (l < pivot) {
            int newPivot = l + 1;
            array[pivot] = array[newPivot];
            array[newPivot] = pivotValue;
            pivot = newPivot;
        } 
        else {
            array[pivot] = array[l];
            array[l] = pivotValue;
            pivot = l;
        }
        
        // recursion
        quicksort(array, left, pivot - 1);
        quicksort(array, pivot + 1, right);
    }
    
    private static int[] sortThreeValues(int a, int b, int c) {
        
        int[] array = {a, b, c};
        
        // bubble sort
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] <= array[j + 1]) continue;
                int temp = array[j];
                array[j] = array[j + 1];
                array[j + 1] = temp;
            }
        }
        
        return array;
    }
}
