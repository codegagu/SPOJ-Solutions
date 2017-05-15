



		import java.io.*;
		class Main
		{
			public static void main(String args[])
			throws IOException
			{
				BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
				int t=Integer.parseInt(br.readLine());
				int counter=0;
				while(t--!=0)
				{
					counter++;
					long r=Long.parseLong(br.readLine());
					long ans=r*r*4;
					//System.out.println(ans)
					System.out.println("Case "+counter+": "+ans+".25");			
				}
			}
		}
