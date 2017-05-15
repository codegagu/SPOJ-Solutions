


			import java.io.*;
			class Main
			{
				public static void main(String args[])
				throws IOException
				{
					BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
					PrintWriter pw=new PrintWriter(System.out);
					String input=br.readLine();
					int dp[];
					while(!input.equals("0"))
					{
						dp=new int[input.length()+1];
						dp[0]=1;
						dp[1]=1;
						for(int i=1;i<input.length();i++)
						{
							int j=i+1;
							int charval=Integer.parseInt(Character.toString(input.charAt(i)));
							int preval=Integer.parseInt(Character.toString(input.charAt(i-1)));
							int nextval=-1;
							
							if(i<(input.length()-1))
								nextval=Integer.parseInt(Character.toString(input.charAt(i+1)));
							
							if(nextval==0)
								dp[j]=dp[j-1];
							else if(((charval!=0 && preval==1) || (charval<7 && preval==2)) && charval!=0)
								dp[j]=dp[j-1]+dp[j-2];
							else
								dp[j]=dp[j-1];
										
						}
						
						pw.println(dp[dp.length-1]);
						input=br.readLine();
					}
					pw.flush();
				}
			}