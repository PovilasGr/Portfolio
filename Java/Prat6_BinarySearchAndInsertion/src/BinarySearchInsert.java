import java.util.List;

public class BinarySearchInsert {


    public int insert(List list, Object value) {
        if(list == null) throw new NullPointerException("list negali buti null");
        int index = searchIterative(list, (Comparable)value); //searchRecursive(list, (Comparable)value);
        if (index < 0) {
            index = -(index + 1);
        }
        // leidziama iterpti pasikartojancias reiksmes:
        list.add(index, value); // jei ArrayList, veikia greitai, bet jei LinkedList letai. Zr. KnyguSortedList, kaip to isvengti
        return index;
    }

    // Randa, kurioje pozicijoje yra 'value', naudojama iteracijos
    public int searchIterative(List list, Comparable value) {
        if(list == null) throw new NullPointerException("list negali buti null");
        int left = 0;
        int right = list.size() - 1;
        int index;
        while (left <= right) {
            index = (left + right) / 2;
            int cmp = value.compareTo(list.get(index));

            if (cmp == 0) {
                return index;
            } else if (cmp < 0) {
                right = index - 1;
            } else {
                left = index + 1;
            }
        }
        // jei 'value' neradome, graziname pozicija, kur tikejomes rasti, tik su minuso zenklu.
        // Be to ta pozicija pastumiame per -1, kad nebutu neaiskumo 0-lines pozicijos atveju,
        // t.y. jei rado 'value' 0-lineje pozicijoje, graziname 0, jei nerado, bet tikejosi rasti 0-lineje pozicijoje, graziname -1.
        return - left - 1;
    }

    // Randa, kurioje pozicijoje yra 'value', naudojama rekursija
    public int searchRecursive(List list, Comparable value) {
        if(list == null) throw new NullPointerException("list negali buti null");
        return search(list, value, 0, list.size() - 1);
    }

    private int search(List list, Comparable value, int left, int right) {
        if (left > right) {
            return - left - 1;   // jei 'value' neradome, graziname pozicija, kur tikejomes rasti, tik su minuso zenklu. Be to ta pozicija pastumiame per -1, kad nebutu neaiskumo 0-lines pozicijos atveju.
        }
        int index = (left + right) / 2;
        int cmp = value.compareTo(list.get(index));
        if (cmp < 0) {
            index = search(list, value, left, index - 1);
        } else if (cmp > 0) {
            index = search(list, value, index + 1, right);
        }
        return index;
    }
}
