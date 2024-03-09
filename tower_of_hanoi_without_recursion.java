import java.util.Arrays;
import java.util.Stack;

public class Main {
    
    private static int count = 0;
    
	public static void main(String[] args) {
	    
        int[] towerArray = new int[] {1, 2, 3, 4, 5};
        for (int tower : towerArray) {
            hanoi(tower, "_LEFT_", "_MID_", "_RIGHT_");
            count = 0;
            System.out.println();
        }
	}
	
	public static void hanoi(int towerLevel, String from, String mid, String to) {
	    
	    Stack<Integer> leftStack = new Stack<>();
	    Stack<Integer> midStack = new Stack<>();
	    Stack<Integer> rightStack = new Stack<>();
	    
	    // put all the plates on the left rod
	    for (int i = towerLevel; i > 0; i--) {
	        leftStack.push(i);
	    }
	    
	    // calculate the number of moves required
	    int moveNum = (int) Math.pow(2, towerLevel) - 1;
	    
	    // move the plates according to observed patterns
	    boolean isOdd = (towerLevel % 2 == 1);
	    for (int i = 1; i <= moveNum; i++) {
	        if (i % 3 == 1) {
	            if (isOdd) move(leftStack, rightStack, from, to);
	            else move(leftStack, midStack, from, mid);
	        }
	        else if (i % 3 == 2) {
	            if (isOdd) move(leftStack, midStack, from, mid);
	            else move(leftStack, rightStack, from, to);
	        }
	        else move(midStack, rightStack, mid, to);
	    }
	}
	
	private static void move(Stack<Integer> fromStack, Stack<Integer> toStack, String from, String to) {
	    
	    if (!fromStack.empty() && (toStack.empty() || (fromStack.peek() < toStack.peek()))) {
	        int plate = fromStack.pop();
	        toStack.push(plate);
	        System.out.println("[" + (++count) + "] " + "move " + plate + " from " + from + " to " + to);
	    }
	    else {
	        int plate = toStack.pop();
	        fromStack.push(plate);
	        System.out.println("[" + (++count) + "] " + "move " + plate + " from " + to + " to " + from);
	    }
	}
}
