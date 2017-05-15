		
		
		
				
		import java.io.*;
		import java.util.*;
		import java.math.*;
		class Main
		{
			
			public static void main(String args[])
			throws IOException
			{
				BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
				int t=Integer.parseInt(br.readLine());
				
				while(t--!=0) 
				{
					String str=br.readLine();
					while(str.length()==0)
						str=br.readLine();
					
					StringTokenizer st=new StringTokenizer(str);
					
					Stack<Long> numstk=new Stack<Long>();
					Stack<String> opstk=new Stack<String>();
					
					while(st.hasMoreTokens())
					{
						String token=st.nextToken();
						if(token.equals("="))
						{
							System.out.println(numstk.pop());
							break;
						}
						
						if(token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/") )
						{
							
							opstk.push(token);
							continue;
						}
						
						long num=Long.parseLong(token);
						if(opstk.isEmpty())
						{
							numstk.push(num);
							
						}
						else
						{
							
							long num1=numstk.pop();
							String op=opstk.pop();
							if(op.equals("+"))
							{
								num1+=num;
							}
							else if(op.equals("-"))
							{
								num1-=num;
							}
							else if(op.equals("*"))
							{
								num1*=num;
							}
							else
							{
								num1/=num;
							}
							numstk.push(num1);
						}
							
					}
					
				}
				
					
			}
		}