import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    
	public static void main(String[] args) {

		List<String> list = new ArrayList<>(Arrays.asList("lufh", "jsoidfj", "fjv", "5646", "4#654ff"));
		System.out.println("list: " + list);
		
		String s = Main.encode(list);
		System.out.println("s: " + s);
		
		list = Main.decode(s);
		System.out.println("list: " + list);
	}
	
    public static String encode(List<String> strs) {
        
        StringBuilder sb = new StringBuilder();
        for (String s : strs) {
            sb.append(s.length());
            sb.append("#");
            sb.append(s);
        }
        return sb.toString();
    }

    public static List<String> decode(String str) {
        
        List<String> res = new ArrayList<>();
        
        int start = 0;
        for (int end = 0; end < str.length(); end++) {
            if (str.charAt(end) != '#') continue;
            String lenStr = str.substring(start, end);
            int len = Integer.parseInt(lenStr);
            res.add(str.substring(end + 1, end + 1 + len));
            start = end + 1 + len;
            end = start;
        }

        return res;
    }
}
