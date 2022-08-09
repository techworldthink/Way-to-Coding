#include <stdio.h>

int main() {
	//code
	int T,N,A[100];
	int i,j;
	
	scanf("%d",&T);
	if(T>=1 && T<=100){
	for(i=0;i<T;i++){
	    scanf("%d",&N);
	    if(N>=1 && N<=100){
	    for(j=0;j<N;j++){
	        scanf("%d",&A[j]);
	    }
	    //printf("\n");
	    for(j=N-1;j>=0;j--){
	        printf("%d ",A[j]);
	    }
	    printf("\n");
	    }
	}
	}
	return 0;
}