package util;

public class LinkedList<T extends Comparable<T>> implements List<T> {
    
    private Node<T> root;
    private int numOfItems;

    @Override
    public void insert(T data){
        if(root == null){
            root = new Node<>(data);
        }else{
            insertBeginning(data);
            //insertEnd(data,root);
        }
    }

    private void insertBeginning(T data) {
        Node<T> newNode = new Node<>(data);
        newNode.setNextNode(root);
        root=newNode;
        //numOfItems++;
    }

    private void insertEnd(T data, Node<T> node) {
        if(root.getNexNode() != null){
            insertEnd(data, node.getNexNode());
        }else{
            Node<T> newNode = new Node<T>(data);
            node.setNextNode(newNode);
            root = node;
        }
    }

    @Override
    public void remove(T data){
        if(root == null) return;

        if(root.getData().compareTo(data) == 0){
            root = root.getNexNode();
        }else{
            remove(data,root,root.getNexNode());
        }
    }

    private void remove(T data, Node<T> previousNode, Node<T> actualNode) {
        while(actualNode != null){
            if(actualNode.getData().compareTo(data) == 0){
                numOfItems--;
                previousNode.setNextNode(actualNode.getNexNode());
                actualNode = null;
                return;
            }
            previousNode = actualNode;
            actualNode = actualNode.getNexNode();
        }
    }

    @Override
    public void traverse(){
        if(root == null ) return;

        Node<T> actualNode = root;
        while(actualNode != null){
            System.out.println(actualNode);
            actualNode = actualNode.getNexNode();
        }
    }

    @Override
    public int size(){
        return numOfItems;
    }
}
