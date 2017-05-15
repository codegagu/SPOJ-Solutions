    #include <bits/stdc++.h>
    using namespace std;


    #define pip pair<int,pii>
    #define pb push_back
    #define mp make_pair
    #define ff first
    #define ss second
    #define MOD 1000000007
    #define INF 1000000000

    typedef long long ll;
    #define pill pair<int,ll>
    //int dx[]={1,-1,0,0};
    //int dy[]={0,0,1,-1};

    int main()
    {
        int t;
        scanf("%d",&t);
        while(t--)
        {
            int a,b;
            scanf("%d%d",&a,&b);
            int arr[a];
            for(int i=0;i<a;i++)
                scanf("%d",&arr[i]);

            ll sum=0;
            int counter=0;
            int base=0;
            int mxcounter=-1;
            ll ans=INF;


            vector <pill> v;

            for(int i=0;i<a;i++)
            {
                sum+=arr[i];
                counter++;
                while(sum>b)
                {
                    sum-=arr[base++];
                    counter--;
                }

                if(counter>=mxcounter)
                {
                    if(counter==mxcounter)
                        ans=min(ans,sum);
                    else
                    {
                        ans=sum;
                        mxcounter=counter;
                    }

                }


            }

            //cout<<ans<<" "<<cmax<<endl;
            printf("%lld %d\n",ans,mxcounter);


        }
        return 0;
    }


