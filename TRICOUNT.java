



			import java.io.*;
			class Main
			{
				public static void main(String args[])
				throws IOException
				{
					BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
					PrintWriter pw=new PrintWriter(System.out);
					int t=Integer.parseInt(br.readLine());
					while(t--!=0)
					{
						long n=Long.parseLong(br.readLine());
						long ans=n*(n+2)*(2*n+1)/8;
						pw.println(ans);
					}
					pw.flush();
				}
			}