
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
        int t;
        scanf("%d",&t);
        while(t--)
        {
            string s;
            string num;

            int d_pos=-1;
            cin>>s;

            for(int i=0;i<s.size();i++)
            {
                if(s[i]=='.')
                {
                    d_pos=i;
                    continue;
                }
                num+=s[i];

            }

            if(d_pos!=-1)
            {
                int p=((s.size()-1)-d_pos);
                double deno=pow((double)10,(double)p);


                int numerator=atoi( num.c_str() );
                int denominator=(int)deno;
                int g=__gcd(numerator,denominator);
                int ans=denominator/g;

                printf("%d\n",ans);
            }
            else
            {
                cout<<1<<endl;
            }


        }
        return 0;
    }

