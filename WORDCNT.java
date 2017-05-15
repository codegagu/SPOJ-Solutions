
			import java.util.*;
import java.io.*;
			class Main
			{
				static HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
				
				public static void main(String args[])
				throws IOException
				{
					BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
					int t=Integer.parseInt(br.readLine().trim());
					while(t--!=0)
					{
						String input=br.readLine().trim();
						String first=input.substring(0,input.indexOf(' '));
						int prevlength=first.length();
						StringTokenizer st=new StringTokenizer(input," ");
						int counter=0;
						while(st.hasMoreTokens())
						{
							String str=st.nextToken();
							if(str.length()==prevlength)
							{
								counter++;
								prevlength=str.length();
							}
							else
							{
								if(map.containsKey(prevlength))
								{
									int oldvalue=map.get(prevlength);
									map.put(prevlength, Math.max(oldvalue, counter));
								}
								else
								{
									map.put(prevlength, counter);
								}
								prevlength=str.length();
								counter=1;
							}
							
						}
						
						if(map.containsKey(prevlength))
						{
							int oldvalue=map.get(prevlength);
							map.put(prevlength, Math.max(oldvalue, counter));
						}
						else
						{
							map.put(prevlength, counter);
						}
						
						
						Iterator it=map.entrySet().iterator();
						int big=0;
						while(it.hasNext())
						{
							Map.Entry<Integer,Integer> pairs=(Map.Entry)it.next();
							//System.out.println(pairs.getKey()+" = "+pairs.getValue());
							int yo= pairs.getValue();
							if(yo>big)
								big=yo;
							it.remove();
						}
						
						
						System.out.println(big);
						map.clear();
					}
				}
			}
