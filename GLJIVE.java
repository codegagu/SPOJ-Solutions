



			import java.io.*;
			class Main
			{
				public static void main(String args[])
				throws IOException
				{
					BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
					int sum=0,min_diff=Integer.MAX_VALUE,diff=0;
					int yo=0,store=0;
					for(int i=0;i<10;i++)
					{
						
						String str=br.readLine().trim();
						while(str.length()==0)
							str=br.readLine().trim();
						int a=Integer.parseInt(str);
						sum+=a;
						//System.out.println("sum is "+sum);
						diff=Math.abs(100-sum);
						//System.out.println("diff if "+diff);
						if(diff<min_diff){
							min_diff=diff;
							store=sum;
						}
						
						else if(diff==0)
						{
							System.out.println(sum);
							yo=1;
							break;
						}
						else if(diff==min_diff){
							System.out.println(sum);
							yo=1;
							break;
							}
					}
					if(yo==0)
						System.out.println(store);
				}
			}