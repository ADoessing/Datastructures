public class CircularQueue {

    private int count = 0;
    private Integer[] cirQue = new Integer[7];

    public boolean enqueue(int i){
        if (count == cirQue.length) {
            if (cirQue[0].equals(null)){
                cirQue[0] = i;
                count = 0;
                count++;
                return true;
            }
        } else {
            if (!cirQue[count].equals(null)){
                cirQue[count] = i;
                count++;
                return true;
            }
        }
        return false;
    }


    public int dequeue(){
        int val = cirQue[count];
        cirQue[count] = null;
        count--;
        return val;
    }

}
