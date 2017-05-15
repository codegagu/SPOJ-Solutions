import java.io.*;
import java.util.Stack;
class Main
{
 
static Stack<Long> stack=new Stack<Long>();
 
public static void main(String args[])
throws IOException
{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        
        long n=Long.parseLong(br.readLine());
        damn(n);
}
        
 
        static void damn(long n)
        {
                
                int yo=0;
                if(n==0 || n==1)
                {
                        System.out.println("TAK");
                        System.exit(0);
                }
                
                stack.push(n);
                while(n>1)
                {
                        if(n%2==0)
                                n=n/2;
                        else
                break;
                }
                if(n ==1)
                    System.out.println("TAK");
        else
                System.out.println("NIE");
                
        }
                                                        
}
 