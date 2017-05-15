

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

    bool visited[100000+5];
    vector<int> G[100000+5];
    int ans;

    void dfs(int start)
    {
        queue<int> q;
        q.push(start);


        while(!q.empty())
        {
            int u=q.front();
            q.pop();
            for(int i=0;i<G[u].size();i++)
            {
                int v=G[u][i];
                if(visited[v]==1)
                    continue;
                visited[v]=1;
                q.push(v);
            }
        }

    }

    int main()
    {
        int t;
        scanf("%d",&t);
        while(t--)
        {
            int n;
            scanf("%d",&n);
            for(int i=0;i<n+2;i++)
            {
                visited[i]=0;
                G[i].clear();
            }


            int e;
            scanf("%d",&e);
            for(int i=0;i<e;i++)
            {
                int u,v;
                scanf("%d%d",&u,&v);
                G[u].pb(v);
                G[v].pb(u);
            }

            int cnt=0;
            for(int i=0;i<n;i++)
            {
                if(!visited[i]){
                    cnt++;
                    dfs(i);
                }
            }

            cout<<cnt<<endl;

        }

        return 0;
    }
