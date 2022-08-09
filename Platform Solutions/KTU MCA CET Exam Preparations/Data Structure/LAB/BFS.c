#include<stdio.h>
#include<stdlib.h>
#include<stdbool.h>

#define MAX 10

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
	return queue[front++];
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
	printf("%c -> ",graph[pos]->data);
}

void bfs(struct vertex *new,int start){
	if(!new){
		printf("\nNothing to display\n");
		return;
	}
	    
	int i;
	int unvisited;
	
	printf("\n|||||||||||||||||||||||||||||||\n");
	
	new->visited =true;
	display_vertex(start);
	enqueue(start);
	
	while(!is_queue_empty()){
		int pop_vertex = dequeue();
		//printf("\npoped : %d",pop_vertex);
		while((unvisited = adj_vertex(pop_vertex))!=-1){
			graph[unvisited]->visited = true;
			display_vertex(unvisited);
			enqueue(unvisited);
		}
	}
	printf("\n|||||||||||||||||||||||||||||||\n");
	
	for(i=0;i<vertex_count;i++){
		graph[i]->visited = false;
	}
}

void show(){
	int i;
	printf("\n.................................\n");
	for(i=0;i<vertex_count;i++){
		printf("Edge postion of '%c' is %d\n",graph[i]->data,i);
	}
	printf(".................................\n");
}

int main(){
	int opt;
	char data;
	int edge_1,edge_2;
	int i, j;
	int start;

    for(i = 0; i < MAX; i++)    // set adjacency 
      for(j = 0; j < MAX; j++) // matrix to 0
         adj_matrix[i][j] = 0;
	
	do{
		printf("\n1)Add vertex \n2)Create edge \n3)Traversal \n0)Exit \nChoose option :: ");
		scanf("%d",&opt);
		switch(opt){
			case 1:
				printf("\nEnter data to be added to vertex : ");
				scanf(" %c", &data);
				add_vertex(data);
				break;
			case 2:
	         	show();
				printf("\nEnter edge starting : ");
				scanf("%d",&edge_1);
				printf("\nEnter edge ending : ");
				scanf("%d",&edge_2);
				if(vertex_count-1 < edge_1 || vertex_count-1 < edge_2){
					printf("\nThere is no vertex !!\n");
				}
				else{
					add_edge(edge_1,edge_2);
				}
				break;
			case 3:
				printf("\nEnter starting vertex position : ");
				scanf("%d",&start);
				bfs(graph[start],start);
				break;
			default:
				printf("\nInvalid option try again !! ...");
		}
	}while(opt!=0);
	
	return 0;
}



