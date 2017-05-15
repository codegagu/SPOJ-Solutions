


				
				import java.util.StringTokenizer;
				import java.util.Arrays;
				import java.io.*;
				class Main
				{
					public static void main(String args[])
					throws IOException
					{
						BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
						PrintWriter pw=new PrintWriter(System.out);
						String str="";
						
						int def[];
						while(!(str=br.readLine()).equals("0 0"))
						{
							String in[]=str.split(" ");
							int a=Integer.parseInt(in[0]);
							int d=Integer.parseInt(in[1]);
							def=new int[d];
							Arrays.fill(def,0);
							
							String attackers=br.readLine();
							StringTokenizer st=new StringTokenizer(attackers);
							int small=10000,sec_last,fst_last;
							while(st.hasMoreTokens())
							{
								int n=Integer.parseInt(st.nextToken());
								if(n<=small)
									small=n;
							}
							/////
							String defenders=br.readLine();
							StringTokenizer st2=new StringTokenizer(defenders);
							int i=0;
							while(st2.hasMoreTokens())
							{
								def[i++]=Integer.parseInt(st2.nextToken());
							}
							Arrays.sort(def);
							fst_last=def[0];
							sec_last=def[1];
							
							
							if((sec_last==small) || (fst_last<=small && sec_last<=small))
								pw.println("N");
							else
								pw.println("Y");
						}
						pw.flush();
					}
				}