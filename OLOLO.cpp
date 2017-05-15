
    #include <bits/stdc++.h>
    using namespace std;

    int main()
    {
        int t;
        scanf("%d",&t);
        int num,ans=0;

        while(t--){
            scanf("%d",&num);
            ans^=num;
        }
        printf("%d\n",ans);
        return 0;
    }
