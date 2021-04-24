package com.soulmate.datastructure;

public class Heap {

    int[] heap;

    int heapSize;

    public Heap(){
        heap=new int[101];
    }

    public Heap(int size){
        heap=new int[size];
    }

    public int peek(){
        return heapSize!=0?heap[0]:-1;
    }

    public boolean insert(int val){
        if(heap.length==heapSize)
            return false;

        heap[heapSize]=val;
        int ptr=heapSize++,temp;
        while (heap[ptr]>heap[temp=(ptr-1)/2]){
            swap(ptr,temp);
            ptr=temp;
        }
        return true;
    }

    public int delete(){
        if(heapSize==0)
            return -1;
        int p=0,l=1,r=l+1<heapSize?l+1:l;
        swap(p,--heapSize);
        while (l<heapSize-1){
            if(heap[l]>heap[r]){
                if(heap[l]<heap[p])
                    break;
                swap(l,p);
                p=l;
            }else {
                if(heap[r]<heap[p])
                    break;
                swap(r,p);
                p=r;
            }
            l=2*p+1;
            r=l+1<heapSize?l+1:l;
        }

        return heap[heapSize];
    }

    public void swap(int a,int b){
        int temp=heap[a];
        heap[a]=heap[b];
        heap[b]=temp;
    }

}
