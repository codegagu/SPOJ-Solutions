



		import java.io.*;
		import java.util.*;
		class Main
		{
			public static void main(String args[])
			throws IOException
			{
				BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
				int t=Integer.parseInt(br.readLine());
				HashMap<Character,Integer> map=new HashMap<Character,Integer>();
				map.put('m', 1000);
				map.put('c', 100);
				map.put('x', 10);
				map.put('i', 1);
				while(t--!=0)
				{
					String in[]=br.readLine().split(" ");
					String first=in[0];
					String second=in[1];
					int sum1=0,sum2=0;
					for(int i=0;i<first.length();i++)
					{
						char c=first.charAt(i);
						if((int)c >=50 && (int)c<=57)//digit
						{
							sum1+=Integer.parseInt(Character.toString(c))*map.get(first.charAt(i+1));
							i++;
						}
						else if((int)c >=97 && (int)c<=122)
						{
							sum1+=map.get(c);
						}
					}
					
					for(int i=0;i<second.length();i++)
					{
						char c=second.charAt(i);
						if((int)c >=50 && (int)c<=57)//digit
						{
							sum2+=Integer.parseInt(Character.toString(c))*map.get(second.charAt(i+1));
							i++;
						}
						else if((int)c >=97 && (int)c<=122)
						{
							sum2+=map.get(c);
						}
					}

					int total_sum=sum1+sum2;
					String str=(Integer.toString(total_sum));
					//System.out.println(str);
					StringBuilder sb=new StringBuilder();
					char arr[]= {'m','c','x','i'};
					//String str="2";
					if(str.length()%2==0)//if even. pairs available. digit then letter first letter will be a digit
					{
						if(str.length()==4)
						{
							for(int i=0;i<str.length();i++)
							{
								char c=str.charAt(i);
								if(c=='0')
									continue;
								if((int)c>=49 && (int)c<=57)
								{
									if(c!='1')
										sb.append(c);
									sb.append(arr[i]);
								}
							}
						}
						else if(str.length()==2)
						{
							for(int i=0;i<str.length();i++)
							{
								char c=str.charAt(i);
								if(c=='0')
									continue;
								if((int)c>=49 && (int)c<=57)
								{
									if(c!='1')
										sb.append(c);
									sb.append(arr[i+2]);
								}
							}
						}
						System.out.println(sb.toString());
					}
					else// if odd,first digit will always be a letter
					{
						if(str.length()==3)
						{
							for(int i=0;i<str.length();i++)
							{
								char c=str.charAt(i);
								if(c=='0')
									continue;
								if((int)c>=49 && (int)c<=57)
								{
									if(c!='1')
										sb.append(c);
									sb.append(arr[i+1]);
								}
							}
						}
						else if(str.length()==1)
						{
							for(int i=0;i<str.length();i++)
							{
								char c=str.charAt(i);
								if(c=='0')
									continue;
								if((int)c>=49 && (int)c<=57)
								{
									if(c!='1')
										sb.append(c);
									sb.append(arr[i+3]);
								}
							}
						}
						System.out.println(sb.toString());
					}
				}//test cases
				
			}
		}