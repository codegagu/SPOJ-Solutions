


            #include<iostream>
            #include <cstdio>
            #include <vector>
            #include <algorithm>
            using namespace std;

            vector <int> G[100000+5];
            int f[100000+5];
            int g[100000+5];
            int visited[100000+5];

            void dfs(int node)
            {
                visited[node]=1;

                if(G[node].size()==1 && node!=1)//leaf node
                {
                    f[node]=1;
                    g[node]=0;
                    return;
                }
				f[node]=1;
                for(int i=0;i<G[node].size();i++)
                {

                    if(!visited[G[node][i]])
                    {
                        dfs(G[node][i]);
                        g[node]+=f[G[node][i]];
                        f[node]+=min(f[G[node][i]],g[G[node][i]]);

                    }
                }

            }

            int main()
            {
                int n;
                int u,v;
                scanf("%d",&n);
                for(int i=0;i<n-1;i++)
                {
                    scanf("%d%d",&u,&v);
                    G[u].push_back(v);
                    G[v].push_back(u);
                }

                dfs(1);
                int ans=min(f[1],g[1]);
                printf("%d\n",ans);

               /* cout<< f[1] <<" " << f[2] << "  "<< f[3]<< "  " << f[4] << "  "<< f[5]<< "  " << f[6]<< "  " << f[7]<< "  " << f[8]<< "  " << f[9] << "  "<< f[10] << "  \n";
                cout<< g[1] <<" " << g[2] << "  "<< g[3]<< "  " << g[4] << "  "<< g[5]<< "  " << g[6]<< "  " << g[7]<< "  " << g[8]<< "  " << g[9] << "  "<< g[10] << "  ";
				*/

                return 0;
            }
