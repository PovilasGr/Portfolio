public class MainClass {
    public static void main(String[] args) {

        /*
        System.out.println("Labas");
        System.out.println("Vakaras");


        int[] arr = new int[3];

        arr[0] = 0;
        arr[1] = 1;
        arr[2] = 2;

        for(int i = 0; i < arr.length; i++){
            System.out.println(arr[i]);
        }

        for (int j : arr) {
            System.out.println(j);
        }
*/
        KvadratineLygtis k1 = new KvadratineLygtis(1, 3, 2);
        KvadratineLygtis k2 = new KvadratineLygtis(1, 3, 3);

        float[] ats;

        ats = k1.saknys();
        if(ats != null)
            System.out.printf(ats[0] + " " + ats[1]);
        else System.out.println("Diskriminantas neigiamas.");

        ats = k2.saknys();
        if(ats != null)
            System.out.printf(ats[0] + " " + ats[1]);
        else System.out.println("Diskriminantas neigiamas.");

    }
}
