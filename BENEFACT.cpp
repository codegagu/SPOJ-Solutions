


        #include <cstdio>
        #include<algorithm>
        #include<iostream>
        #include<vector>
        using namespace std;
        #define pii pair <int, int>
        #define pb push_back
        #define ll long long

        ll Max=-9,Max2=-9;
        int visited[50000+10];
        int visited2[50000+10];
        vector <pii> G[50000+10];
        ll  dist[50000+10],  dist2[50000+10];
        int v2=0,v22=0;

        int dfs(int node)
        {
                visited[node]=1;


                for(int i=0;i<G[node].size();i++)
                {

                    if(!visited[ G[node][i].first ])
                    {

                        int cost= G[node][i].second;
                        dist[ G[node][i].first ]=max(dist[node]+cost, dist[ G[node][i].first ] );


                        if(dist[ G[node][i].first ]> Max){
                        	Max=dist[ G[node][i].first ];
                        	v2=G[node][i].first;
                        }

                        dfs( G[node][i].first );
                    }
                }

                return Max;
        }


        int dfs2(int node)
        {
                visited2[node]=1;


                for(int i=0;i<G[node].size();i++)
                {

                    if(!visited2[ G[node][i].first ])
                    {

                        int cost= G[node][i].second;
                        dist2[ G[node][i].first ]=max(dist2[node]+cost, dist2[ G[node][i].first ] );


                        if(dist2[ G[node][i].first ]> Max2){
                        	Max2=dist2[ G[node][i].first ];
                        	v22=G[node][i].first;
                        }

                        dfs2( G[node][i].first );
                    }
                }

                return Max2;
        }


        int main()
        {
            //vector <pii> G[50000+10];

            int t;
            scanf("%d",&t);
            while(t--)
            {
                Max=-9;Max2=-9;
                int n;
                scanf("%d",&n);

                for(int i=0;i<n+2;i++){
                    dist[i]=dist2[i]=0;
                    visited[i]=visited2[i]=0;
                    G[i].clear();
                }


                int a,b,l;

                for(int i=0;i<n-1;i++)
                {
                    scanf("%d%d%d",&a,&b,&l);
                    G[a].pb(pii(b,l));
                    G[b].pb(pii(a,l));
                }

                dist[1]=0;

                ll ans=dfs(1);
                for(int i=0;i<n+2;i++)
                    ans=max(ans,dist[i]);
                //cout<<"ans is "<<ans<<" node is "<<v2<<" \n";

                ans=0;
                dist2[v2]=0;
                ans=dfs2(v2);
                for(int i=0;i<n+2;i++)
                    ans=max(ans,dist2[i]);
                //cout<<"ans is "<<ans<<" node is "<<v22<<" \n";

                printf("%lld\n",ans);






            }
            return 0;
        }

