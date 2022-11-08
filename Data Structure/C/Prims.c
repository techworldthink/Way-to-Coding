#include<stdio.h>

#define MAX 10

int main(){
	int vertex_array[MAX],counter;
	int vertex_count=0;
	int row,column;
	int cost_matrix[MAX][MAX];
	int visited[MAX]={0};
	int edge_count=0,count=1;
	int sum_cost=0,min_cost=0;
	int row_no,column_no,vertex1,vertex2;
	
	printf("Total no of vertex :: ");
	scanf("%d",&vertex_count);
	
	printf("\n-- Enter vertex -- \n\n");
	for(counter=1;counter<=vertex_count;counter++){
		printf("vertex[%d] :: ",counter);
		scanf("%d",&vertex_array[counter]);
	}
	
	printf("\n--- Enter Cost matrix of size %d x %d  ---\n\n",vertex_count,vertex_count);
	printf("\n\t-- format is --\n");
	for(row=1;row<=vertex_count;row++){
		for(column=1;column<=vertex_count;column++){
			printf("x ");
		}
		printf("\n");
	}
	printf("\n-- MATRIX --\n\n");
	//Get edge weight matrix from user	
	for(row=1;row<=vertex_count;row++){
		for(column=1;column<=vertex_count;column++){
			scanf("%d",&cost_matrix[row][column]);
			if(cost_matrix[row][column] == 0){
				cost_matrix[row][column] = 999;
			}
		}
	}
	
	printf("\n");
	visited[1]=1;
	edge_count = vertex_count-1;
	
	while(count <= edge_count){
		for(row=1,min_cost=999;row<=vertex_count;row++){
			for(column=1;column<=vertex_count;column++){
				if(cost_matrix[row][column] < min_cost){
					if(visited[row] != 0){
						min_cost = cost_matrix[row][column];
						vertex1 = row_no = row;
						vertex2 = column_no = column;
					}
				}
			}
		}
		
		if(visited[row_no] == 0 || visited[column_no] ==0){
			printf("\nEdge %d is (%d -> %d) with cost : %d ",count++,vertex_array[vertex1],vertex_array[vertex2],min_cost);
			sum_cost = sum_cost + min_cost;
			visited[column_no]=1;
		}
		cost_matrix[vertex1][vertex2] = cost_matrix[vertex2][vertex1] = 999;
	}
	printf("\n\nMinimum cost=%d",sum_cost); 
	return 0;
}
