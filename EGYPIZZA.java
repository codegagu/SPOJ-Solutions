



				import java.util.*;
				import java.io.*;
				class EGYPIZZA
				{
					public static void main(String args[])
					throws IOException
					{
						BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
						int n=Integer.parseInt(br.readLine().trim());
						//ArrayList<Double> al=new ArrayList<Double>();
						int pizzareq=1;
						int half_count=0,onefourth_count=0,threefourth_count=0;
						while(n--!=0)
						{
							
							String str=br.readLine().trim();
							while(str.length()==0)
								str=br.readLine();
							
							if(str.equals("1/2"))
								half_count++;
							else if(str.equals("1/4"))
								onefourth_count++;
							else if(str.equals("3/4"))
								threefourth_count++;
							
						}
						//System.out.println(onefourth_count+" "+half_count+" "+threefourth_count);
						pizzareq+=threefourth_count;
						onefourth_count-=threefourth_count;
						//System.out.println(onefourth_count);
						int x1=0;
					    x1=half_count/2;
					    if(half_count%2==1)
					    {
					          x1++;
					          onefourth_count-=2;
					    }
					    //System.out.println(onefourth_count);
					    //System.out.println(x1+" "+pizzareq);
						pizzareq+=x1;
						//System.out.println(x1+" "+pizzareq);
						if(onefourth_count>0)
						{
							x1=(int)Math.ceil(onefourth_count/4.0);
							pizzareq+=(x1);
						}
						System.out.print(pizzareq);
					}
				}