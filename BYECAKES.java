



			import java.io.*;
			import java.util.*;
			class Main
			{
				
				
				
				public static void main(String args[])
				throws IOException
				{
					BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
					String temp=br.readLine().trim();
					int a[]=new int[4];
					int a1[]=new int[4];
					while(!(temp.equals("-1 -1 -1 -1 -1 -1 -1 -1")))
					{
						
						String in[]=temp.split(" ");
						a[0]=Integer.parseInt(in[0]);
						a[1]=Integer.parseInt(in[1]);
						a[2]=Integer.parseInt(in[2]);
						a[3]=Integer.parseInt(in[3]);
						a1[0]=Integer.parseInt(in[4]);
						a1[1]=Integer.parseInt(in[5]);
						a1[2]=Integer.parseInt(in[6]);
						a1[3]=Integer.parseInt(in[7]);
					
						double big=0.0;
						
						for(int i=0;i<4;i++)
						{
							int key=a[i];
							int value=a1[i];
							double ans=(double)key/(double)value;
							if(ans>big)
								big=ans;
							
						}
						
						
						int no_of_cakes=(int)Math.ceil(big);
						
						
						
						
						String ans="";
						
						for(int i=0;i<4;i++)
						{
							int key=a[i];
							int value=a1[i];
							//System.out.println("key "+key+" value"+ value);
							int total_req_amt=value*no_of_cakes;
							ans+=Integer.toString(total_req_amt-key)+" ";
						}
						
						
						System.out.println(ans.trim());
						temp=br.readLine().trim();
						
					}
				}
			}
			