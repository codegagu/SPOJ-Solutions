


			import java.util.*;
			import java.io.*;
			class Main
			{
				public static void main(String args[])
				throws IOException
				{
					BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
					String in[]=br.readLine().trim().split(" ");
					int n=Integer.parseInt(in[0]);
					int m=Integer.parseInt(in[1]);
					int arr[][]=new int[n][m];
					for(int i=0;i<n;i++)
					{
						String input=br.readLine();
						int pointer=0;
						StringTokenizer st=new StringTokenizer(input," ");
						while(st.hasMoreTokens())
						{
							arr[i][pointer++]=Integer.parseInt(st.nextToken());
						}
					}
					
					
					
					//calculation part
					int min=Integer.MAX_VALUE;
					for(int i=1;i<n;i++)
					{
						for(int j=0;j<m;j++)
						{
							if(j==0)
							{
								arr[i][j]+=Math.min(arr[i-1][j], arr[i-1][j+1]);
							}
							else if(j==m-1)
							{
								arr[i][j]+=Math.min(arr[i-1][j], arr[i-1][j-1]);
							}
							else
							{
								int yo=Math.min(arr[i-1][j-1],arr[i-1][j]);
								arr[i][j]+=Math.min(yo, arr[i-1][j+1]);
							}
							
							if(i==(n-1) && arr[i][j]<min)
								min=arr[i][j];
						}
					}
					
					
					
					System.out.println(min);
					
				}
			}