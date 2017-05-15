

        #include <cstdio>
        #include <iostream>
        using namespace std;

        int main()
        {
            int arr[200][200];
            int i,j,k,t,n;

            scanf("%d",&t);
            while(t--!=0)
            {
                scanf("%d",&n);

                for(i=0;i<n;i++)
                    for(j=0;j<n;j++)
                        scanf("%d",&arr[i][j]);

                bool verdict;
                for(i=0;i<n;i++)
                {
                    for(j=i+1;j<n;j++)
                    {
                        verdict=true;//initially i and j are neighbours
                        for(k=0;k<n;k++)
                            if(k!=i && k!=j && arr[i][j] == arr[i][k]+arr[k][j])//then i and j are not neighbours
                                verdict=false;


                        if(verdict)
                            printf("%d %d\n",i+1,j+1);

                    }
                }
            }

            return 0;
        }
