


		import java.io.*;
		import java.util.Arrays;
		class NotATriangle
		{
			public static void main(String args[])
			throws IOException
			{
				BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
				PrintWriter pw=new PrintWriter(System.out);
				int n=Integer.parseInt(br.readLine());
				while(n!=0)
				{
					if(n==0)
						System.exit(0);
					int arr[]=new int[n];
					String s[]=br.readLine().split(" ");
					for(int i=0;i<n;i++)
						arr[i]=Integer.parseInt(s[i]);
					Arrays.sort(arr);
					int sum=0;
					int totalcount=0;
					for(int i=0;i<n-2;i++)
					{
						for(int j=i+1;j<n-1;j++)
						{
							sum=arr[i]+arr[j];
							if(sum>=arr[n-1])
								break;
							else
							{
								int index=Arrays.binarySearch(arr, j+1, n-1, sum);
								if(index<0)
								{
									index=-(index+1);
								}
								else
								{
									while(arr[index]<=sum)
									index++;
								}
								
								totalcount=totalcount+(n-index);
							}
								
						}
					}
					pw.println(totalcount);
					n=Integer.parseInt(br.readLine());
				}
				pw.flush();
			}
		}