


			import java.io.*;
			import java.util.*;
			class TOE1
			{
				public static void main(String args[])
				throws IOException
				{
					BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
					int t=Integer.parseInt(br.readLine());
					while(t--!=0)
					{
						String str1=br.readLine().trim();
						while(str1.length()==0)
							str1=br.readLine().trim();
						String str2=br.readLine().trim();
						String str3=br.readLine().trim();
						boolean owin=false,xwin=false;int xcount=0,ocount=0,countdots=0;
						
						StringBuilder v1=new StringBuilder();
						StringBuilder v2=new StringBuilder();
						StringBuilder v3=new StringBuilder();

						String rd=str1.charAt(0)+""+str2.charAt(1)+""+str3.charAt(2);
						String ld=str1.charAt(2)+""+str2.charAt(1)+""+str3.charAt(0);
						
						for(int i=0;i<3;i++){
							char c1=str1.charAt(i);char c2=str2.charAt(i);char c3=str3.charAt(i);
							
							if(i==0) {v1.append(c1);v1.append(c2);v1.append(c3);}
							if(i==1) {v2.append(c1);v2.append(c2);v2.append(c3);}
							if(i==2) {v3.append(c1);v3.append(c2);v3.append(c3);}
							
							if(c1=='X')	xcount++; else if(c1=='O')ocount++; else countdots++;
							if(c2=='X')	xcount++; else if(c2=='O')ocount++; else countdots++;
							if(c3=='X')	xcount++; else if(c3=='O')ocount++;	else countdots++;						
						}

						String verstr1=v1.toString();
						String verstr2=v2.toString();
						String verstr3=v3.toString();
						
						if(str1.equals("OOO") || str2.equals("OOO") || str3.equals("OOO") || verstr1.equals("OOO") || verstr2.equals("OOO") || verstr3.equals("OOO") || rd.equals("OOO") || ld.equals("OOO"))
							owin=true;
						
						if(str1.equals("XXX") || str2.equals("XXX") || str3.equals("XXX") || verstr1.equals("XXX") || verstr2.equals("XXX") || verstr3.equals("XXX") || rd.equals("XXX") || ld.equals("XXX"))
						{
							if(owin) {System.out.println("no");continue;}
							
							if(xcount-ocount==1) {
								System.out.println("yes");xwin=true;
							}
							else {
								System.out.println("no");continue;
							}
						}
						else if(str1.equals("OOO") || str2.equals("OOO") || str3.equals("OOO") || verstr1.equals("OOO") || verstr2.equals("OOO") || verstr3.equals("OOO") || rd.equals("OOO") || ld.equals("OOO"))
						{
							if(xwin) {System.out.println("no");continue;}
							
							if(xcount-ocount==0) {
								System.out.println("yes");owin=true;
							}
							else {
								System.out.println("no");continue;
							}
						}
						else//no one wins :/
						{
							if(xcount-ocount==1) {					//draw
								System.out.println("yes");continue;}
							
							int spaces=9-countdots;
							if(spaces%2==0)
							{
								if(xcount==ocount)
									System.out.println("yes");
								else
									System.out.println("no");
							}
							else
							{
								if(xcount-ocount==1)
									System.out.println("yes");
								else
									System.out.println("no");
							}
							
						}
						//String blank=br.readLine();
					}
				}
			}