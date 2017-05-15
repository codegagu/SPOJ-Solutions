


			import java.util.*;
			import java.io.*;
			class Main
			{
				public static void main(String args[])
				throws IOException
				{
					BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
					PrintWriter pw=new PrintWriter(System.out);
					int t=Integer.parseInt(br.readLine());
					int iter=1;
					while(t--!=0)
					{
						String in[]=br.readLine().split(" ");
						int stamp_no=Integer.parseInt(in[0]);
						int friends=Integer.parseInt(in[1]);
						int arr[]=new int[friends];
						String input=br.readLine();
						StringTokenizer st=new StringTokenizer(input);
						int index=0;
						while(st.hasMoreTokens())
							arr[index++]=Integer.parseInt(st.nextToken());
						Arrays.sort(arr);
						int sum=0,counter=0;
						while(sum<=stamp_no)
						{
							sum+=arr[--index];
							counter++;
							if(sum==stamp_no || index==0)
								break;
						}
						if(sum>=stamp_no) //possible
							pw.println("Scenario #"+iter+":"+"\n"+counter+"\n");
						else
							pw.println("Scenario #"+iter+":"+"\n"+"impossible\n");
						
						iter++;
					}
					pw.flush();
				}
			}