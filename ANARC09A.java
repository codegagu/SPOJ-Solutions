


			import java.util.*;
			import java.io.*;
			class Main
			{
				public static void main(String args[])
				throws IOException
				{
					BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
					String str="";
					Stack<Character> stack=new Stack<Character>();
					int counter=0;
					while((str=br.readLine().trim()).charAt(0)!='-')
					{
						counter++;
						int ans=0;
						for(int i=0;i<str.length();i++)
						{
							char c=str.charAt(i);
							
							if(stack.empty() && c=='}')
							{
								stack.push('{');
								ans++;
								continue;
							}
							else if(c=='{')
								stack.push('{');
							else if(c=='}')//stack not empty here.
							{
								stack.pop();
							}
						}
						
						if(!stack.empty())
							ans=ans+(stack.size()/2);
						
						System.out.println(counter+". "+ans);
						stack.clear();
					}
					
					
				}
			}
			
