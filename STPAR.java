

			import java.util.Arrays;
			import java.util.Stack;
			import java.util.StringTokenizer;
			import java.io.*;
			class Main
			{
				public static void main(String args[])
				throws IOException
				{
					BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
					PrintWriter pw=new PrintWriter(System.out);
					String temp=br.readLine().trim();
					while(!temp.equals("0"))
					{
						Stack<Integer> stack=new Stack<Integer>();
						int n=Integer.parseInt(temp);
						String str=br.readLine().trim();
						int newarr[]=new int[n];
						int ap=0;
						StringTokenizer st1=new StringTokenizer(str);
						while(st1.hasMoreTokens())
							newarr[ap++]=Integer.parseInt(st1.nextToken());
						
						
						//for()
						Arrays.sort(newarr);
						String compare="";
						for(int i: newarr)
							compare+=Integer.toString(i);
						////////////////////////////////////
						//System.out.println("hamba  "+compare+"\n"+str);
						StringTokenizer st=new StringTokenizer(str);
						int yo=1;
						String concat="";
						while(st.hasMoreTokens())
						{
							String s=st.nextToken();
							if(Integer.parseInt(s)==yo)
							{
								concat=" "+s+concat;
								yo++;
								while(!stack.empty()){
								if(stack.peek()==yo)
								{
									String hold=Integer.toString(stack.pop());
									concat=" "+hold+concat;
									yo++;
								}
								else
									break;
								}
							}
							else
								stack.push(Integer.parseInt(s));
						}
						while(!stack.empty())
						{
							String last=Integer.toString(stack.pop());
							concat=" "+last+concat;
						}
						//checking done here
						//System.out.println("concat--"+concat);
						String fans="";
						StringTokenizer st2=new StringTokenizer(concat);
						while(st2.hasMoreTokens())
							fans=st2.nextToken()+fans;
						
						if(fans.equals(compare))
							pw.println("yes");
						else
							pw.println("no");
						//System.out.println("yoyo  "+fans);
						temp=br.readLine().trim();
					}
					pw.flush();
				}
			}