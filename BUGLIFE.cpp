
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
        for(int k=1;k<=t;k++)
        {
            int n,rel,u,v;
            scanf("%d%d",&n,&rel);
            vector<int> graph[n+2];

            for(int i=0;i<rel;i++)
            {
                scanf("%d%d",&u,&v);
                graph[u].pb(v);
                graph[v].pb(u);
            }

            int colour[n+2];
            for(int i=0;i<n+2;i++)
                colour[i]=0;
            bool flag=0;

            for(int i=1;i<=n;i++)
            {
                if(colour[i]==0)colour[i]=1;

                for(int j=0;j<graph[i].size();j++)
                {
                    int nei=graph[i][j];
                    if(colour[nei]==colour[i])
                    {
                        flag=1;
                        break;
                    }
                    else
                    {
                        colour[nei]=-colour[i];
                    }
                }
                if(flag)
                    break;
            }

            if(flag)
            {
                cout<<"Scenario #"<<k<<":\nSuspicious bugs found!\n";
            }
            else
            {
                cout<<"Scenario #"<<k<<":\nNo suspicious bugs found!\n";
            }

        }

        return 0;
    }

