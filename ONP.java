import java.util.*;
		import java.io.*;
		class Main
		{
			public static void main(String args[])
			throws IOException
			{
				BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
				PrintWriter pw=new PrintWriter(System.out);
				int t=Integer.parseInt(br.readLine());
				Stack<Character> stack=new Stack<Character>();
				while(t-->0)
				{
					String str=br.readLine();
					char arr[]=str.toCharArray();
					for(int i=0;i<arr.length;i++)
					{
						char c=arr[i];
						if(c=='(' || c=='+' || c=='-' || c=='*' || c=='/' || c=='^')
						stack.push(c);
						else if (c==')')
						{
							char p=stack.pop();
							while(p!='(')
							{
								pw.print(p);
								p=stack.pop();
							}
						}
						else
							pw.print(c);
					}
					pw.println();
				}
				pw.flush();
			}
		} 