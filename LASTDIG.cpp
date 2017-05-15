#include<math.h>
#include<stdio.h>
int main()
{
    long long int a , b , n, i , k;
    scanf("%lld", &n);
    for (i=0;i<n;i++)
    {
        scanf("%lld %lld", &a , &b);
                
        if(b==0&&a==0)
            k=1;
        else if (b==0 )
            k=1;
        else if (a==0)
            k=0;
        else
        {                    
            if (b%4==0)
                b = 4;
            else
                b=b%4;
            k = pow(a, b);
        }    
            k = k%10;    
            printf("%lld\n", k);        
    }
    return 0;
}