



			import java.io.*;
			class Main
			{
				public static void main(String agrs[])
				throws IOException
				{
					BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
					PrintWriter pw=new PrintWriter(System.out);
					long t=Long.parseLong(br.readLine());
					while(t--!=0)
					{
						String str=br.readLine();
						while(str.length()==0)
							str=br.readLine();
						long n=Long.parseLong(str);
						
						long arr[]=new long[(int)n];
						for(int i=0;i<n;i++)
						{
							arr[i]=Long.parseLong(br.readLine());
						}
						int yo=0;
						for(int i=0;i<n;i++)
						{
							if(arr[i]%n==0 && i==(n-1)){
								yo=1;break;}
							else if(arr[i]%n==0)
								continue;
							else if(arr[i]%n!=0 && i!=(n-1))
							{
								arr[i+1]+=arr[i]%n;
							}
						}
						if(yo==1)
							pw.println("YES");
						else
							pw.println("NO");
						
					}
					pw.flush();
				}
			}