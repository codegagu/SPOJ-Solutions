

    #include <bits/stdc++.h>
    using namespace std;

    #define pii pair<int,int>
    #define pip pair<int,pii>
    #define pb push_back
    #define mp make_pair
    #define ff first
    #define ss second
    #define MOD 1000000007
    #define MAX 5000

    typedef long long ll;
    //int dx[]={1,-1,0,0};
    //int dy[]={0,0,1,-1};

    vector<int> graph[MAX+1],graphT[MAX+1],sorted;
    bool visited[MAX+1];
    int component[MAX+1],soln[MAX+1];

    void init(int n)
    {
        for(int i=0;i<=n;i++)
        {
            graph[i].clear();
            graphT[i].clear();
            visited[i]=false;
        }
        sorted.clear();
    }

    void dfs1(int u)
    {
        visited[u]=1;
        for(int i=0;i<graph[u].size();i++)
        {
            int v=graph[u][i];
            if(!visited[v])
                dfs1(v);
        }
        sorted.push_back(u);
    }

    void dfs2(int u,int c)
    {
        visited[u]=false;
        component[u]=c;
        for(int i=0;i<graphT[u].size();i++)
        {
            int v=graphT[u][i];
            if(visited[v])
                dfs2(v,c);
        }
    }

    int main()
    {
        int u,v;
        while(true)
        {
            int n,m;
            scanf("%d",&n);
            if(n==0)
                break;

            init(n);
            scanf("%d",&m);
            for(int i=0;i<m;i++)
            {
                scanf("%d%d",&u,&v);
                graph[u].pb(v);
                graphT[v].pb(u);
            }

            for(int i=1;i<=n;i++)
            {
                if(!visited[i])
                    dfs1(i);
            }

            int component_number=0;
            for(int i=sorted.size()-1;i>=0;i--)
            {
                if(visited[ sorted[i] ])
                {
                    dfs2(sorted[i],component_number++);
                    soln[ component_number-1 ]=true;//denotes no of components present in graph
                }
            }

            for(int i=1;i<=n;i++)
            {
                for(int j=0;j<graph[i].size();j++)
                {
                    int v=graph[i][j];
                    if(component[i]!=component[v])
                    {
                        soln[component[i]]=false;
                        break;
                    }
                }
            }

            for(int i=1;i<=n;i++)
            {
                if(soln[component[i]])
                    printf("%d ",i);
            }
            printf("\n");


        }

        return 0;
    }
