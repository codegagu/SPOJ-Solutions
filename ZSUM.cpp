


        #include <cstdio>
        using namespace std;


        long long modexpo(long long a,long long  b,long long c)
        {
            /*long long x=0,y=a%c;
            while(b>0)
            {
                if(b%2==1){
                    x=(x+y)%c;
                }
                y=(y*2)%c;
                b/=2;
            }
            return x%c;*/
                long long x=1,y=a; // long long is taken to avoid overflow of intermediate results
                while(b > 0){
                    if(b%2 == 1){
                        x=(x*y)%c;
                    }
                    y = (y*y)%c; // squaring the base
                    b /= 2;
                }
                return x%c;

        }

        int main()
        {

            long long n,k;
            scanf("%lld%lld",&n,&k);
            while(n)
            {
                long long a,b,c,d,ans;
                a=modexpo(n,k,10000007);
                b=modexpo(n,n,10000007);
                c=(2*modexpo(n-1,k,10000007))%10000007;
                d=(2*modexpo(n-1,n-1,10000007))%10000007;
                ans=((a+b)%10000007+(c+d)%10000007)%10000007;
                printf("%lld\n",ans);

                scanf("%lld%lld",&n,&k);

            }

            return 0;
        }
