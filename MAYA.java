


			import java.util.*;
			import java.io.*;
			class Main
			{
				public static void main(String args[])
				throws IOException
				{
					BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
					int n=0;
					int arr[]={1,20,360,7200,144000,2880000,57600000};
					while((n=Integer.parseInt(br.readLine()))!=0)
					{
						StringTokenizer st;
						long sum=0;
						for(int i=0;i<n;i++)//for each individual digit
						{
							int no_of_dots=0,total_digit=0;
							String this_digit=br.readLine();
							st=new StringTokenizer(this_digit," ");
							while(st.hasMoreTokens())
							{
								String token=st.nextToken();
								if(token.charAt(0)=='.')
								{
									no_of_dots=token.length();
									total_digit+=no_of_dots;
								}
								else if(token.equals("-"))
								{
									total_digit+=5;
								}
								else if(token.equals("S"))
									total_digit=0;
							}
							sum=sum+total_digit*arr[n-(i+1)];
						}
						String blank=br.readLine();
						System.out.println(sum);
					}
					
					
				}
			}