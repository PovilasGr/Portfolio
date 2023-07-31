public interface Cmp
{
    /**
     * @param x
     * @param y
     * @return -1 if x < y, 0 if x == y, 1 if x > y
     */
    public int compare(Object x, Object y);
}
