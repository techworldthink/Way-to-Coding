#include<stdio.h>
#include<stdlib.h>
#include<stdbool.h>

int graph[50][50], mst[50][50], edge_count=0, size;
struct edge{
  int ver1, ver2, weight;
}edge[50];
void sort_edge();
void kruskals();
bool check_cycle();

int main(){
  printf("Enter the number of vertex:");
  scanf("%d", &size);
  printf("Enter the Adjacency Matrix(%dx%d) with weight:\n", size,size);
  for(int i=0; i<size; i++)
    for(int j=0; j<size; j++)
      scanf("%d", &graph[i][j]);
  printf("\n\n");

  // Fetching edges with weights from adjacency Matrix
  for(int i=0; i<size; i++)
    for(int j=i; j<size; j++)
        if(graph[i][j]>0){
          edge[edge_count].ver1 = i;
          edge[edge_count].ver2 = j;
          edge[edge_count++].weight = graph[i][j];
        }

  //Sorting vertices in ascending order
  sort_edge();

  //Generating Minimum Cost Spanning Tree using Kruskals Algorithm
  for(int i=0; i<size; i++)
    for(int j=0; j<size; j++)
      mst[i][j]=0;
  kruskals();
  printf("Minimum Cost Spanning Tree: \n");
  for(int i=0; i<size; i++){
    for(int j=0; j<size; j++)
      printf("%d ", mst[i][j]);
    printf("\n");
  }

  return 0;
}

void sort_edge(){
  struct edge temp;
  for(int i=0; i<edge_count; i++)
    for(int j=0; j<edge_count-i-1; j++)
      if(edge[j].weight > edge[j+1].weight){
        temp.ver1 = edge[j].ver1;
        edge[j].ver1 = edge[j+1].ver1;
        edge[j+1].ver1 = temp.ver1;

        temp.ver2 = edge[j].ver2;
        edge[j].ver2 = edge[j+1].ver2;
        edge[j+1].ver2 = temp.ver2;

        temp.weight = edge[j].weight;
        edge[j].weight = edge[j+1].weight;
        edge[j+1].weight = temp.weight;
      }
}

void kruskals(){
  int visited[50], visit_count=0, flag;
  for(int i=0; visit_count<size; i++){
    flag=0;
    for(int j=0; j<visit_count; j++){
      if(edge[i].ver1==visited[j])
        flag +=1;
      else if(edge[i].ver2==visited[j])
        flag +=1;
    }
    if(flag==0){
      visited[visit_count++] = edge[i].ver1;
      visited[visit_count++] = edge[i].ver2;
      mst[edge[i].ver1][edge[i].ver2] = edge[i].weight;
      mst[edge[i].ver2][edge[i].ver1] = edge[i].weight;
    }
    else if(flag==1){
      for(int k=0; k<visit_count; k++){
        if(edge[i].ver1==visited[k]){
          flag = 1;
          break;
        }
        else if(edge[i].ver2==visited[k]){
          flag = 2;
          break;
        }
      }
      if(flag==1){
        visited[visit_count++] = edge[i].ver2;
        mst[edge[i].ver1][edge[i].ver2] = edge[i].weight;
        mst[edge[i].ver2][edge[i].ver1] = edge[i].weight;
      }
      else if(flag==2){
        visited[visit_count++] = edge[i].ver1;
        mst[edge[i].ver1][edge[i].ver2] = edge[i].weight;
        mst[edge[i].ver2][edge[i].ver1] = edge[i].weight;
      }
    }
    else{
      if(!check_cycle(edge[i].ver1, edge[i].ver2)){
        mst[edge[i].ver1][edge[i].ver2] = edge[i].weight;
        mst[edge[i].ver2][edge[i].ver1] = edge[i].weight;
      }
      else
        continue;
    }
  }
}

bool check_cycle(int ver1, int ver2){
  int visited[50], visit_size=1, flag;
  visited[0]=ver1;
  for(int i=0; i<visit_size; i++){
    for(int j=0; j<size; j++){
      flag=0;
      if(mst[visited[i]][j]>0){
        for(int k=0; k<visit_size; k++){
          if(j==ver2)
            return true;
          else if(j==visited[k]){
            flag = 1;
            break;
          }
          flag=0;
        }
        if(!flag){
          visited[visit_size++] = j;
        }
      }
    }
  }
  return false;
}
