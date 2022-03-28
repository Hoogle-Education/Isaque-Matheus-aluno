public class App {
    public static void main(String[] args){
        int[] array = {9, 7, 5, 3 , 6, 1, 2};

        mergeSort(array, array.length);

        for(int i : array) System.out.print(i + " ");
        
    }

    public static void mergeSort(int[] array, int size){

        if(size < 2) return;

        int mid = size/2;
        int[] l = new int[mid];
        int[] r = new int[size-mid];

        for(int i=0; i<size; i++){
            if( i < mid ) l[i] = array[i];
            else r[i-mid] = array[i]; 
        }

        mergeSort(l, mid);
        mergeSort(r, size-mid);

        merge(array, l, r, mid, size-mid);
    }

    public static void merge(int[] merged, int[] left, int[] right, int leftSize, int rightSize){

        int i=0, j=0, k=0;
        // i é a posição do array left
        // j é a posição do array right
        // k is for merge

        while( i < leftSize && j < rightSize ){
            if(left[i] > right[j]) {
                merged[k] = right[j];
                j++;
            } else {
                merged[k] = left[i];
                i++;
            } 
            k++;
        }

        while(i < leftSize){
            merged[k] = left[i];
            i++;
            k++;
        }

        while(j < rightSize){
            merged[k] = right[j];
            j++;
            k++;
        }
   }

}
