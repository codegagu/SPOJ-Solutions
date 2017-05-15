
        #include <cstdio>
        #include <algorithm>
        using namespace std;

        int main()
        {
            int t=0;
            scanf("%d",&t);
            while(t--!=0)
            {
                int u=0,v=0,diff=0,g=0;
                scanf("%d%d",&u,&v);
                if(u<v)
                    diff=v-u;
                else
                    diff=u-v;

                u=abs(u);
                v=abs(v);

                g=__gcd(u,v);
                diff=diff/g;
                printf("%d\n",diff);
            }
            return 0;
        }

