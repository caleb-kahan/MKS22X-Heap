public class MyHeap{
  private static void pushDown(int[]data,int size,int index){
    int childAIndex = index * 2 + 1;
    int childBIndex = index * 2 + 2;
    int childAValue = data[childAIndex];
    int childBValue = data[childBIndex];

    while(childAIndex < size && childBIndex < size && (childAValue > data[index] || childBValue > data[index])){
      if(childAValue>childBValue){
        swap(data, childAIndex, index);
        index = childAIndex;
      }
      else{
        swap(data, childBIndex, index);
        index = childBIndex;
      }
      childAIndex = index * 2 + 1;
      childBIndex = index * 2 + 2;
      childAValue = data[childAIndex];
      childBValue = data[childBIndex];
    }
  }
  private static void pushUp(int[]data,int index){
    int parentIndex = (index+1) / 2 - 1;
    int parentValue = data[parentIndex];

    while(parentIndex >=0 && parentValue < data[index]){
      swap(data, parentIndex, index);
      index = parentIndex;
      parentIndex = (index+1) / 2 - 1;
      parentValue = data[parentIndex];
    }
  }
  public static void heapify(int[] data){
    for(int i = findStartingIndex(data.length);i>=0;i--) pushDown(data, data.length; i);
  }
  public static void heapsort(int[] data){
    heapify(data);
    for(int size = data.length;size>0;size--){
      swap(data, 0, size - 1);
      pushDown(data,size-1,0);
    }
  }
  public static int findStartingIndex(int size){
    int power = (int)(Math.log(size)/Math.log(2));
    power-=1;
    return (int)(Math.pow(2,power))-2;
  }
  public static void swap(int[] data, int index1, int index2){
    int temp = data[index1];
    data[index1] = data[index2];
    data[index2]= temp;
  }
}
