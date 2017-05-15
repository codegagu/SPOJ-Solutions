


		import java.io.*;
		class Main
		{
			public static void main(String args[])
			throws IOException
			{
				BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
				PrintWriter pw=new PrintWriter(System.out);
				int t=Integer.parseInt(br.readLine());
				long ans=0;
				while(t--!=0)
				{
					
					long k=Long.parseLong(br.readLine());
					if(k==1)
						pw.println(192);
					else
					{
						ans=192+((k-1)*250);
						pw.println(ans);
					}
					
				}
				pw.flush();
			}
		}