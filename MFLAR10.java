


			import java.util.*;
			import java.io.*;
			class Main
			{
				public static void main(String args[])
				throws IOException
				{
					BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
					String temp=br.readLine().trim();
					while(temp.length()==0)
						temp=br.readLine().trim();
					
					
					
					while(!temp.equals("*"))
					{
						
						char prev2=' ';
						char prev1=temp.charAt(0);
						if((int)prev1>=65 && (int)prev1<=90)//capital
							prev2=(char)((int)prev1+32);
						else//small
							prev2=(char)((int)prev1-32);
						
						
						
						
						int yo=0;
						StringTokenizer st=new StringTokenizer(temp," ");
						while(st.hasMoreTokens())
						{
							String token=st.nextToken();
							char chk=token.charAt(0);
							
							
							
							if(chk==prev1 || chk==prev2)
							{
								yo=1;
							}
							else
							{
								yo=0;
								break;
							}
							
						}
						
						if(yo==0)
							System.out.println("N");
						else
							System.out.println("Y");
						
						temp=br.readLine().trim();
						while(temp.length()==0)
							temp=br.readLine().trim();
					}
				}
			}