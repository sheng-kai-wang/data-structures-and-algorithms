import java.util.Arrays;

public class Main {
    
    private static int count = 0;
    
	public static void main(String[] args) {
        int[] tower1 = new int[] {1};
        int[] tower2 = new int[] {1, 2};
        int[] tower3 = new int[] {1, 2, 3};
        int[] tower4 = new int[] {1, 2, 3, 4, 5};
        int[][] towerArray = new int[][] {tower1, tower2, tower3, tower4};
        for (int[] tower : towerArray) {
            hanoi(tower, "A", "B", "C");
            count = 0;
            System.out.println();
        }
	}
	
	public static void hanoi(int[] tower, String from, String mid, String to) {
	    
	    int length = tower.length;
	    
	    // stop the recursion
	    if (length == 1) {
	        System.out.println("[" + ++count + "] " + "move " + tower[0] + " from " + from + " to " + to);
	        return;
	    }
	    
	    // the elements above (except the bottom elements)
	    int[] aboveTower = Arrays.copyOfRange(tower, 0, length - 1);
	    
	    hanoi(aboveTower, from, to, mid);
	    System.out.println("[" + ++count + "] " + "move " + tower[length - 1] + " from " + from + " to " + to);
	    hanoi(aboveTower, mid, from, to);
	}
}
