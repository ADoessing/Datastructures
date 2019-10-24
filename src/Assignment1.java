public class Assignment1 {

    public static int counter;

    private class PriorityQueue{
        int[] array;
        int size;
        int arraySize;

        public PriorityQueue() {
            this.array = new int[15];
            this.arraySize = 15;
            this.size = 0;
            counter += 3;
        }

        private void percolateUp(int number){
            int index = size;
            counter++;
            while (hasParrent(index) && getParrentValue(index) > number) {
                array[index] = getParrentValue(index);
                index = getParrent(index);
                counter += 2;
            }
            array[index] = number;
            counter ++;
        }


        private void percoclateDown(int position){
            int tempVal = array[1];
            counter++;

            while (getLeftChild(position)<=arraySize) {

                int leftChildindex = getLeftChild(position);
                int rightChildIndex = getRightChild(position);

                counter += 2;

                if (tempVal > getRightChildValue(position) || tempVal > getLeftChildValue(position)){
                   int chosenChild = (getRightChildValue(position)>getLeftChildValue(position))?rightChildIndex:leftChildindex;

                   array[position] = array[chosenChild];
                   position = chosenChild;
                   counter += 3;
                } else {
                    counter++;
                    break;
                }
            }
            array[position] = tempVal;
            counter ++;
        }

        private void insert(int number) {
            if (arraySize == size+1){
                expand(arraySize*2+1);
                counter++;
            }

            size++;
            percolateUp(number);
            counter += 2;
        }

        private void expand(int newSize){
            int[] tmp = new int[newSize];
            counter++;

            for (int i = 0; i < this.array.length; i++) {
                tmp[i] = array[i];
                counter++;
            }
            this.arraySize = newSize;
            this.array = tmp;
            counter += 2;
        }


        public int getRightChild(int position){
            counter++;
            return position*2+1;
        }

        public int getRightChildValue(int position){
            counter++;
            return array[getRightChild(position)];
        }


        public int getLeftChild(int position){
            counter++;
            return position*2;
        }

        public int getLeftChildValue(int position){
            counter++;
            return array[getLeftChild(position)];
        }

        public int getParrent(int position){
            counter++;
            return position/2;
        }

        public int getParrentValue(int position){
            counter++;
            return array[getParrent(position)];
        }

        public boolean hasParrent(int index) {
            counter++;
            return getParrent(index) > 0;
        }

        private int deleteMin(){
            int min = array[1];
            size--;
            array[1] = array[size];
            percoclateDown(1);
            counter += 5;
            return min;
        }

    }

    private static final int CUTOFF = 20;

    private void quickSelect (int[] a, int left, int right, int k) {
        if (left + CUTOFF <= right){
            int pivot = median3(a, left, right);
            int i = left, j = right -1;
            counter+= 2;

            for(;;){
                while(a[++i] < pivot){
                counter++;
                }
                while (a[--j] > pivot) {
                counter++;
                }
                if (i <j){
                    counter++;
                    swap(a, i ,j);
                } else {
                    break;
                }
            }
            counter++;
            swap(a, i, right -1);
            if (k<= i){
                counter++;
                quickSelect(a, left, i-1, k);
            } else if (k > i + 1) {
                counter++;
                quickSelect(a, i+1, right, k);
            }
        }
        else {
            counter++;
            insertionSort(a, left, right);
        }
    }

    public void swap(int[] array, int start, int end){
        int temp = array[end];
        array[end] = array[start];
        array[start] = temp;
        counter+= 3;
    }

    private void insertionSort(int[] a, int left, int right) {
        for (int i = left+1; i < right; ++i) {
            int key = a[i];
            int j = i - 1;
            counter+=2;
            while (j >= left && a[j] > key) {
                a[j + 1] = a[j];
                j = j - 1;
                counter+=2;
            }
            a[j + 1] = key;
            counter++;
        }
    }

    private int median3(int[] a, int left, int right){
        int center = (left + right) / 2;
        if (a[center] < a[left]){
            swap(a, left, center);
        }
        if (a[right] < a[left]) {
            swap(a, left, right);
        }
        if (a[right] > a[center]){
            swap(a, right, center);
        }
        swap(a, center, right -1);

        return a[right-1];

    }


    public int[] makeRandomArray(int Size) {
        int[] Array = new int[Size];
        for (int i = 0; i <Array.length ; i++) {
            Array[i] = (int)(Math.random() * Size);
        }
        return Array;
    }



    private int problem1 (int[] intArray, int k){
        PriorityQueue priorityQueue = new PriorityQueue();
        int[] smallestElement = new int[k];

        counter+= 2;

        for (int i = 0; i < intArray.length; i++) {
            priorityQueue.insert(intArray[i]);
            counter++;
        }

        for (int i = 0; i < smallestElement.length; i++) {
            smallestElement[i] = priorityQueue.deleteMin();
            counter++;
        }

        counter++;
        System.out.print("\t Count: " + counter);
        //counter=0;
        return smallestElement[k-1];
    }

    private void problem1Testing(){
        int size = 1000;
        int[] array;

        for (int i = 1; i < 2000; i++) {
            array = new int[size*i];
                for (int j = 0; j < array.length; j++) {
                    array[j] = (int)(Math.random() * 10 * size);
                }

                System.out.print("\t ArraySize: " + array.length );
                System.out.print("\t K'th smallest element: " + this.problem1(array, size/100));

                double logn = Math.log(array.length)/Math.log(2); // Laver naturlig logaritme om til 2 tals Logaritme
                double ratio = counter / (array.length*logn); // Ratio mellem counter og N*log(N)
                System.out.print("\t Ratio: " + ratio +"\n");
                counter=0;
        }
    }

    private void problem2Testing(){
        for (int i = 0; i < 2000; i++) {
            int size = i * 1000;
            for (int j = 0; j < 100; j++) {
                int[] array = this.makeRandomArray(i*1000);
                quickSelect(array, 0, array.length -1, i*10);
            }
            double ratio = 1.0 * counter / (size * 100);
            System.out.println("Ratio: " + ratio + " Array length: " + size);
            counter = 0;
        }
    }


    public static void main(String[] args) {

        Assignment1 problems = new Assignment1();
        System.out.println("****************************** Problem 1 ******************************");
        problems.problem1Testing();
        System.out.println("****************************** Problem 2 ******************************");
        problems.problem2Testing();
    }


}
