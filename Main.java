import java.util.Scanner;

public class Main {
	public static void main (String [] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		//String str = "02415367"; //exemple of input each index is a row, each number is that row respective column
		MySolution s = new MySolution();
		Board a = new Board(str);
		long inicio = System.currentTimeMillis();
		Board w = s.simpleBacktrackingPermuted(a);
		long fim = System.currentTimeMillis();
		System.out.println(w);
		long total = (fim-inicio);
		System.out.println(total);
		sc.close();
	}
}
