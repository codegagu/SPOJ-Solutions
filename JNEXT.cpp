

    #include<bits/stdc++.h>
    using namespace std;

    #define pii pair<int,int>
    #define pip pair<int,pii>
    #define ff first
    #define ss second
    #define FOR(i,n) for(int i=0; i<(int)n ;i++)
    #define REP(i,a,n) for(int i=a;i<(int)n;i++)
    #define pb push_back
    #define mp make_pair
    #define INF 1000000000

    typedef long long ll;
    //int dx[]= {-1,0,1,0};
    //int dy[]= {0,1,0,-1};

    int arr[1000000+10];

    int main()
    {
        int t;
        scanf("%d",&t);
        while(t--)
        {
            int n;
            scanf("%d",&n);
            //memset(arr,0,n+1);
            for(int i=0;i<n;i++)
                scanf("%d",&arr[i]);

            int i;
            for( i=n-2;i>=0;i--)
                if(arr[i]<arr[i+1])
                    break;

            if(i<0)
            {
                cout<<-1<<endl;
                continue;
            }

            int d=i;
            int minn=INF;
            int p=0;

            for(i=d+1;i<n;i++)
            {
                if(arr[i]>arr[d] && arr[i]<minn)
                {
                    minn=arr[i];
                    p=i;
                }

            }

            int temp=arr[d];
            arr[d]=arr[p];
            arr[p]=temp;
            /*
            for(int i=0;i<n;i++)
            {
                cout<<arr[i];
            }
            cout<<endl;
            */


            sort(arr+d+1,arr+n);
            for(int i=0;i<n;i++)
                cout<<arr[i];
            cout<<endl;


        }

        return 0;
    }






