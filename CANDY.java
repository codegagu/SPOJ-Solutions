



			import java.io.*;
			class Main
			{
				public static void main(String args[])
				throws IOException
				{
					BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
					PrintWriter pw=new PrintWriter(System.out);
					int packets=Integer.parseInt(br.readLine());
					while(packets!=-1)
					{
						int sum=0;
						int arr[]=new int[packets];
						for(int i=0;i<packets;i++)
						{
							arr[i]=Integer.parseInt(br.readLine());
							sum+=arr[i];
						}
						int counts=0;
						if(sum%packets==0)
						{
							int avg=sum/packets;
							for(int i=0;i<packets;i++)
							{
								if(avg>arr[i])
									counts+=avg-arr[i];
							}
							pw.println(counts);
						}
						else
							pw.println(-1);
						
						packets=Integer.parseInt(br.readLine());
					}
					pw.flush();
				}
			}