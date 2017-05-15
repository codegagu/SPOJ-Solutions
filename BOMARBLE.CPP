

    #include<bits/stdc++.h>
    using namespace std;

    #define pii pair<int,int>
    #define pip pair<int,pii>
    #define ff first
    #define ss second
    #define FOR(i,n) for(int i=0; i<(int)n ;i++)
    #define REP(i,a,n) for(int i=a;i<(int)n;i++)
    #define pb push_back
    #define mp make_pair

    typedef long long ll;
    //int dx[]= {-1,0,1,0};
    //int dy[]= {0,1,0,-1};


    int main()
    {
        int n;
        scanf("%d",&n);
        while(n>0)
        {
            n++;
            int ans=(3*n*n-n)/2;
            cout<<ans<<endl;
            scanf("%d",&n);
        }

        return 0;
    }





