


        #include <cstdio>
        #include <algorithm>
        #include<cmath>
        using namespace std;

        double area(double a1,double a2,double a3)
        {
            double s=(a1+a2+a3)/2.0;
            return sqrt(s*(s-a1)*(s-a2)*(s-a3));
        }

        int main()
        {
            int t;
            scanf("%d",&t);
            while(t--!=0)
            {
                double U,V,W,u,v,w,a,b,c,d,X,Y,Z,x,y,z;
                scanf("%lf%lf%lf%lf%lf%lf",&w,&v,&u,&U,&V,&W);

                X=(w-U+v)*(U+v+w);
                x=(U-v+w)*(v-w+U);
                Y=(u-V+w)*(V+w+u);
                y=(V-w+u)*(w-u+V);
                Z=(v-W+u)*(W+u+v);
                z=(W-u+v)*(u-v+W);

                a=sqrt(x*Y*Z);
                b=sqrt(y*Z*X);
                c=sqrt(z*X*Y);
                d=sqrt(x*y*z);

                double volume=0;
                double sa=0;

                sa=area(V,w,u);
		                sa+=area(W,v,u);
		                sa+=area(U,w,v);
		                sa+=area(U,V,W);
                //printf("%lf\n",sa);
                volume=( sqrt((-a+b+c+d)*(a-b+c+d)*(a+b-c+d)*(a+b+c-d)) )/(192*u*v*w);
                volume*=3.0;
                printf("%.4lf\n",(volume/sa));


            }

            return 0;
        }
