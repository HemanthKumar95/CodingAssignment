import java.util.Arrays;

public class ArrayOperations {
    public static int[] performOperations(int[] array, int operations) {
        for (int op = 0; op < operations; op++) {
            int N = array.length;
            int mid = N / 2;
            int quarter = N / 4;
            
            // Divide the array into 4 subarrays
            int[] A1 = Arrays.copyOfRange(array, 0, quarter);
            int[] A2 = Arrays.copyOfRange(array, quarter, mid);
            int[] A3 = Arrays.copyOfRange(array, mid, mid + quarter);
            int[] A4 = Arrays.copyOfRange(array, mid + quarter, N);
            
            // Swap the first and second subarrays
            System.arraycopy(A2, 0, array, 0, A2.length);
            System.arraycopy(A1, 0, array, A2.length, A1.length);
            
            // Swap the third and fourth subarrays
            System.arraycopy(A4, 0, array, mid, A4.length);
            System.arraycopy(A3, 0, array, mid + A4.length, A3.length);
        }
        
        return array;
    }
    
    public static void main(String[] args) {
        int N = 8;  // Number of integers in the array
        int Q = 2;  // Number of operations
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8};  // Initial array
        
        int[] result = performOperations(array, Q);
        System.out.println(Arrays.toString(result));  // Output after Q operations
    }
}
