


        #include<cstdio>
        #include<algorithm>

        using namespace std;
        int main()
        {
            int t=0,m=0,n=0,i=0,j=0;

            scanf("%d",&t);
            while(t--!=0)
            {
                scanf("%d%d",&m,&n);
                --m;--n;

                int x[m];
                int y[n];
                int x_sum=0,y_sum=0;

                for(i=0;i<m;i++){
                    scanf("%d",&x[i]);
                    x_sum+=x[i];
                }
                for(i=0;i<n;i++){
                    scanf("%d",&y[i]);
                    y_sum+=y[i];
                }

                sort(x,x+m);
                sort(y,y+n);
                int ans=x_sum+y_sum;


                for(i=m-1,j=n-1;i>=0 && j>=0;){
                    if(x[i]>=y[j]){

                        x_sum-=x[i];
                        ans+=y_sum;
                        i--;
                    }
                    else{
                        y_sum-=y[j];
                        ans+=x_sum;
                        j--;
                    }
                }

                printf("%d\n",ans);


            }
            return 0;
        }
