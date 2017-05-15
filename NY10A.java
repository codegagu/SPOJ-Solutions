
		import java.util.*;
		import java.io.*;
		class Main
		{
			public static void main(String args[])
			throws IOException
			{
				BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
				int n=Integer.parseInt(br.readLine().trim());
				while(n--!=0)
				{
					int x=Integer.parseInt(br.readLine().trim());
					LinkedHashMap<String,Integer> map=new LinkedHashMap<String,Integer>();
					map.put("TTT",0);
					map.put("TTH",0);
					map.put("THT",0);
					map.put("THH",0);
					map.put("HTT",0);
					map.put("HTH",0);
					map.put("HHT",0);
					map.put("HHH",0);
					
					String str=br.readLine().trim();
					int l=str.length();
					for(int i=0;i<=(l-3);i++)
					{
						String token=str.substring(i,i+3);
						int counter=map.get(token);
						map.put(token, counter+1);
					}
					System.out.print(x);
					Iterator iter=map.entrySet().iterator();
					while(iter.hasNext())
					{
						Map.Entry<String, Integer> pairs=(Map.Entry<String, Integer>)iter.next();
						System.out.print(" "+pairs.getValue());
					}
					System.out.println();
				}
			}
		}