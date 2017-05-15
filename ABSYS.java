



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
						if(br.readLine().equals(" "))
							continue;
						String s[]=br.readLine().split(" \\+ ");
						String a=s[0];
						String temp[]=s[1].split(" = ");
						String b=temp[0];
						String c=temp[1];
						int check=string_presence(c);
						if(check==1)
						{
							int A=Integer.parseInt(a);
							int B=Integer.parseInt(b);
							pw.println(a+" + "+b+" = "+(A+B));
							t--;
							continue;
						}
						else
						{
							int C=Integer.parseInt(c);
							int flag=string_presence(a);
							if(flag==0)
							{
								int A=Integer.parseInt(a);
								int B=C-A;
								pw.println(A+" + "+B+" = "+C);
								t--;
								continue;
							}
							else
							{
								int B=Integer.parseInt(b);
								int A=C-B;
								pw.println(A+" + "+B+" = "+C);
								t--;
								continue;
							}
						}
					}
					pw.flush();
				}
				
				public static int string_presence(String str)
				{
					int l=str.length();
					for(int i=0;i<l;i++)
					{
						char c=str.charAt(i);
						if((int)c>=97 && (int)c<=122)
						return 1;
					}
					return 0;
				}
				
			}