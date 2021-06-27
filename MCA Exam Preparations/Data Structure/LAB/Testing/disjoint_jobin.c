#include<stdio.h>
#include<stdlib.h>
#include<stdbool.h>

struct node{
    int data;
    struct node *rep;
    struct node *next;
}*head[50],*tail[50];

static int count_element=0;

void makeset(int data){
    struct node *new = (struct node *)malloc(sizeof(struct node));
    new->data=data;
    new->rep=new;
    new->next=NULL;
    head[count_element] = new;
    tail[count_element] = new;
    count_element++;
}

void display_all(){
   struct node *temp = (struct node *)malloc(sizeof(struct node));
   int i;
   printf("\n|||||||||||||||||||||||||||||||||\n");
   for(i=0;i<count_element;i++){
       temp = head[i];
       while(temp!= NULL){
		printf("%d ->  ",temp->data);
 		temp=temp->next;
            	
       }
       printf("\n");
   }
   printf("|||||||||||||||||||||||||||||||||\n");
}

bool ispresent(int data){
   struct node *temp = (struct node *)malloc(sizeof(struct node));
   int i;
   for(i=0;i<count_element;i++){
       temp = head[i];
       while(temp!= NULL){
	    if(temp->data == data){
	        return true;	
	    }
       temp=temp->next;
            	
       }
   }
  return false;
}

int search(int data){
  struct node *temp = (struct node *)malloc(sizeof(struct node));
   int i;
   for(i=0;i<count_element;i++){
       temp = head[i];
       while(temp!= NULL){
	    if(temp->data == data){
	        return i;	
	    }
       temp=temp->next;
            	
       }
   }
  return -1;
}

struct node *representative(int data){
    int i;
    if((i = search(data)) != -1){
        return head[i]->rep;
    }
    else{
        return NULL;   
    }
}


void union_of_set(int a,int b){
    struct node *tail_2_backup = (struct node *)malloc(sizeof(struct node));
    struct node *rep1 = representative(a);
    struct node *rep2 = representative(b);
    int i,pos,j;

    if(rep1 == NULL || rep2 ==NULL){
	printf("\nBoth these numbers not present in sets\n");
    }
    else if(rep1 == rep2){
        printf("\nBoth these numbers are same try different\n");
    }
    else{
        for(i=0;i<count_element;i++){
        	if(head[i] == rep2){
		pos = i;
		tail_2_backup = tail[pos];
		for(j=pos;j<count_element;j++){
			head[i]=head[i+1];
		}
		break;
		}
        }
	count_element--;
	for(i=0;i<count_element;i++){
        	if(head[i] == rep1){
			tail[i]->next = rep2;
			tail[i]=tail_2_backup;
		}
	}
	while(rep2!=NULL){
	    rep2->rep = rep1;
	    rep2=rep2->next;
	}

    }
}

int main(){
    int opt;
    int data,data_1,data_2;
    struct node *rep;

    do{
	printf("\n1)Makeset \n2)Display All set\n3)Representative of set \n4)Union\nchoose option :: ");
        scanf("%d",&opt);
	switch(opt){
	    case 1:
                printf("\nEnter an element to insert : ");
                scanf("%d",&data);
                if(ispresent(data)){
		    printf("\nAlready present !\n");
		}
		else{
		    makeset(data);
		}
		break;
	    case 2:
       		display_all();
		break;
	    case 3:
		printf("\nEnter an element to be search : ");
                scanf("%d",&data);
       		rep = representative(data);
		if(rep == NULL){
		    printf("\nNot present in any of the set\n");
                }
		else{
		    printf("|||||||||||||||||||||||||||||||||\n");
		    printf("\nRepresentative of %d is  : %d\n",data,rep->data);
        	    printf("\n|||||||||||||||||||||||||||||||||\n");
     		}
		break;
            case 4:
		printf("\nEnter an element in first set : ");
                scanf("%d",&data_1);
                printf("\nEnter an element in second set : ");
                scanf("%d",&data_2);
       		union_of_set(data_1,data_2);
		break;

	    defualt:
		printf("Invalid option!");
	}
    }while(1);
    return 0;
}
