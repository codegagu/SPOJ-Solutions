

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
    int dx[]={1,-1,0,0,-1,1,-1,1};
    int dy[]={0,0,1,-1,-1,1,1,-1};


    int main()
    {

        int t;
        scanf("%d",&t);
        while(t--)
        {
            int n;
            scanf("%d",&n);
            double sum=0;


            sum=3.0/4.0 - (1.0/(2*(1+n))) + (1.0/(2*(2+n)));

            printf("%.11f\n",sum);
        }

        return 0;
    }
