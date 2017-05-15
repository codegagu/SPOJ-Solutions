


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

        int t,n,m;
        scanf("%d%d%d",&n,&m,&t);
        while(t--)
        {
            int mx,my,c1x,c1y,c2x,c2y;
            scanf("%d%d%d%d%d%d",&mx,&my,&c1x,&c1y,&c2x,&c2y);

            if(mx<=c1x && mx <=c2x)
            {
                cout<<"YES\n";
                continue;
            }
            else if((n-mx)<=(n-c1x) && (n-mx)<=(n-c2x) )
            {
                cout<<"YES\n";
                continue;
            }
            else if(my<=c1y && my <=c2y)
            {
                cout<<"YES\n";
                continue;
            }
            else if((m-my)<=(m-c1y) && (m-my)<=(m-c2y) )
            {
                cout<<"YES\n";
                continue;
            }
            else
            {
                int mtop,ctop,mleft,cleft,mbot,cbot,mright,cright;

                mtop=mx;
                mbot=n-mx;
                mleft=my;
                mright=m-my;

                ctop=min(c1x+abs(c1y-my) ,c2x+abs(c2y-my) );
                cbot=min((n-c1x)+abs(c1y-my),(n-c2x)+abs(c2y-my));
                cleft=min( c1y+abs(mx-c1x) , c2y+abs(mx-c2x) );
                cright=min( m-c1y+abs(mx-c1x) , m-c2y+abs(mx-c2x) );

                if(mtop<ctop || mbot<cbot || mleft<cleft || mright<cright)
                    cout<<"YES\n";
                else
                    cout<<"NO\n";


            }

        }


        return 0;
    }
