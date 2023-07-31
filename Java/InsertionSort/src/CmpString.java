public class CmpString implements Cmp{
    /**
     * @param x
     * @param y
     * @return -1 if x < y, 0 if x == y, 1 if x > y
     */
    @Override
    public int compare(Object x, Object y) {
        String s1 = (String) x;
        String s2 = (String) y;
        return s1.compareTo(s2);
    }
}
