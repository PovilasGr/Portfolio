public class KnyguSortedList  implements MyList {

        private final MyNode headAndTail = new MyNode(null); // final, i.e. unmodifiable

        private int size;   //size of list, initializes to 0

        public KnyguSortedList() {
            // Pradzioje sukuriamas tik headAndTail elementas, kurio next/previous rodykles rodo i save
            headAndTail.setPrevious(headAndTail);
            headAndTail.setNext(headAndTail);
            size = 0;                // empty the list
        }

        /**
         * Obtains element for a specified position "index"
         * starting at the first element and forwards
         * or starting at the last element and backwards.
         */
        private MyNode getElement(int index) {
            if(index < 0 || index > size()){ // demesio: leidziamas atvejis index == size(), kad butu galima iterpti pries 'tail' elementa
                throw new IndexOutOfBoundsException();
            }
            MyNode element = headAndTail;
            if(size > 0) {
                if(index < size/2) {
                    for (int i = 0; i < index+1; i++) {
                        element = element.getNext();
                    }
                } else {
                    for (int i = size - index; i > 0; i--) {
                        element = element.getPrevious();
                    }
                }
            }
            return element;
        }

        /**
         * Inserts value at position index
         * @param index
         * @param value
         */
        @Override
        public void add(int index, Object value) {
            if(index < 0 || index > size()){
                throw new IndexOutOfBoundsException();
            }
            MyNode element = new MyNode(value);
            element.attachBefore(getElement(index));
            size++;
        }

        /**
         * Adds new element at the end of list
         * @param value
         */
        @Override
        public void add(Object value) {
            //add(size(), value);

            MyNode node = searchIterative((Comparable)value);

            int index = node.getBinSearchIndex();
            if (index < 0) {
                MyNode newNode = new MyNode(value);// TODO sukuriame nauja mazga MyNode newNode su reiksme value;
                newNode.attachBefore(node);// TODO newNode mazgui kvieciame metoda attachBefore, ir newNode idedame pries mazga node;
                size++;
            }
            else System.out.println("Klaida: negalima ideti pasikratojancios knygos");

        }

        private MyNode searchIterative(Comparable value) {
            int left = 0;
            int right = size() - 1;
            int index;
            MyNode node = headAndTail;

            while (left <= right) {
                index = (left + right) / 2;
                node = getElement(index);
                int cmp = value.compareTo(node.getValue());//TODO value palyginame su mazge node saugoma value;

                if (cmp == 0) {
                    node.setBinSearchIndex(index); //TODO kvieciame node metoda setBinSearchIndex ir irasome index pozicija;
                    return node; //TODO graziname node;
                } else if (cmp < 0) {
                    right = index - 1;
                } else {
                    left = index + 1;
                }
            }

            // jei 'value' neradome, graziname pozicija, kur tikejomes rasti, tik su minuso zenklu.
            // Be to ta pozicija pastumiame per -1, kad nebutu neaiskumo 0-lines pozicijos atveju,
            // t.y. jei rado 'value' 0-lineje pozicijoje, graziname 0, jei nerado, bet tikejosi rasti 0-lineje pozicijoje, graziname -1.

            node.setBinSearchIndex(- left -1);//TODO kvieciame node metoda setBinSearchIndex ir irasome (- left - 1) pozicija;
            return node;//TODO graziname node;
        }

        /**
         * Deletes element at position index
         * @param index
         */
        @Override
        public Object remove(int index) {
            if(index < 0 || index > size() - 1){
                throw new IndexOutOfBoundsException();
            }
            MyNode element = getElement(index);
            element.detach();
            size--;
            return element.getValue();
        }

        /**
         * Deletes the first found element with given value
         */
        @Override
        public boolean remove(Object value) {
            for (MyNode e = headAndTail.getNext(); e!=headAndTail; e=e.getNext()){
                if (value.equals(e.getValue())) {                                   // ziureti Preke javabean klase equals() metoda
                    e.detach();
                    size--;
                    return true;         // jei triname tik pirma surasta elementa
                }
            }
            return false;
        }

        // Delete all elements from the list, except headAndTail
        @Override
        public void clear() {
            headAndTail.setPrevious(headAndTail);
            headAndTail.setNext(headAndTail);
            size = 0;
        }

        // Set value at position index
        @Override
        public Object set(int index, Object value) {
            if(index < 0 || index > size()-1){
                throw new IndexOutOfBoundsException();
            }
            MyNode element = getElement(index);
            Object oldValue = element.getValue();
            element.setValue(value);
            return oldValue;
        }

        // Get value at position index
        @Override
        public Object get(int index) {
            if(index < 0 || index > size()-1){
                throw new IndexOutOfBoundsException();
            }
            return getElement(index).getValue();
        }

        // Position of value in the list (first occurence)
        @Override
        public int indexOf(Object value) {
            int index = 0;

            for (MyNode e = headAndTail.getNext(); e != headAndTail; e = e.getNext()) {
                if (value.equals(e.getValue())) {
                    return index;
                }
                index++;
            }
            return -1;
        }

        @Override
        public boolean contains(Object value) {
            return indexOf(value) != -1;
        }

        @Override
        public int size() {
            return size;
        }

        @Override
        public boolean isEmpty() {
            return size() == 0;
        }

}
