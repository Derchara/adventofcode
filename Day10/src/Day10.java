
public class Day10 {

	public static void main(String[] args) {
		String input = args[0];
		for (int i = 0; i < 50; i++) {
			StringBuilder sb = new StringBuilder();
			char[] inputArr = input.toCharArray();
			char last = inputArr[0];
			int count = 0;
			for (int j = 0; j < inputArr.length; j++) {
				if (inputArr[j] == last) {
					count++;
					if (j == inputArr.length-1)
						sb.append(count).append(last);
				}
				else {
					sb.append(count).append(last);
					if (j == inputArr.length-1)
						sb.append(1).append(inputArr[j]);
					count = 1;
				}
				last = inputArr[j];
			}
			input = sb.toString();
			System.out.println(input.length());
		}
	}

}
