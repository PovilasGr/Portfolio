public class InsertionRusiavimas {
    public void sortInt(int[] arr)
    {
        int val;
        int j;
        for(int i = 1; i < arr.length; i++)
        {
            val = arr[i];
            j = i;
            while (j > 0 && val < arr[j-1])
            {
                arr[j] = arr[j-1];
                j--;
            }
            arr[j] = val;
        }
    }

    public void sortString(String[] arr)
    {
        String val;
        int j;
        for(int i = 1; i < arr.length; i++)
        {
            val = arr[i];
            j = i;
            while (j > 0 && val.compareTo(arr[j-1])< 0)
            {
                arr[j] = arr[j-1];
                j--;
            }
            arr[j] = val;
        }
    }

    public void sort(Object[] arr, Cmp cmp)
    {
        Object val;
        int j;
        for (int i = 1; i < arr.length; i++) {
            val = arr[i];
            j = i;
            while (j > 0 && cmp.compare(val, arr[j - 1]) < 0) {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = val;
        }
    }


}
