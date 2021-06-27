#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

#define MAX 6

//vertex count
int vertex_count =0;

// vertex definitions
struct vertex{
	char data;
	bool visited;
};

//array of vertices
struct vertex *graph[MAX];

//adjacency matrix
int adj_matrix[MAX][MAX];

//stack

int stack[MAX];
int top = -1;

void push(int data){
	stack[++top]=data;
}

int pop(){
	return stack[top--];
}

int peek(){
	return stack[top];
}

bool is_stack_empty(){
	return top == -1;
}

//add vertex to the vertex list
void add_vertex(char data){
	struct vertex *new = (struct vertex*)malloc(sizeof(struct vertex));
	new->data = data;
	new->visited = false;
	graph[vertex_count]=new;
	vertex_count++;
}

//add edge to edge array
void add_edge(int start,int end){
	adj_matrix[start][end]=1;
	adj_matrix[end][start]=1;
}

// to return adjacent vertex
int adj_vertex(int vertex_get){
	int i;
	for(i=0;i<vertex_count;i++){
		if(adj_matrix[vertex_get][i] == 1 && graph[i]->visited == false){
			return i;
		}
	}
	return -1;
}

// to display vertex value
void display_vertex(int pos){
	printf("%c",graph[pos]->data);
}

void dfs(){
	int i;
	int unvisited;
	
	graph[0]->visited =true;
	display_vertex(0);
	push(0);
	
	while(!is_stack_empty()){
		int unvisited = adj_vertex(peek());
		
	    if(unvisited == -1){
	    	pop();
	    }
	    else{
	    	graph[unvisited]->visited = true;
			display_vertex(unvisited);
			push(unvisited);
	    }
	}
	
	for(i=0;i<vertex_count;i++){
		graph[i]->visited = false;
	}
}

int main(){
	int i, j;

   for(i = 0; i < MAX; i++)    // set adjacency 
      for(j = 0; j < MAX; j++) // matrix to 0
         adj_matrix[i][j] = 0;
   

	add_vertex('A');
	add_vertex('B');
	add_vertex('C');
	add_vertex('D');
	add_vertex('E');
	
	
	add_edge(0,1);
	add_edge(0,2);
	add_edge(0,3);
	add_edge(1,4);
	add_edge(2,4);
	add_edge(3,4);
	
	dfs();
	
	return 0;
}
