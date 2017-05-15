



		import java.io.*;
		import java.util.*;

		class Main
		{
			static HashMap<Integer,String> map=new HashMap<Integer,String>();
			
			public static void main(String args[])
			throws IOException
			{
				BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
				int n=Integer.parseInt(br.readLine());
				//long start=System.nanoTime();
				while(n--!=0)
				{
					String str=br.readLine();
					while(str.length()==0)
						str=br.readLine();
					
					int key=Integer.parseInt(str.substring(0, str.indexOf(' ')));
					String value=str.substring(str.indexOf(' ')+1);
					map.put(key,value);
					
				}
				
			
				ArrayList<Integer> store=new ArrayList();
				
				
				
				Iterator iter=map.entrySet().iterator();
				int sum=0;
				while(iter.hasNext())
				{
					int turn=0;
					Map.Entry<Integer, String> pairs=(Map.Entry)iter.next();
					//System.out.println(pairs.getKey()+" "+pairs.getValue());
					String str=pairs.getValue();
					//System.out.println(str);
					StringTokenizer st=new StringTokenizer(str," ");
					while(st.hasMoreTokens())
					{
						
						int a=Integer.parseInt(st.nextToken());
						
						if(turn==0){
							turn++;
							continue;
						}
						if(!map.containsKey(a) && !store.contains(a))
						{
							//System.out.println(a+"  a");
							sum++;
							store.add(a);
						}
					}
					//iter.remove();
				}
				
				map.clear();
				store.clear();
				
				System.out.println(sum);
				
				//System.out.println((System.nanoTime()-start)/1000000000.0);
			}
		}