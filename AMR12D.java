

	import java.io.*;
	//import java.util.*;
	
	class Main
	{
		public static void main(String[] args)throws IOException 
		{
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			int t=Integer.parseInt(br.readLine());
			while(t--!=0)
			{
				String s=br.readLine();
				if(s.length()==0)
					s=br.readLine();
				String rev="";
				rev=new StringBuilder(s).reverse().toString();
				//System.out.println(s+" "+rev);
				if(s.equals(rev)) {
					System.out.println("YES");
					//System.out.println(s+" "+rev);
					}
				else {
					System.out.println("NO");
					//System.out.println(s+" "+rev);
				}
				
					
			}
		}
	}
