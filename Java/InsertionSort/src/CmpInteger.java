public class CmpInteger implements Cmp {
    /**
     * @param x
     * @param y
     * @return -1 if x < y, 0 if x == y, 1 if x > y
     */
    @Override
    public int compare (Object x, Object y){
        int i1 = (int) x;
        int i2 = (int) y;

        if (i1 < i2) {
            return -1;
        } else if (i1 == i2) {
            return 0;
        } else {
            return 1;
        }
    }
}
