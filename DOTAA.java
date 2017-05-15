

		
			import java.io.*;
			import java.util.*;
			class Main
			{
				public static void main(String args[])
				throws IOException
				{
					BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
					int t=Integer.parseInt(br.readLine().trim());
					while(t--!=0)
					{
						String str=br.readLine().trim();
						while(str.length()==0)
							str=br.readLine().trim();
						String in[]=str.trim().split(" ");
						int n=Integer.parseInt(in[0]);
						int m=Integer.parseInt(in[1]);
						int D=Integer.parseInt(in[2]);
						Integer arr[]=new Integer[n];
						//input health of n heroes
						for(int i=0;i<n;i++)
						{
							str=br.readLine().trim();
							while(str.length()==0)
								str=br.readLine().trim();
							arr[i]=Integer.parseInt(str);
						}
						Arrays.sort(arr,Collections.reverseOrder());
						int pos=0,check=0;
						for(int i=0;i<m;i++)
						{
							if(arr[pos]>D)
								arr[pos]-=D;
							else
								{pos++;i--;}
							if(pos==n)
							{check=1;break;}
						}
						if(check==0)
							System.out.println("YES");
						else
							System.out.println("NO");
						
					}
				}
			}