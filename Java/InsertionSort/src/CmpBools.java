public class CmpBools implements Cmp{
    /**
     * @param x
     * @param y
     * @return -1 if x < y, 0 if x == y, 1 if x > y
     */
    @Override
    public int compare(Object x, Object y) {
        boolean xx = (boolean) x;
        boolean yy = (boolean) y;

        if(xx == yy) {
            return 0;
        } else if (xx) {
            return 1;
        } else return -1;
    }
}
