

		import java.io.*;
		import java.util.*;
		class Main
		{
			public static void main(String args[])
			throws IOException
			{
				BufferedReader br=new BufferedReader (new InputStreamReader(System.in));
				String str="";
				while(!(str=br.readLine()).equals("0 0")) 
				{
					StringTokenizer st=new StringTokenizer(str);
					long w=Long.parseLong(st.nextToken());
					long h=Long.parseLong(st.nextToken());
					if(w==h){
						System.out.println("1");continue;
					}
					long prod=w*h;
					long lcm=prod/gcd(w,h);
					long a=(lcm/w);
					long b=(lcm/h);
					System.out.println(a*b);
					
					//System.out.println("bara "+ lcm);
				}
			}
			
			static long gcd(long p,long q)
			{
				if(q==0)
					return p;
				else return gcd(q,p%q);
			}
		}