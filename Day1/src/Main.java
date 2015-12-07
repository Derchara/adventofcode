import org.apache.commons.lang3.StringUtils;


public class Main {

	public static void main(String[] args) {		
		System.out.println(StringUtils.countMatches(args[0], "(")-StringUtils.countMatches(args[0], ")"));
	}

}
