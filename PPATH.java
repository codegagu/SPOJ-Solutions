


		import java.io.*;
		import java.util.*;
		class Main
		{
			private static PrintWriter out;
			static boolean isPrime[];
			static boolean visited[];
			static HashMap<Integer,ArrayList<Integer>> graph=new HashMap<Integer,ArrayList<Integer>>(); 
			static HashMap<Integer,Integer> path_value;
			
			public static void main(String args[])
			throws IOException
			{
				out = new PrintWriter (System.out, true);
				BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
				// prime sieve
				isPrime = new boolean[10000 + 4];
				visited = new boolean[10000 + 4];
				
				
				Arrays.fill(isPrime, true);
				isPrime[0]=isPrime[1]=false;
				for(int i=2;i*i<=10001;i++)
				{
					//if i is prime mark the multiples of i as non prime
					if(isPrime[i])
					{
						for(int j=i;i*j<=10001;j++)
							isPrime[i*j]=false;
					}
				}
				create_map();
				
				int t=Integer.parseInt(br.readLine());
				while(t--!=0)
				{
					String in[]=br.readLine().split(" ");
					int a=Integer.parseInt(in[0]);
					int b=Integer.parseInt(in[1]);
					fillwith_INF();
					Arrays.fill(visited, false);
					int ans=bfs(a,b);
					if(ans!=-1)
						out.println(ans);
					else
						out.println("Impossible");
				}
				out.flush();
				out.close();
			}
			
			static void fillwith_INF()
			{
				//initialize the hashmap set distances to INF
				path_value=new HashMap<Integer,Integer>();
				for(int i=1001;i<=9999;i++)
				{
					if(isPrime[i])
						path_value.put(i, Integer.MAX_VALUE);
				}
			}
			
			
			static void create_map()
			{
				
				for(int i=1001;i<=9999;i+=1)
				{
					//if the number is a prime then extract all digits and find all combinations
					if(isPrime[i])
					{					
						int a=i/1000;
						int b=(i/100)%10;
						int c=(i/10)%10;
						int d=i%10;
						int e;
						//replace each digit through a range of 0-9
						for(int p=0;p<=9;p++)
						{
							
							if(p!=0 && isPrime[e=(p * 1000 + b*100 + c*10 + d)])
							{//System.out.println(e+"hhhaaa");
								if(!graph.containsKey(i))
								{
									ArrayList<Integer> empty=new ArrayList<Integer>();
									graph.put(i, empty);
								}
								ArrayList<Integer> get=graph.get(i);
								get.add(e);
								graph.put(i, get);
							}
							if(isPrime[e=(a*1000 + p * 100 + c*10 + d)])
							{//System.out.println(e+"hhhaaa");
								if(!graph.containsKey(i))
								{
									ArrayList<Integer> empty=new ArrayList<Integer>();
									graph.put(i, empty);
								}
								ArrayList<Integer> get=graph.get(i);
								get.add(e);
								graph.put(i, get);
							}
							if(isPrime[e=(a*1000 + b*100 + p * 10 + d)])
							{//System.out.println(e+"hhhaaa");
								if(!graph.containsKey(i))
								{
									ArrayList<Integer> empty=new ArrayList<Integer>();
									graph.put(i, empty);
								}
								ArrayList<Integer> get=graph.get(i);
								get.add(e);
								graph.put(i, get);
							}
							if(isPrime[e=(a*1000 + b*100 + c*10 + p)])
							{//System.out.println(e+"hhhaaa");
								if(!graph.containsKey(i))
								{
									ArrayList<Integer> empty=new ArrayList<Integer>();
									graph.put(i, empty);
								}
								ArrayList<Integer> get=graph.get(i);
								get.add(e);
								graph.put(i, get);
							}
						}
					}
				}
			}
			
			
			static int bfs(int source,int destination)
			{
				path_value.put(source, 0);
				Queue<Integer> queue = new LinkedList();
				queue.add(source);
				
				while(!queue.isEmpty())
				{
					int u=queue.remove();
					if(visited[u]==true)//if this has already been visited
						continue;
					else
						visited[u]=true;
					int base_dist=path_value.get(u);
					//for each v in the adjacent list of u; their distances would be base_distance+1
					ArrayList<Integer> adj_list=graph.get(u);
					Iterator<Integer> it=adj_list.iterator();
					while(it.hasNext())
					{
						int v=it.next();
						if(!visited[v])//if v is not yet visited then only queue it. this is to avoid avoid entry of a node more than once.
							queue.add(v);
						path_value.put(v, Math.min(path_value.get(v), base_dist+1));
						//System.out.println(v);
						if(v==destination)
							return (path_value.get(v));
						
					}
				}
				return -1;
				
			}
		}
		