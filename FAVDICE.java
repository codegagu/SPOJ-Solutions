


		import java.io.*;
		class Main
		{
			public static void main(String args[])
			throws IOException
			{
				BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
				int t=Integer.parseInt(br.readLine());
				while(t--!=0)
				{
					int n=Integer.parseInt(br.readLine());
					//calculate harmonic series
				    double sum=0;
				    for(int i=1;i<=n;i++)
				    	sum+=1.0/(double)i;
				    sum*=n;
				    System.out.printf("%.2f%n",sum);
					
				}
			}
		}
		