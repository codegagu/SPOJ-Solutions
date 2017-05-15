


		
			import java.io.*;
			import java.util.Arrays;
			class Main
			{
				public static void main(String args[])
				throws IOException
				{
					BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
					PrintWriter pw=new PrintWriter(System.out);
					int t=Integer.parseInt(br.readLine());
					int a[]=new int[10001];
					while(t--!=0)
					{
						String in[]=br.readLine().split(" ");
						int e=Integer.parseInt(in[0]);
						int f=Integer.parseInt(in[1]);
						int W=f-e;
						Arrays.fill(a, Integer.MAX_VALUE);
						a[0]=0;
						int n=Integer.parseInt(br.readLine());
						for(int i=0;i<n;i++)
						{
							String in2[]=br.readLine().split(" ");
							int value=Integer.parseInt(in2[0]);
							int weight=Integer.parseInt(in2[1]);
							for(int j=0;j+weight<=W;j++)
								if(a[j]!=Integer.MAX_VALUE && a[j+weight]>a[j]+value)
									a[j+weight]=a[j]+value;
						}
						if(a[W]==Integer.MAX_VALUE)
							pw.println("This is impossible.");
						else
							pw.println("The minimum amount of money in the piggy-bank is "+a[W]+".");
					}
					pw.flush();
				}
			}