
    #include <bits/stdc++.h>
    using namespace std;

    #define pii pair<int,int>
    #define pip pair<int,pii>
    #define pb push_back
    #define mp make_pair
    #define ff first
    #define ss second
    #define MOD 1000000007
    #define INF 1000000000

    typedef long long ll;
    //int dx[]={1,-1,0,0};
    //int dy[]={0,0,1,-1};

    int main()
    {
        int t;
        scanf("%d",&t);
        while(t--)
        {
            int n,k;
            int neg_count=0;

            scanf("%d%d",&n,&k);
            int arr[n];
            for(int i=0;i<n;i++)
            {
                int temp;
                scanf("%d",&temp);
                arr[i]=temp;

                if(temp<0)
                    neg_count++;
            }



            if(neg_count>=k)
            {
                sort(arr,arr+n);
                for(int i=0;i<k;i++)
                    arr[i]=-arr[i];

                int sum=0;
                for(int i=0;i<n;i++)
                    sum+=arr[i];

                printf("%d\n",sum);
            }
            else
            {
                sort(arr,arr+n);
                int sum=0,i;
                for(i=0;i<neg_count;i++)
                    arr[i]=-arr[i];

                sort(arr,arr+n);
                int rem=k-neg_count;
                if(rem&1)//odd
                    sum-=arr[0];
                else
                    sum+=arr[0];

                i=1;
                while(i<n)
                    sum+=arr[i++];


                printf("%d\n",sum);
            }

        }

        return 0;
    }

