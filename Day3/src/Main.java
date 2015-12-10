import java.util.HashSet;


public class Main {

	public static void main(String[] args) {
		int curX = 0, curY = 0, curX2 = 0, curY2 = 0;
		HashSet<Coord<Integer, Integer>> list = new HashSet<Coord<Integer,Integer>>();
		list.add(new Coord<Integer, Integer>(0, 0));
		char[] route = args[0].toCharArray();
		for (int i = 0; i < route.length; i++) {
			switch (route[i]) {
			case '>': if(i%2==0)curX++;else curX2++; break;
			case '<': if(i%2==0)curX--;else curX2--; break;
			case '^': if(i%2==0)curY++;else curY2++; break;
			case 'v': if(i%2==0)curY--;else curY2--; break;
			}
			list.add(new Coord<Integer, Integer>(curX, curY));
			list.add(new Coord<Integer, Integer>(curX2, curY2));
		}
		System.out.println(list.size());
	}

}
