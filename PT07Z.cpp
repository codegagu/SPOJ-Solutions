

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
    #define N 10010

    typedef long long ll;
    //int dx[]= {-1,0,1,0};
    //int dy[]= {0,1,0,-1};

    vector<int> graph[N];
    int visited1[N];
    int visited2[N];

    int dist=-1;
    int ans=-1;
    int far_id=-1;

    void dfs1(int u,int covered)
    {
        if(visited1[u])
            return;

        if(covered>dist)
        {
            dist=covered;
            far_id=u;
        }


        visited1[u]=1;

        for(int i=0;i<graph[u].size();i++)
        {
            int v=graph[u][i];
            dfs1(v,covered+1);
        }
    }

    void dfs2(int u,int covered)
    {
        if(visited2[u])
            return;

        if(covered>ans)
        {
            ans=covered;
            far_id=u;
        }


        visited2[u]=1;

        for(int i=0;i<graph[u].size();i++)
        {
            int v=graph[u][i];
            dfs2(v,covered+1);
        }
    }


    int main()
    {
        /*int t;
        scanf("%d",&t);
        while(t--)
        {*/
            int n;
            scanf("%d",&n);
            for(int i=0;i<=n;i++)
                graph[i].clear();


            memset(visited1,0,sizeof(visited1));
            memset(visited2,0,sizeof(visited2));
            dist=-1;
            ans=-1;
            far_id=-1;


            int start=0;
            bool gate=1;

            for(int i=0;i<n-1;i++)
            {
                int u,v;
                scanf("%d%d",&u,&v);
                if(gate){start=u;gate=0;}

                graph[u].pb(v);
                graph[v].pb(u);
            }



            dfs1(start,0);
            dfs2(far_id,0);
            printf("%d\n",ans);

        //}

        return 0;
    }




