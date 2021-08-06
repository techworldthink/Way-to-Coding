#include <stdio.h>

int main() {
	//code
	int T,N,arr[100];
	int i,j;
	
	scanf("%d",&T);
	
	for(i=0;i<T;i++){
	    int min=9999,max=0;
	    scanf("%d",&N);
	    for(j=0;j<N;j++){
	        scanf("%d",&arr[j]);
	        if(arr[j]>max){max=arr[j];}
	        if(arr[j]<min){min=arr[j];}
	    }
	    printf("%d %d\n",max,min);
	}
	
	return 0;
}