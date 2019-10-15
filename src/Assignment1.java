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
        System.out.println(counter);
        counter=0;
        return smallestElement[k-1];
    }


    private void problem1Testing(){
        int size = 1000;
        int[] array;

        for (int i = 1; i < 1000; i++) {
            array = new int[size*i];
            for (int j = 0; j < array.length; j++) {
                array[j] = (int)(Math.random() * 10 * size);
            }
            this.problem1(array, size/100);
        }

    }


    private void problem2Testing(){

    }


    public static void main(String[] args) {

        Assignment1 problems = new Assignment1();
        problems.problem1Testing();
    }


}
