import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;


public class Day7 {
	
	static Map<String, String> exps;
	
	static Map<String, Integer> values;

	public static void main(String[] args) {
		exps = new HashMap<String, String>();
		values = new HashMap<String, Integer>();
		try {
			BufferedReader br = new BufferedReader(new FileReader(args[0]));
			for (String line = null; (line = br.readLine()) != null;) {
				String[] tokens = line.split(" -> ");
				exps.put(tokens[1], tokens[0]);
			}
			values.put("b", 46065);
			System.out.println(parse("a"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static int parse(String exp) {
		if (values.containsKey(exp))
			return values.get(exp);
		try {
			if (exp.matches("\\d+")) {
				return Integer.parseInt(exp) & 0xffff;
			}
			if (exps.get(exp).matches("\\d+")) {
				values.put(exp, Integer.parseInt(exps.get(exp)) & 0xffff);
				return Integer.parseInt(exps.get(exp)) & 0xffff;
			}
			String[] tokens = exps.get(exp).split(" ");
			if (tokens.length == 1)
				values.put(exp, (int) (parse(tokens[0]) & 0xffff));
			if (tokens[1].equals("AND"))
				values.put(exp, (int) (parse(tokens[0]) & parse(tokens[2])) & 0xffff);
			if (tokens[1].equals("OR"))
				values.put(exp, (int) (parse(tokens[0]) | parse(tokens[2])) & 0xffff);
			if (tokens[1].equals("LSHIFT"))
				values.put(exp, (int) (parse(tokens[0]) << parse(tokens[2])) & 0xffff);
			if (tokens[1].equals("RSHIFT"))
				values.put(exp, (int) (parse(tokens[0]) >> parse(tokens[2])) & 0xffff);
			if (tokens[0].equals("NOT"))
				values.put(exp, (int) (~parse(tokens[1]) & 0xffff));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return values.get(exp);
	}

}
