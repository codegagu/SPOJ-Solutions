

        #include <cstdio>
        #include <iostream>

        using namespace std;

        int main()
        {
            int t=0;
            long long int n=0;
            scanf("%d",&t);
            int k=0;
            while(t--!=0)
            {
                k++;
                scanf("%lld",&n);
                long long int arr[n];int i=0;
                for(i=0;i<n;i++)
                    scanf("%lld",&arr[i]);

                long long int sum=0,refuel=0;
                for(i=0;i<n;i++)
                {
                    sum+=arr[i];
                    if(sum<=0)
                    {
                        refuel+=1-sum;
                        sum=1;
                    }
                }

                if(refuel==0)
                    refuel=1;
                printf("Scenario #%d: %lld\n",k,refuel);
            }

            return 0;
        }
