
    #include <bits/stdc++.h>
    using namespace std;

    int main()
    {

        int t;
        scanf("%d",&t);
        while(t--)
        {
            int n,k;
            scanf("%d%d",&n,&k);

            if(! ((n-k)&((k-1)>>1)) )
                cout<<1<<endl;
            else
                cout<<0<<endl;

        }

        return 0;
    }
