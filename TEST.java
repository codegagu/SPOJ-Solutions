import java.io.*;
class universe
{
	public static void main(String args[])
	throws IOException
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int n=0;
		while(n!=42)
		{
			n=Integer.parseInt(br.readLine());
			if(n==42)
				break;
			System.out.println(n);
		}
	}
}