#include<stdio.h>
#include<stdlib.h>
#include<stdbool.h>

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

//Queuee

int queue[MAX];
int rear=-1;
int front=0;
int queue_count=0;

void enqueue(int data){
	queue[++rear]=data;
	queue_count++;
}

int dequeue(){
	queue_count--;
	front++;
	return queue[front];
}

bool is_queue_empty(){
	return queue_count == 0;
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

void bfs(){
	int i;
	int unvisited;
	
	graph[0]->visited =true;
	display_vertex(0);
	enqueue(0);
	
	while(!is_queue_empty()){
		int pop_vertex = dequeue();
		while((unvisited = adj_vertex(pop_vertex))!=-1){
			graph[unvisited]->visited = true;
			display_vertex(unvisited);
			enqueue(unvisited);
		}
	}
	
	for(i=0;i<vertex_count;i++){
		graph[i]->visited = false;
	}
}

int main(){
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
	
	bfs();
	
	return 0;
}
