#include<stdio.h>
#include<stdlib.h>

struct node{
	struct node *left;
	struct node *right;
	int data;
};
struct node *root;

struct node* newNode(value){
	struct node *newnode = malloc(sizeof(struct node));
	newnode->data = value;
	newnode->left=NULL;
	newnode->right=NULL;
	return newnode;
}

struct node* insert(struct node* root,int value) {
  if(root == NULL){
  	return newNode(value);
  }
  else if(value == root->data){
  	printf("Same data can't be stored");
  }
  else if(value>root->data){
  	root->right = insert(root->right,value);
  }
  else if(value<root->data){
  	root->left = insert(root->left,value);
  }
}

// Inorder traversal
void inorderTraversal(struct node* root) {
  if (root == NULL) return;
  inorderTraversal(root->left);
  printf("%d ->", root->data);
  inorderTraversal(root->right);
}

// Preorder traversal
void preorderTraversal(struct node* root) {
  if (root == NULL) return;
  printf("%d ->", root->data);
  preorderTraversal(root->left);
  preorderTraversal(root->right);
}

// Postorder traversal
void postorderTraversal(struct node* root) {
  if (root == NULL) return;
  postorderTraversal(root->left);
  postorderTraversal(root->right);
  printf("%d ->", root->data);
}

struct node* search(struct node* root, int key) { 
  if (root == NULL) 
    printf("\nNot FOUND!\n"); 
  else if (root->data == key)
    printf("\nFOUND!\n");
  else{
  	if (root->data < key) 
    return search(root->right, key); 
  return search(root->left, key);
  } 
}

int main(){
	int opt;
	int value,searchv;
	do{
		printf("\n1)Create Root Node \n2)Insert Node\n3)Search\n");
		printf("4)inorderTraversal \n5)preorderTraversal \n6)postorderTraversal \n8)Quiet \n");
		printf("Choose Option :: ");
		scanf("%d",&opt);
		switch(opt){
			case 1:
				printf("\nEnter a number : ");
				scanf("%d",&value);
				root = newNode(value);
				break;
			case 2:
				printf("\nEnter a number : ");
				scanf("%d",&value);
				insert(root,value);
				break;
			case 3:
				printf("\nEnter a number : ");
				scanf("%d",&searchv);
				search(root,searchv);
				break;
			case 4:
				printf("\n..................................\n");
				inorderTraversal(root);
				printf("\n..................................\n");
				break;
			case 5:
				printf("\n..................................\n");
				preorderTraversal(root);
				printf("\n..................................\n");
				break;
			case 6:
				printf("\n..................................\n");
				postorderTraversal(root);
				printf("\n..................................\n");
				break;
			defualt:
				printf("Invalid option!");
		}
	}while(opt!=8);
	return 0;
}
