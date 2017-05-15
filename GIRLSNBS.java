



			import java.io.*;
			class Main			{
				public static void main(String args[])
				throws IOException
				{
					BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
					PrintWriter pw=new PrintWriter(System.out);
					String temp=br.readLine();
					while(!temp.equals("-1 -1"))
					{
						String in[]=temp.split(" ");
						int x=Integer.parseInt(in[0]);
						int y=Integer.parseInt(in[1]);
						int g=Math.max(x, y);
						int b=Math.min(x, y);
						if(g==b && g!=0 && b!=0)
							pw.println(1);
						else if(g==b)
							pw.println(0);
						else if(g==0)
							pw.println(b);
						else if(b==0)
							pw.println(g);
						else{
							if(g%(b+1)==0)
								pw.println(g/(b+1));
							else
								pw.println((g/(b+1))+1);
						}
						temp=br.readLine();
					}
					pw.flush();
				}
			}