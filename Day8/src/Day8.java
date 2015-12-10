import java.io.BufferedReader;
import java.io.FileReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;


public class Day8 {

	public static void main(String[] args) {
		int sum = 0;
		try {
			BufferedReader br = new BufferedReader(new FileReader(args[0]));
			for (String line = null; (line = br.readLine()) != null;) {
				line = line.substring(1, line.length()-1);
				sum += 2 + StringUtils.countMatches(line, "\\\\") +
						StringUtils.countMatches(line, "\\\"");
				Pattern p = Pattern.compile("\\\\[x][0-9a-f][0-9a-f]");
				Matcher m = p.matcher(line);
				while (m.find())
					sum+=3;
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println(sum);
	}

}
