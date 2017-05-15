


		import java.io.*;
		import java.util.*;
		class Main
		{
			static BitSet visited;
			static HashMap<Character,ArrayList<Character>> graph;
			
			public static void main(String args[])
			throws IOException
			{
				BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
				int t=Integer.parseInt(br.readLine().trim());
				while(t--!=0)
				{
					int n=Integer.parseInt(br.readLine().trim());
					HashMap<Character,Integer> indegree=new HashMap<Character,Integer>();
					HashMap<Character,Integer> outdegree=new HashMap<Character,Integer>();
					visited=new BitSet(123);
					graph=new HashMap<Character,ArrayList<Character>>();
					boolean yo=true,pass=true;
					char start=' ';
					
					
					while(n--!=0)
					{
						
						String str=br.readLine().trim();
							//need one starting vertex for bfs :/
							if(yo)
							{
								start=str.charAt(0);
								//this is a case where the first string is a single character digit. rare case.
								//we can't determine whether this single node is disjoint or not. hence we need to add it to the graph for now 
								/*if(str.length()==1)
								{
									char c=str.charAt(0);
									ArrayList<Character> al=new ArrayList<Character>();
									graph.put(c, al);
								}*/
								yo=false;
							}
						
						//creating the graph,taking care of indegree and out degree
						if(str.length()>1)
						{
							
							char f=str.charAt(0);
							char l=str.charAt(str.length()-1);
							
							if(!graph.containsKey(f))
							{
								ArrayList<Character> al=new ArrayList();
								al.add(l);
								graph.put(f, al);
							}
							else
							{
								ArrayList<Character> get=graph.get(f);
								get.add(l);
								graph.put(f, get);
							}
							if(!graph.containsKey(l))
							{
								ArrayList<Character> al=new ArrayList();
								al.add(f);
								graph.put(l, al);
							}
							else
							{
								ArrayList<Character> get=graph.get(l);
								get.add(f);
								graph.put(l, get);
							}
							//doing default assignment to both maps. So that we can compare
							//required no of nodes to map size.
							if(!indegree.containsKey(f))
								indegree.put(f, 0);
							if(!indegree.containsKey(l))
								indegree.put(l, 0);
							if(!outdegree.containsKey(f))
								outdegree.put(f, 0);
							if(!outdegree.containsKey(l))
								outdegree.put(l, 0);
							
							
							indegree.put(l, indegree.get(l)+1);
							outdegree.put(f, outdegree.get(f)+1);
							
						}
						else//input string length is 1 
						{
							char c=str.charAt(0);
							if(!graph.containsKey(c))//means its disjoint
							{
								pass=false;break;
							}
						}
					}
					
					if(!pass)
					{
						System.out.println("The door cannot be opened.");
						continue;
					}
					
					
					int cardinality=bfs(start);
					
					//System.out.println(indegree.size()+"  "+outdegree.size());
					/*                CHECKING ALL MAPPINGS
					 * 
					 Iterator it = indegree.entrySet().iterator();
					    while (it.hasNext())  {
					        Map.Entry pairs = (Map.Entry)it.next();
					        System.out.println(pairs.getKey() + " = " + pairs.getValue());
					    }
					    System.out.println("----------------");
					    Iterator iter = outdegree.entrySet().iterator();
					    while (iter.hasNext()) {
					        Map.Entry pairs = (Map.Entry)iter.next();
					        System.out.println(pairs.getKey() + " = " + pairs.getValue());
					    }
					Iterator it = graph.entrySet().iterator();
				    while (it.hasNext())  {
				        Map.Entry pairs = (Map.Entry)it.next();
				        System.out.println("bara "+pairs.getKey());
				        ArrayList<Character> print=(ArrayList<Character>) pairs.getValue();
				        Iterator itr=print.iterator();
				        while(itr.hasNext())
				        	System.out.print(itr.next()+" ");
				        
				        System.out.println();
				    }*/
					
					
					//for the graph to be connected, cardinality must be equal to the graph size.
					//if its not,the the graph does not contain an eulerian tour
					
					if(cardinality!=indegree.size() || cardinality!=outdegree.size())//disconnected graph
					{
						System.out.println("The door cannot be opened.");
						continue;
					}
					
					//if you have reached till here it means that the graph is connected
					//now move on to check whether the properties of eulerian graph are satisfied or not.
					//I will iterate through the graph and for each key or node,do the necessary work with its in degree and out degree.
					
					int indeg_minus_outdeg_criterion=0;
					int outdeg_minus_indeg_criterion=0;
					boolean pass1=true;
					
					Iterator it = graph.entrySet().iterator();
				    while (it.hasNext())  
				    {
				        Map.Entry<Character,ArrayList<Character>> pairs = (Map.Entry<Character,ArrayList<Character>>)it.next();
				        char key= pairs.getKey();
				        int indeg=indegree.get(key);
				        int outdeg=outdegree.get(key);
				        
				        if(indeg_minus_outdeg_criterion > 1 || outdeg_minus_indeg_criterion > 1)
				        {
				        	pass1=false;break; 
				        }
				        
				        
				        if(indeg==outdeg)//cool
				        	continue;
				        else if(indeg-outdeg==1)
				        	indeg_minus_outdeg_criterion++;
				        else if(outdeg-indeg==1)
				        	outdeg_minus_indeg_criterion++;
				        else
				        {
				        	// god knows the enormous range of exceptional situations :/
				        	pass1=false;
				        	break;
				        }
				    }
				    
				    if(!pass1)
				    	System.out.println("The door cannot be opened.");
				    else
				    	System.out.println("Ordering is possible.");
					
					
				} //t
			}
			
			
			static int bfs(char start)
			{
				Queue<Character> q=new LinkedList();
				q.add(start);
				visited.set(start);
				while(!q.isEmpty())
				{
					char u=q.poll();
					//now get all v in the adjacent list of u
					ArrayList<Character> adj_list=graph.get(u);
					Iterator<Character> it=adj_list.iterator();
					while(it.hasNext())
					{
						char v=it.next();
						if(!visited.get(v))
						{
							visited.set(v);
							q.add(v);
						}
					}
				}
				return visited.cardinality();
			}
			
			
		}