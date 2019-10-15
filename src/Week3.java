import java.util.Random;

public class Week3 {

    private int power;
    int[] table;
    private int entries;


    Week3(int power) {
        this.table = new int[97];
        this.power = power;
        this.entries = 0;
    }


    public int put(int val) {
        int hops = 0;

                do {
                    int index = ((int)Math.pow(hops, this.power)+val) % table.length;

                    if(table[index] == 0) {
                        table[index] = val;
                        entries++;
                    }
                } while(hops++ < 100);
        return hops;
    }

    public double getLoad(){
        return (1.0*this.entries)/this.table.length;
    }

    public static void main(String[] args) {
        Random random = new Random();

        int sum = 0;
        Week3 quad = new Week3(2);
        for (int i = 0; i < 97; i++) {
            sum += quad.put(random.nextInt());
        }

        int sum2 =0;
        Week3 penta = new Week3(5);
        for (int i = 0; i < 97; i++) {
            sum2 += penta.put(random.nextInt());
        }

        System.out.println("Penta : " +penta.getLoad() + "Total hops : ");
    }


}
