import java.sql.SQLOutput;
import java.util.Arrays;

public class MainClass {

    public static void main(String[] args) {
        int[] sk = new int [5];
        sk[0] = 6;
        sk[1] = 4;
        sk[2] = 8;
        sk[3] = 1;
        sk[4] = 3;

        String[] txt = {"e", "a", "d", "c", "b"};

        InsertionRusiavimas srt = new InsertionRusiavimas();
        
        srt.sortInt(sk);
        for(int val : sk) {
            System.out.println(val + " ");
        }

        srt.sortString(txt);

        for(String val : txt) {
            System.out.println(val + " ");
        }
    

    Integer[] sk1 = {6,4,8,1,3};
    String[] txt1 = {"e", "a", "d", "c", "b"};
    srt.sort(sk1, new CmpInteger());
    srt.sort(txt1, new CmpString());
    
    for(Integer val : sk1);
        {
            System.out.print(val + " ");
        }

        for(String val : txt1); {
            System.out.print(val + " ");
        }
        

        }
}
