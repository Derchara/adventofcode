import org.apache.commons.lang3.StringUtils;


public class Main {

	public static void main(String[] args) {		
		System.out.println(StringUtils.countMatches(args[0], "(")-StringUtils.countMatches(args[0], ")"));
		int floor = 0;
		boolean reported = false;
		for (int i = 0; i < args[0].length(); i++) {
			if (args[0].substring(i, i+1).equals("(")) {
				floor++;
			}
			if (args[0].substring(i, i+1).equals(")")) {
				floor--;
				if (!reported && floor < 0) {
					System.out.println(i);
					reported = true;
				}
			}
		}
	}

}
