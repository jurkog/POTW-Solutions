import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Week3 {
	public static void main(String[] args) {
		// Input n and n Strings
		// Create regex expression as we go
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		ArrayList<String> regex = new ArrayList<String>();
		for (int i = 0; i<n; i++) 
			regex.add(sc.next());
		
		int m = sc.nextInt();
		int[] output = new int[m];
		for (int i = 0; i < m; i++) {
			String sentence = sc.next();
			for (String begin : regex) {
				ArrayList<String> Q = new ArrayList<String>();
				Q.add(begin);
				while (!Q.isEmpty()) {
					String first = Q.remove(0);
					if (first.equals(sentence)) {
						output[i] = 1;
						break;
					}
					for (String next : regex) {
						if (sentence.startsWith(first+next)) {
							Q.add(first+next);
						}
					}
				}
				if (output[i] == 1)
					break;
			}
		}
		for (int i = 0; i < m; i++)
			System.out.println(output[i]);
	}
}
