


            #include <cstdio>
            #include <list>
            using namespace std;

            int main()
            {

                list<int> L;
                for(int i=2;i<=40000;i++)
                    L.push_back(i);

                int size=0,ans[3000];
                list <int> :: iterator it,it2;

                while(!L.empty() && size <3000)
                {

                    int k=L.front(),i=0;
                    ans[size++]=k;

                    for(it=L.begin();it!=L.end();it=it2,++i)
                    {
                        it2=it;it2++;
                        if(i%k==0)
                            L.erase(it);
                    }
                }

                int n;

                while(true)
                {
                    scanf("%d",&n);
                    if(n==0)
                        break;
                    printf("%d\n",ans[n-1]);
                }


                return 0;

            }
