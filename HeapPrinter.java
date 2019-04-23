public class HeapPrinter{
  public static String toString(int[] array) {

		if (array.length == 0) return "";
		int largest = array[0];
		for (int j = 1; j < array.length; j++)
			if (Math.abs(largest) < Math.abs(array[j])) largest = array[j];

		int size = 1;
		while (size <= array.length) size <<= 1;
		int buffer = (size>>1)*(int)(Math.log(Math.abs(largest))/Math.log(10)+(largest > 0 ? 1 : 2));

		StringBuilder sb = new StringBuilder();

		int i = 0;
		for (int row = 2; row <= size; row <<= 1) {

			for (; i < row-1 && i < array.length; i++) {
				int numlength = array[i] == 0 ? 1 : (int)(Math.log(Math.abs(array[i]))/Math.log(10))+(array[i] > 0 ? 1 : 2);
				for (int j = numlength; j < buffer; j++) {
					sb.append(" ");
				}
				sb.append(array[i]);
				for (int j = 0; j < buffer; j++) sb.append(" ");
			}
			if (row != size) sb.append("\n");
			buffer = buffer>>1;
		}

		return new String(sb);
	}

	public static void print(int[] array) {
		System.out.println(toString(array));
	}
  public static void main(String [] args){
    int [] a = new int[]{4,3,7,1,2,7,8,9,4,6,3,5,2,6};
    MyHeap.heapify(a);
    //print(a);
    a = new int[]{4,3,7,1,2,7,8,9,4,6,3,5,2,6};
    MyHeap.heapsort(a);
    for(int x: a){
      System.out.print(x + " ");
    }
    int [] b = new int []{80,39,60,17,21,32,50,8,9,16,15,16,70,27,26};
    MyHeap.pushUp(b,12);
    System.out.println();
    System.out.println();
    //print(b);
  }
}
