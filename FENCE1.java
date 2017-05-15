


		import java.io.*;
		class Main
		{
			public static void main(String args[])
			throws IOException
			{
				BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
				String str="";
				while(!(str=br.readLine().trim()).equals("0"))
				{
					int L=Integer.parseInt(str);
					L*=L;
					double ans=L/(2*3.1415926535897932384626433832795);
					System.out.printf("%.2f%n",ans);
				}
			}
		}