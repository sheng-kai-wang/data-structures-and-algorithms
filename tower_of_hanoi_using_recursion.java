import java.util.Arrays;

public class Main {
    
    private static int count = 0;
    
	public static void main(String[] args) {
	    
        int[] towerArray = new int[] {1, 2, 3, 5};
        for (int tower : towerArray) {
            hanoi(tower, "A", "B", "C");
            count = 0;
            System.out.println();
        }
	}
	
	public static void hanoi(int towerLevel, String from, String mid, String to) {
	    
	    // stop the recursion
	    if (towerLevel == 1) {
	        System.out.println("[" + ++count + "] " + "move " + towerLevel + " from " + from + " to " + to);
	        return;
	    }
	    
	    hanoi(towerLevel - 1, from, to, mid);
	    System.out.println("[" + ++count + "] " + "move " + towerLevel + " from " + from + " to " + to);
	    hanoi(towerLevel - 1, mid, from, to);
	}
}
