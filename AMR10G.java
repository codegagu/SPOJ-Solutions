

			import java.util.*;
			import java.io.*;
			class Main
			{
				public static void main(String args[])
				throws IOException
				{
					BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
					int t=Integer.parseInt(br.readLine().trim());
					while(t--!=0)
					{
						String in[]=br.readLine().trim().split(" ");
						int n=Integer.parseInt(in[0]);
						int k=Integer.parseInt(in[1]);
						int arr[]=new int[n];
						String str=br.readLine().trim();int i=0;
						if(k==1)
						{System.out.println(0);continue;}
						StringTokenizer st=new StringTokenizer(str," ");
						while(st.hasMoreTokens())
							arr[i++]=Integer.parseInt(st.nextToken());
						Arrays.sort(arr);
						int min=Integer.MAX_VALUE;
						for(i=n-1;i>=k-1;i--)
						{
							int end=arr[i];
							int beg=arr[i-k+1];
							
							int diff=end-beg;
							//System.out.println(end+" "+beg+" "+diff);
							if(diff<min)
								min=diff;
						}
						System.out.println(min);
					}
				}
			}