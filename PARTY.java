
			
				import java.util.Arrays;
				import java.io.*;
				class Main
				{
					public static void main(String args[])
					throws IOException
					{
						BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
						//PrintWriter pw=new PrintWriter(System.out);
						String str="";
						while(!(str=br.readLine().trim()).equals("0 0"))
						{
							String in[]=str.trim().split(" ");
							int W=Integer.parseInt(in[0]);
							int n=Integer.parseInt(in[1]);
							//now making the store table. 
							int arr_v[]=new int[n+1];
							int arr_w[]=new int[n+1];
							arr_v[0]=arr_w[0]=0;
							for(int i=1;i<=n;i++)
							{
								String in2[]=br.readLine().trim().split(" ");//12 3 cost fun
								arr_w[i]=Integer.parseInt(in2[0]);
								arr_v[i]=Integer.parseInt(in2[1]);
							}
							//store table complete.
							//now main work
							long V[][]=new long[n+1][W+1];
							Arrays.fill(V[0],0);
							
							for(int i=1;i<=n;i++)
							{
								for(int w=0;w<=W;w++)
								{
									if((arr_w[i]<=w) && (arr_v[i]+V[i-1][w-arr_w[i]])>V[i-1][w])
										V[i][w]=arr_v[i]+V[i-1][w-arr_w[i]];
									else
										V[i][w]=V[i-1][w];
								}
							}
							/////
							
							/*for(int y=0;y<=W;y++)
								System.out.print(" "+V[n][y]+" ");
							System.out.println();*/
							/////topcoder support
							int y=0;
							for(y=W;y>=0;y--)
							{
								if(V[n][y]!=V[n][y-1])
									break;
							}
							//y--;
							/////
							System.out.println(y+" "+V[n][W]);
							String blank=br.readLine();
						}
					}
				}