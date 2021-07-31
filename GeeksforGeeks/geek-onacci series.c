#include <stdio.h>

#define N 99
#define LIMIT 4
	
int main() {
	//code
	int A[N][N],POS[N],T;
	int t_cases_loop,given_limit_loop;
	int nth_pos,loop_nth_pos,first_pos,count_three;
	int i,j;
	printf("\nEnter Total no of test cases : ");
	scanf("%d",&T);
	for(t_cases_loop=0;t_cases_loop<T;t_cases_loop++){
	    for(given_limit_loop=0;given_limit_loop<LIMIT-1;given_limit_loop++){
	        scanf("%d",&A[t_cases_loop][given_limit_loop]);
	    }
	    scanf("%d",&POS[t_cases_loop]);
	}
	for(t_cases_loop=0;t_cases_loop<T;t_cases_loop++){
	    nth_pos = POS[t_cases_loop];
	    first_pos = LIMIT-1;
	    
	    for(loop_nth_pos=0;loop_nth_pos<nth_pos-3;loop_nth_pos++){
	        A[t_cases_loop][first_pos]=0;
	        for(count_three=1;count_three<LIMIT;count_three++){
	            A[t_cases_loop][first_pos] += A[t_cases_loop][first_pos-count_three];
	        }
	        POS[t_cases_loop]=first_pos;
	        first_pos++;
	    }
	    printf("%d\n",A[t_cases_loop][POS[t_cases_loop]]);
	}
	return 0;
}
