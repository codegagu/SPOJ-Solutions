

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
        int t;
        scanf("%d",&t);
        while(t--)
        {
            int n;
            scanf("%d",&n);
            pii arr[n];

            for(int i=0;i<n;i++)
            {
                int s,f;
                scanf("%d%d",&s,&f);
                arr[i]=pii(mp(f,s));
            }
            sort(arr,arr+n);

            int counter=0;
            int curtime=-1;

            for(int i=0;i<n;i++)
            {
                if(arr[i].ss>=curtime)
                {
                    counter++;
                    curtime=arr[i].ff;
                }
            }

            printf("%d\n",counter);
        }

        return 0;
    }




