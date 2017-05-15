


			import java.io.*;
			class Main
			{
				public static void main(String args[])
				throws IOException
				{
					BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
					PrintWriter pw=new PrintWriter(System.out);
					int t=Integer.parseInt(br.readLine());
					while(t!=0)
					{
						int num=0;
						String in[]=br.readLine().split(" ");
						int x=Integer.parseInt(in[0]);
						int y=Integer.parseInt(in[1]);
						//if x is even
						if(x%2==0)
						{
							if(y==x || y==(x-2))
							{
								//main code here
								if(y==x)
									num=x*2;
								else if(y==(x-2))
									num=(x*2)-2;
								
								pw.println(num);
								t--;
								continue;
							}
							else
							{
								pw.println("No Number");
								t--;
								continue;
							}
						}
						//if x is odd
						if(x%2==1)
						{
							if(y==x || y==(x-2))
							{
								//main code here
								if(y==x)
									num=(x*2)-1;
								else if(y==(x-2))
									num=((x*2)-1)-2;
								
								pw.println(num);
								t--;
								continue;
							}
							else
							{
								pw.println("No Number");
								t--;
								continue;
							}
						}
					}
					pw.flush();
				}
			}