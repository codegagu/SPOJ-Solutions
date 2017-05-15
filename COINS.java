


			import java.io.*;
			import java.util.HashMap;
			import java.util.Scanner;
			class Main
			{
				
				public static HashMap<Long,Long> mymap=new HashMap<Long,Long>();
				
				public static void main(String args[])
				throws IOException
				{
					//BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
					Scanner s=new Scanner(System.in);
					PrintWriter pw=new PrintWriter(System.out);
					long n;
					while(s.hasNextLong())
					{
						n=s.nextLong();
						System.out.println(gold_to_dollar(n));
					}
					pw.flush();
				}
				
				static long gold_to_dollar(long n)
				{
					if(n<=11)
						return n;
					else if(mymap.containsKey(n))
						return mymap.get(n);
					else
					{
						long dollar=gold_to_dollar(n/2)+gold_to_dollar(n/3)+gold_to_dollar(n/4);
						mymap.put(n, dollar);
						return dollar;
					}
				}
			}