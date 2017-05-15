



				import java.io.*;
				class Main
				{
					public static void main(String args[])
					throws IOException
					{
						BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
						PrintWriter pw=new PrintWriter(System.out);
						int t=Integer.parseInt(br.readLine());
						while(t--!=0)
						{
							int n=Integer.parseInt(br.readLine());
							//System.out.println(n);
							int i=1,j=1,counter=1;
							while(counter!=n)
							{
								if(i==1 && j%2==1)
								{
									j++;
									counter++;
									//System.out.println("hamba "+i+"/"+j);
									continue;
								}
								
								if(i==1 && j%2==0)
								{
									while(j!=1 && counter!=n)
									{
										i++;
										j--;
										//System.out.println("hamba "+i+"/"+j);
										counter++;
									}
									continue;
								}
								
								if(j==1 && i%2==0)
								{
									i++;
									counter++;
									//System.out.println("hamba "+i+"/"+j);
									continue;
								}
								
								if(j==1 && i%2==1)
								{
									while(i!=1 && counter!=n)
									{
										i--;
										j++;
										//System.out.println("hamba "+i+"/"+j);
										counter++;
									}
									continue;
								}
							}
							
							pw.println("TERM "+n+" IS "+i+"/"+j);
						}
						pw.flush();
					}
				}