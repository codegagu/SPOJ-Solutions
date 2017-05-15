




			import java.io.*;
			class Main
			{
				public static void main(String args[])
				throws IOException
				{
					BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
					int t=Integer.parseInt(br.readLine().trim());
					while(t--!=0)
					{
						String in[]=br.readLine().trim().split(" ");
						double u=Double.parseDouble(in[0]);
						double U=Double.parseDouble(in[5]);
						double W=Double.parseDouble(in[1]);
						double w=Double.parseDouble(in[4]);
						double V=Double.parseDouble(in[2]);
						double v=Double.parseDouble(in[3]);
						double X=(w-U+v)*(U+v+w);
						double x=(U-v+w)*(v-w+U);
						double Y=(u-V+w)*(V+w+u);
						double y=(V-w+u)*(w-u+V);
						double Z=(v-W+u)*(W+u+v);
						double z=(W-u+v)*(u-v+W);
						
						double a=Math.sqrt(Math.abs(x*Y*Z));//
						double b=Math.sqrt(Math.abs(y*Z*X));//
						double c=Math.sqrt(Math.abs(z*X*Y));
						double d=Math.sqrt(Math.abs(x*y*z));
						
						double Volume=Math.sqrt((-a+b+c+d)*(a-b+c+d)*(a+b-c+d)*(a+b+c-d))/(192*u*v*w);
						
						System.out.printf("%.4f%n", Volume);
						
						
						
					}
				}
			}
			



			