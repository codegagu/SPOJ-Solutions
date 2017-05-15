
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
        string s,t;
        while(true)
        {
            cin>>s>>t;
            if(s=="*" && t=="*")
                break;
            int counter=0;

            for(int i=0;i<s.size();i++)
            {
                if(s[i]!=t[i])
                {
                    counter++;
                    for(int j=i+1;j<s.size();j++,i++)
                    {
                        if(s[j]==t[j])
                        {
                            //i=j;
                            break;
                        }
                    }
                }
            }
            printf("%d\n",counter);
        }

        return 0;
    }

