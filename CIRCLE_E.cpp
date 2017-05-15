
    #include <bits/stdc++.h>
    using namespace std;

    #define pii pair<int,int>
    #define pip pair<int,pii>
    #define pb push_back
    #define mp make_pair
    #define ff first
    #define ss second
    #define MOD 1000000007

    typedef long long ll;
    //int dx[]={1,-1,0,0};
    //int dy[]={0,0,1,-1};

    int main()
    {
        int t;
        scanf("%d",&t);
        while(t--){
            ll r1,r2,r3;
            scanf("%lld%lld%lld",&r1,&r2,&r3);

            ll r1r2=r1*r2;
            ll r1r3=r1*r3;
            ll r2r3=r2*r3;

            double deno1=r1r2+r1r3+r2r3;
            double deno2=sqrt(r1)*sqrt(r2)*sqrt(r3)*sqrt(r1+r2+r3)*2;
            double deno=deno1+deno2;

            double ans=(double)(r1*r2)/deno;
            ans*=r3;

            printf("%.6lf\n",ans);

        }

        return 0;
    }


