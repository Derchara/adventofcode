import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class Day9 {
	
	static List<String> locations;
	static int[][] distances;
	static long result = 0L;

	public static void main(String[] args) {
		locations = new ArrayList<String>();
		distances = new int[8][8];
		try {
			BufferedReader br = new BufferedReader(new FileReader(args[0]));
			for (String line = null; (line = br.readLine()) != null;) {
				String[] tokena = line.split(" = ");
				String[] dest = tokena[0].split(" to ");
				if (!locations.contains(dest[0]))
					locations.add(dest[0]);
				if (!locations.contains(dest[1]))
					locations.add(dest[1]);
				int i = locations.indexOf(dest[0]);
				int j = locations.indexOf(dest[1]);
				distances[i][j] = Integer.parseInt(tokena[1]);
				distances[j][i] = Integer.parseInt(tokena[1]);
				distances[locations.indexOf(dest[0])][locations.indexOf(dest[0])] = 0;
			}
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		permute(Arrays.asList(0,1,2,3,4,5,6,7), 0);
		System.out.println(result);
	}

	private static void permute(List<Integer> arr, int k) {
		for (int i = k; i < arr.size(); i++) {
			Collections.swap(arr, i, k);
			permute(arr, k+1);
			Collections.swap(arr, k, i);
		}
		if (k == arr.size()-1) {
			System.out.println(Arrays.toString(arr.toArray()));
			int sum = 0;
			for (int i = 0; i < arr.size()-1; i++) {
				sum += distances[arr.get(i)][arr.get(i+1)];
			}
			result = Math.max(sum, result);
		}
	}

}
