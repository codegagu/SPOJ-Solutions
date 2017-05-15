



				import java.util.*;
				import java.io.*;
				class  Main
				{
					public static void main(String args[])
					throws IOException
					{
						BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
						List<Integer> mylist=new ArrayList<Integer>();
						int n=Integer.parseInt(br.readLine());
						int counter=0;
						while(n>3)
						{
							String str=Integer.toString(n);
							char arr[]=str.toCharArray();
							int sum=0;
							for(int i=0;i<arr.length;i++)
							{
								sum+=Math.pow(Integer.parseInt(Character.toString(arr[i])),2);
								
							}
							//System.out.println(sum);
							if(!mylist.contains(sum))
								mylist.add(sum);
							else
							{
								System.out.println(-1);
								System.exit(0);
							}
							n=sum;
							counter++;
						}
						
						if(n==1)
							System.out.println(counter);
						else 
							System.out.println(-1);
						mylist.clear();
					}
				}