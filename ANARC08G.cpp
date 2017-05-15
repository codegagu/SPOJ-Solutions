

        #include <bits/stdc++.h>
        using namespace std;

        inline void inp(int *a)
        {
            register char c = 0;
            while (c<33) c = getchar_unlocked();
            *a = 0;
            while (c>33)
            {
                *a = *a*10+c-'0';
                c = getchar_unlocked();
            }
        }



        struct bank
        {
            int in;
            int out;
        };

        bank arr[1000+2];

        int main()
        {
            int c=0;
            while(true)
            {
                int n,total=0;
                c++;

                inp(&n);
                if(n==0)break;

                for(int i=0;i<=n+1;i++)
                    arr[i].out=arr[i].in=0;

                for(int i=1;i<=n;i++)
                {
                    for(int j=1;j<=n;j++)
                    {
                        int val;
                        inp(&val);
                        total+=val;
                        arr[i].out+=val;
                        arr[j].in+=val;
                    }
                }

                int ans=0;
                for(int i=1;i<=n;i++)
                {
                    if(arr[i].out-arr[i].in>=0)
                        ans+=(arr[i].out-arr[i].in);
                }

                printf("%d. %d %d\n",c,total,ans);
            }
            return 0;
        }
