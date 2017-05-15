

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

    typedef long long ll;
    //int dx[]= {-1,0,1,0};
    //int dy[]= {0,1,0,-1};

    void flip_it(char &c)
    {
        c= c=='1'? '0' : '1';
    }


    int main()
    {
        string s;
        int t=1;
        while(cin>>s)
        {
            bool flip=0;
            int ans=0;

            for(int i=0;i<s.size();i++)
            {
                if(flip)
                {
                    flip_it(s[i]);
                }

                if(s[i]=='1')
                {
                    flip_it(s[i]);
                    flip=!flip;
                    ans++;
                }
            }

            cout << "Game #" << t++ << ": " << ans << '\n';
        }

        return 0;
    }





