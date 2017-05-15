

    #include <cstdio>
    #include <algorithm>
    using namespace std;

    int main()
    {
        int N,arr[100000];
        scanf("%d",&N);
        int i;
        for(i=0;i<N;i++)
            scanf("%d",&arr[i]);

        int result=arr[1]-arr[0];
        for(i=2;i<N;i++)
            result=__gcd(result,arr[i]-arr[i-1]);

        int ans=0;
        for(i=0;i<N-1;i++)
        {
            ans+=(arr[i+1]-arr[i])/result-1;
        }

        printf("%d\n",ans);
        return 0;
    }
