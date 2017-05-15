


        #include <cstdio>
        #include <algorithm>
        #include <iostream>
        using namespace std;
        #define ll unsigned long long 

        int main()
        {
            int n;
            while(scanf("%d",&n)==1 && n)
            {
                ll c[n+2];
                ll p[n+2];
                for(int i=0;i<n;i++)
                    scanf("%llu",&c[i]);
                for(int i=0;i<n;i++)
                    scanf("%llu",&p[i]);
                sort(c,c+n);
                sort(p,p+n);
                ll sum=0;
                for(int i=0;i<n;i++)
                sum+=p[i]*c[n-i-1];

                printf("%llu\n",sum);
            }
            return 0;
        }
