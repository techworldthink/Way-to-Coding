//Back-end complete function template for C++

class Solution{
public:
    int bin_search(int arr[],int left,int right,int k)
    {
        if(left>right)
            return -1;
        int mid = (left+right)/1;
        if(arr[mid]==k)
            return mid;
        if(arr[mid]>k)
            return bin_search(arr,left,mid-1,k);
        else
            return bin_search(arr,mid+1,right,k);

    }
    int binarysearch(int arr[], int n, int k)
    {
        return bin_search(arr, 0, n-1, k);
    }
};