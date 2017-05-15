
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



        struct cmp
        {
            bool operator() (const pii &a,const pii &b)
            {
                return a.ff<b.ff;
            }
        };

    int main()
    {

        int t;
        scanf("%d",&t);
        while(t--)
        {
            int n;
            scanf("%d",&n);
            int g_stat[n+1];
            int b_stat[n+1];
            int g_partner[n+1];
            int b_partner[n+1];
            int free_count=n;
            int b_num=0,g_num=0,boy,girl;

            for(int i=0;i<=n;i++)
                g_stat[i]=b_stat[i]=0;



            vector<pii > B[502];
            vector<pii > G[502];

            for(int i=1;i<=n;i++)
            {
                int pref=1;
                scanf("%d",&girl);
                vector<pii> temp;

                for(int j=1;j<=n;j++)
                {
                    scanf("%d",&b_num);
                    temp.pb(pii((pref++),b_num));
                }
                sort(temp.begin(),temp.end(),cmp());
                G[girl]=temp;//ete ache girl er selected boys list
            }

            for(int i=1;i<=n;i++)
            {
                int pref=1;
                scanf("%d",&boy);
                vector<pii> temp;

                for(int j=1;j<=n;j++)
                {
                    scanf("%d",&g_num);
                    temp.pb(pii((pref++),g_num));
                }
                sort(temp.begin(),temp.end(),cmp());
                B[boy]=temp;
            }


            while(free_count>0)
            {
                int b_id;
                for( b_id=1;b_id<=n;b_id++)
                {
                    if(b_stat[b_id]==0)
                        break;
                }
                vector <pii> g_list=B[b_id];

                for(int i=0;i<g_list.size();i++)
                {
                    int g_id=g_list[i].ss;
                    //cout<<" b_id "<<b_id<<" g_id "<<g_id<<endl;
                    //if the girl is free m,w become engaged
                    if(g_stat[g_id]==0)
                    {
                        g_partner[g_id]=b_id;
                        b_partner[b_id]=g_id;
                        b_stat[b_id]=1;
                        g_stat[g_id]=1;

                        free_count--;
                        //cout<<b_id<<" married "<<g_id<<endl;
                        break;
                    }
                    else// if not free chose the better guy
                    {
                        int other_guy=g_partner[g_id];
                        //cout<<" clash!!! homeguy "<<b_id<<" girl "<<g_id<<" otherboy "<<other_guy<<endl;

                        int pref_homeguy;
                        int pref_otherguy;

                        vector<pii> b_list=G[g_id];
                        for(int i=0;i<b_list.size();i++)
                        {
                            if(b_list[i].ss==b_id)
                                pref_homeguy=b_list[i].ff;
                            if(b_list[i].ss==other_guy)
                                pref_otherguy=b_list[i].ff;
                        }


                        //if girl prefers homeguy to otherguy
                        if(pref_homeguy<pref_otherguy)
                        {
                            //cout<<" beshi favourite chele "<<b_id<<endl;
                            g_partner[g_id]=b_id;
                            b_partner[b_id]=g_id;
                            //cout<<" "<<b_id<<" married "<<g_id<<endl;

                            b_stat[b_id]=1;
                            g_stat[g_id]=1;

                            b_stat[other_guy]=0;// RIP
                            b_partner[other_guy]=0;
                            break;
                        }
                        else//other guy is better
                        {
                            //cout<<" beshi favourite chele"<<other_guy<<endl;
                            g_partner[g_id]=other_guy;
                            b_partner[other_guy]=g_id;
                            //cout<<" "<<other_guy<<" married "<<g_id<<endl;

                            b_stat[other_guy]=1;
                            g_stat[g_id]=1;

                            b_stat[b_id]=0;// RIP
                            b_partner[b_id]=0;

                        }

                    }
                }


            }

            //print here
            for(int i=1;i<=n;i++)
                printf("%d %d\n",i,b_partner[i]);


        }

        return 0;
    }

