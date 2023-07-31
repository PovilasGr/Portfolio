import java.util.Objects;

public class Entry implements Comparable<Entry> {
    private final Comparable<Object> key;  // 'key' yra final!!! nebeleidziama keisti reiksmes, be to nera setKey() metodo
    private Object value;
    private boolean deleted;
    
    public Entry(Comparable<Object> key, Object value) {
        if(key == null) throw new NullPointerException("Key can't be null");
        this.key = key;
        setValue(value);
    }

    @Override
    public String toString() {
        return key + ":" + value;
    }

    @Override
    public int compareTo(Entry o) {
        return key.compareTo(o.getKey());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Entry entry = (Entry) o;
        return key.equals(entry.key);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key);
    }

    public Comparable<Object> getKey() {
        return key;
    }

    public Object getValue() {
        return value;
    }

    public Object setValue(Object value) {
        Object oldVal = this.value;
        this.value = value;
        return oldVal;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
}
