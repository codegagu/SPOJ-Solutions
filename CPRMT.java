

			import java.util.*;
			import java.io.*;
			class Main
			{
				public static void main(String arg[])
				throws IOException
				{
					BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
					String str1="",str2="";
					int a[]=new int[123];int b[]=new int[123];
					//checking for EOF
					while((str1=br.readLine())!=null && (str2=br.readLine())!=null && str1.length()!=0 && str2.length()!=0)
					{
						//now we have got both the strings
						Arrays.fill(a, 0);
						Arrays.fill(b, 0);

						for(int i=0;i<str1.length();i++)
						{
							int index=(int)str1.charAt(i);
							a[index]++;
						}
						for(int i=0;i<str2.length();i++)
						{
							int index=(int)str2.charAt(i);
							b[index]++;
						}
						//working
						String short_one="";
						if(str1.length()<str2.length())
							short_one=str1;
						else
							short_one=str2;
						
						String ans="";
						ArrayList<Character> list=new ArrayList<Character>();
						for(int i=0;i<short_one.length();i++)
						{
							if(list.contains(short_one.charAt(i)))//to check duplicate chars
								continue;
							list.add(short_one.charAt(i));
							
							int index=(int)short_one.charAt(i);
							//System.out.println(index+" index");
							if(a[index]!=0 && b[index]!=0)
							{
								//System.out.println("inside "+a[index]+" "+b[index]);
								for(int j=0;j<Math.min(a[index], b[index]);j++)
									ans+=short_one.charAt(i);
							}
							//System.out.println(ans+" check now");
						}
						//System.out.println(ans+" hhamam "+short_one);
						char c[]=ans.toCharArray();
						Arrays.sort(c);
						System.out.println(new String(c));
						
						list.clear();
						
					}
				}
			}