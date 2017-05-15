


			import java.util.*;
			import java.io.*;
			class Main
			{
				
				static HashMap<Integer,ArrayList> my_map = new HashMap<Integer,ArrayList>();
				static int n;
				static PrintWriter pw=new PrintWriter(System.out);
				
				public static void main(String args[])
				throws IOException
				{
					BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
					//PrintWriter pw=new PrintWriter(System.out);
					String in[]=br.readLine().split(" ");
					n=Integer.parseInt(in[0]);
					int m=Integer.parseInt(in[1]);
					int start=0;
					if(m!=(n-1))
					{
						System.out.println("NO");
						System.exit(0);
					}
					String temp=br.readLine();
					while(temp != null && !temp.isEmpty())
					{
						String in1[]=temp.split(" ");
						int n1=Integer.parseInt(in1[0]);
						int n2=Integer.parseInt(in1[1]);
						start = n1;
						if(my_map.containsKey(n1))
						{
							ArrayList recv=my_map.get(n1);
							recv.add(n2);
							my_map.put(n1,recv);
						}
						else
						{
							ArrayList st=new ArrayList();
							st.add(n2);
							my_map.put(n1, st);
						}
						
						if(my_map.containsKey(n2))// ki  kore??
						{
							ArrayList recv=my_map.get(n2);
							recv.add(n1);
							my_map.put(n2, recv);
						}
						else
						{
							ArrayList st=new ArrayList();
							st.add(n1);
							my_map.put(n2, st);
						}
						temp=br.readLine();
					}
					dfs(start);
					
				}
				
				static BitSet visited=new BitSet();
				
				static void dfs(int start)
				{
					Stack<Integer> stck=new Stack<Integer>();
					stck.push(start);
					visited.set(start);
					while(!stck.isEmpty())
					{
						int node=stck.peek();
						//now find out all the unvisited nodes adjacent to 'node'
						int child=get_unvisited_childnode(node);
						if(child==0)
							stck.pop();
						else
							stck.push(child);
					}
					int check=visited.cardinality();
					if(check==n)
						pw.println("YES");
					else 
						pw.println("NO");
					pw.flush();
					
				}
				
				static int get_unvisited_childnode(int node)
				{
					ArrayList al=my_map.get(node);
					Iterator<Integer> iter=al.iterator();
					while(iter.hasNext())
					{
						int hold=iter.next();
						if(!visited.get(hold))
						{
							visited.set(hold);
							return hold;
						}
					}
					return 0;
				}
				
				
			}