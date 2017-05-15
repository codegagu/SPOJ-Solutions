import static java.lang.Integer.*;
import static java.lang.Math.*;
import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args) throws Throwable{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		for(int c = 0, C = parseInt(in.readLine().trim()); c++ < C;){
			in.readLine();in.readLine();
			int maxG = 0, maxM = 0;
			for(StringTokenizer st = new StringTokenizer(in.readLine()); st.hasMoreTokens(); ) maxG = max(maxG, parseInt(st.nextToken()));
			for(StringTokenizer st = new StringTokenizer(in.readLine()); st.hasMoreTokens(); ) maxM = max(maxM, parseInt(st.nextToken()));
			System.out.println(maxG>=maxM?"Godzilla":"MechaGodzilla");
		}
	}
}