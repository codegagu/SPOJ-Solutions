



        #include <cstdio>
        #include <vector>
        #include <algorithm>

        using namespace std;

        #define pii pair<int , int >
        #define pip pair<int , pii >
        #define max 1005

        int parent[max];
        vector <pip> G;

        int findset(int x)
        {
            if(x!=parent[x])
                parent[x]=findset(parent[x]);
            return parent[x];
        }
        int main()
        {
            int t,n,m,u,v,w;
            long long p,sum=0;
            scanf("%d",&t);

            while(t--!=0)
            {

                scanf("%lld%d%d",&p,&n,&m);

                for(int i=0;i<=n;i++)
                    parent[i]=i;
                G.resize(m);
                for(int i=0;i<m;i++)
                {
                    scanf("%d%d%d",&u,&v,&w);
                    G[i]=pip(w,pii(u,v));
                }
                sort(G.begin(),G.end());
                //long long sum=0;
                for(int i=0;i<m;i++)
                {
                    u=findset(G[i].second.first);
                    v=findset(G[i].second.second);
                    if(u!=v)
                    {
                        sum+=(long long)G[i].first;
                        parent[u]=parent[v];
                    }

                }

                printf("%lld\n",sum*p);
            }

            return 0;

        }
