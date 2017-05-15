


		import java.io.*;
		class Main
		{
			public static void main(String args[])
			throws IOException
			{
				BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
				PrintWriter pw=new PrintWriter(System.out);
				int t=Integer.parseInt(br.readLine());
				while(t!=0)
				{ 
					int sum=0;
					int n=Integer.parseInt(br.readLine());
					while(n!=0)
					{
						n=n/5;
						sum+=n;
					}
					pw.println(sum);
					t--;
				}
				pw.flush();
			}
		}