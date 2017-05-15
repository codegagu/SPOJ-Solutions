
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
    int dx[]={1,-1,0,0,-1,1,-1,1};
    int dy[]={0,0,1,-1,-1,1,1,-1};


    int main()
    {

        int t;
        scanf("%d",&t);
        while(t--)
        {
            int rings=0;
            int in=0,out=0;
            scanf("%d",&rings);
            int inner[rings];
            int outer[rings];

            int M=-1;
            int corresponding=0;
            int pos=0;
            for(int i=0;i<rings;i++)
            {

                cin>>inner[i]>>outer[i];
                if(inner[i]>M)
                {
                    M=inner[i];
                    corresponding=outer[i];
                    pos=i+1;
                }
            }


            int flag=1;

            for(int i=0;i<rings;i++)
                if(outer[i] > M && outer[i]!=corresponding)
                {
                    flag=0;
                    break;
                }

            if(flag)
                cout<<pos<<endl;
            else
                cout<<-1<<endl;
        }

        return 0;
    }

