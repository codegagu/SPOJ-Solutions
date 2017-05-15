


		import java.io.*;
		import java.util.*;
		import java.math.*;
		class GUESSTHE
		{
			public static void main(String args[])
			throws IOException
			{
				BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
				String str="";
				while(!(str=br.readLine()).equals("*"))
				{
					char c[]=str.toCharArray();
					int arr[]=new int[21];int pos=0,pos2=0,counter=0,counter2=0;
					int arr2[]=new int[21];

					for(int i=0;i<c.length;i++)	{
						if(c[i]=='Y'){
							arr[pos++]=i+1;
							counter++;
						}
						else{
							arr2[pos2++]=i+1;
							counter2++;
						}
					}
					
					BigInteger ans1=new BigInteger(Integer.toString(arr[0]));
					for(int i=1;i<counter;i++) {
						ans1=lcm(ans1, new BigInteger(Integer.toString(arr[i])));
					}
					
					int yo=0;
					for(int i=0;i<counter2;i++)	{
						if(ans1.mod(new BigInteger(Integer.toString(arr2[i]))).equals(BigInteger.ZERO)  ) {
							yo=1;break;
						}
					}
					if(yo==1)
						System.out.println(-1);
					else
						System.out.println(ans1);
				}
				
			}
			
			
			static BigInteger lcm(BigInteger a, BigInteger b)
			{
				BigInteger b1 = new BigInteger(""+a); // there's a better way to do this. I forget.
			    BigInteger b2 = new BigInteger(""+b);
			    BigInteger gcd = b1.gcd(b2);
			    return b1.multiply(b2.divide(gcd));
			}
			
		}
		