import java.util.Scanner;

public class Main {
	public static void main (String [] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		//String str = sc.next();
		String str = "02415367";
		MySolution s = new MySolution();
		//int[] m = {1,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0};
		//int[] m = {1,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,1};
		//int[] m = {1,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,1,0,0,0,0,0,0,1,0,0,0,0,0,0,1,0,0,0,0,0,0,1,0,0,0,0};
		//int[] m = {0,0,0,0,0,0,0,1,0,0,1,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,1,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,1,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0};
		//Board a = new Board(m);
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
