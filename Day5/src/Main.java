import java.io.BufferedReader;
import java.io.FileReader;

import org.apache.commons.lang3.StringUtils;

public class Main {

	public static void main(String[] args) {
		String file = args[0];
		int nice = 0;
		try(BufferedReader br = new BufferedReader(new FileReader(file))) {
			for(String line; (line = br.readLine()) != null;) {
				boolean check1 = false, check2 = false, check3 = false;
				check1 = (StringUtils.countMatches(line, 'a') +
						 StringUtils.countMatches(line, 'e') +
						 StringUtils.countMatches(line, 'i') +
						 StringUtils.countMatches(line, 'o') +
						 StringUtils.countMatches(line, 'u')) >= 3;
				for (char i = 'a'; i <= 'z'; i++) {
					if (StringUtils.countMatches(line, ""+i+i) > 0)
						check2 |= true;
				}
				check3 = !StringUtils.contains(line, "ab") &&
						 !StringUtils.contains(line, "cd") &&
						 !StringUtils.contains(line, "pq") &&
						 !StringUtils.contains(line, "xy");
				if (check1 && check2 && check3)
					nice++;
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println(nice);
	}

}
