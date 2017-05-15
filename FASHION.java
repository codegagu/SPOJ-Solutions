


			import java.util.Arrays;
			import java.io.*;
			class Main
			{
				public static void main(String args[])
				throws IOException
				{
					BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
					PrintWriter pw=new PrintWriter(System.out);
					int t=Integer.parseInt(br.readLine().trim());
					while(t--!=0)
					{
						int n=Integer.parseInt(br.readLine().trim());
						String in1[]=br.readLine().trim().split(" ");
						String in2[]=br.readLine().trim().split(" ");
						int arr[][]=new int[2][n];
						for(int i=0;i<n;i++)
						{
							arr[0][i]=Integer.parseInt(in1[i]);
							arr[1][i]=Integer.parseInt(in2[i]);
						}
						
						Arrays.sort(arr[0]);
						Arrays.sort(arr[1]);
						int sum=0;
						
						for(int i=0;i<n;i++)
						{
							sum+=(arr[0][i]*arr[1][i]);
						}
						pw.println(sum);
					}
					pw.flush();
				}
			}