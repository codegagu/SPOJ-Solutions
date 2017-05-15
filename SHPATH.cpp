



        #include<cstdio>
        #include<vector>
        #include<algorithm>
        #include<iostream>
        #include<map>
        #include<queue>
        #include<utility>
        using namespace std;

        #define pii pair<int ,int >
        #define pb push_back
        #define INF 1000000000;


        inline void inp(int *a)
        {
            register char c = 0;
            while (c<33) c = getchar_unlocked();
            *a = 0;
            while (c>33)
            {
                *a = *a*10+c-'0';
                c = getchar_unlocked();
            }
        }

        vector<pii> G[10005];
        bool visited[10005];
        int dist[10005];
        char str[15];

        struct cmp
        {
            bool operator() (const pii &a,const pii &b)
            {
                return a.second>b.second;
            }
        };


        map <string,int > city_index;
        map<string, int>::iterator it1,it2;
        int main()
        {

            int t;
            inp(&t);
            while(t--!=0)
            {
                city_index.clear();
                int n;
                inp(&n);
                for(int i=0;i<=n;i++)
                {
                    G[i].clear();
                    visited[i]=false;
                }
                for(int z=1;z<=n;z++)
                {
                    scanf("%s",str);
                    city_index[str]=z;
                    int m;
                    inp(&m);
                    for(int i=1;i<=m;i++)
                    {
                        int v,w;
                        inp(&v);inp(&w);
                        G[z].pb(pii(v,w));
                    }
                }

                int p;
                inp(&p);
                while(p--!=0)
                {
                    for(int i=1;i<=n;i++)
                    {
                        visited[i]=false;
                        dist[i]=INF;
                    }

                    char s1[15],s2[15];
                    scanf("%s %s",s1,s2);

                    int start=city_index[s1];
                    int final=city_index[s2];
                    dist[start]=0;

                    priority_queue<pii, vector<pii> , cmp> Q;
                    Q.push(pii(start,0));
                    while(!Q.empty())
                    {
                        int u=Q.top().first;
                        Q.pop();
                        if(visited[u])
                            continue;
                        int size=G[u].size();

                        for(int i=0;i<size;i++)
                        {
                            int v=G[u][i].first;
                            int w=G[u][i].second;

                            if(!visited[v] && dist[v]>dist[u]+w)
                            {
                                dist[v]=dist[u]+w;
                                Q.push(pii(v,dist[v]));
                            }
                        }

                        visited[u]=true;
                        if(u==final)
                            break;
                    }
                    printf("%d\n",dist[final]);
                }
            }
            return 0;
        }
