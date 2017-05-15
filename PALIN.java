


			import java.io.*;
			class Main
			{
				public static void main(String args[])
				throws IOException
				{
					BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
					int t=Integer.parseInt(br.readLine());
					//long start=System.nanoTime();
					while(t--!=0)
					{
						String str=br.readLine();
						int l=str.length();
						if(l%2==1)//odd
							System.out.println(l_odd(str,l/2));
						else
							System.out.println(l_even(str,(l/2)-1));
					}
					//System.out.println((System.nanoTime()-start)/1000000000.0);
				}
				
				static String l_odd(String str,int mid)
				{
					char c[]=str.toCharArray();
					//immediate terminating cases like 99994 99995
					String f=new String(c,0,mid);
					String reverse_f=new StringBuilder(f).reverse().toString();
					String m=new String(c,mid,1);
					String l=new String(c,mid+1,mid);
					if(reverse_f.compareTo(l)>0)
					{
						//System.out.println("jingalala");
						String ans=f+m+reverse_f;
						return ans;
					}
					//
					int copy_mid=mid;
					char hold=c[copy_mid];
					hold++;int yo=0,yo2=0;
					String ans="";
					while(hold==':')//those cases in which middle char is 9
					{
						c[copy_mid]='0';
						if(copy_mid!=0)
							hold=c[--copy_mid];
						else
						{
							String fst=new String(c,0,mid);
							fst="1"+fst;
							ans=ans+fst;
							ans+=new StringBuilder(ans).reverse().toString();
							//System.out.println("hamba "+ans+" "+hold);
							yo=1;
						}
						hold++;
						yo2=1;
					}
					if(yo==0 && yo2==1)
					{
						//System.out.println("llalal");
						c[copy_mid]=hold;
						String fst=new String(c,0,mid);
						String middle=new String(c,mid,1);
						ans=fst+middle+new StringBuilder(fst).reverse().toString();
					}
					if(yo2==0)
					{
						//System.out.println("dhur baal");
						String rev_f=new StringBuilder(f).reverse().toString();
						if(rev_f.compareTo(l)>0)
							ans=f+(--hold)+rev_f;
						else
							ans=f+hold+rev_f;
					}
					return ans;
				}
				//////////////////////////////////////////////////
				static String l_even(String str,int mid)
				{
					char c[]=str.toCharArray();
					//immediate terminating cases like 998877 999877
					String f=new String(c,0,mid+1);
					String reverse_f=new StringBuilder(f).reverse().toString();
					String l=new String(c,mid+1,mid+1);
					if(reverse_f.compareTo(l)>0)
					{
						String ans=f+reverse_f;
						return ans;
					}
					//
					int copy_mid=mid;
					char hold=c[copy_mid];
					hold++;int yo=0,yo2=0;
					String ans="";
					while(hold==':')//those cases in which middle char is 9
					{
						c[copy_mid]='0';
						if(copy_mid!=0)
							hold=c[--copy_mid];
						else
						{
							String fst=new String(c,0,mid+1);
							fst="1"+fst;
							String rev_fst=fst.substring(0, fst.length()-1);
							rev_fst=new StringBuilder(rev_fst).reverse().toString();
							ans+=fst+rev_fst;
							//System.out.println("hamba "+ans+" "+hold);
							yo=1;
						}
						hold++;
						yo2=1;
					}
					if(yo==0 && yo2==1)
					{
						//System.out.println("llalal");
						c[copy_mid]=hold;
						//for(char ch:c)
							//System.out.print(ch);
						String fst=new String(c,0,mid+1);
						ans=fst+new StringBuilder(fst).reverse().toString();
					}
					if(yo2==0)
					{
						//System.out.println("dhur baal");
						char mid_char_1=str.charAt(mid);
						char mid_char_2=str.charAt(mid+1);
						int int_mid_char_1=Integer.parseInt(Character.toString(mid_char_1));
						int int_mid_char_2=Integer.parseInt(Character.toString(mid_char_2));
						if(int_mid_char_1>int_mid_char_2)
							int_mid_char_2=int_mid_char_1;
						else if(int_mid_char_1==int_mid_char_2)
						{
							int_mid_char_1++;
							int_mid_char_2++;
						}
						else if(int_mid_char_1<int_mid_char_2)
						{
							int_mid_char_1++;
							int_mid_char_2=int_mid_char_1;
						}
						String fst=str.substring(0, mid);
						String rev_fst=new StringBuilder(fst).reverse().toString();
						ans+=fst+Integer.toString(int_mid_char_1)+Integer.toString(int_mid_char_2)+rev_fst;
					}
					return ans;
				}
				
			}