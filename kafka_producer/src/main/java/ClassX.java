import java.io.Serializable;

public class ClassX implements Serializable {
    private Integer key;
    private Integer value;

    public ClassX() {
    }

    public ClassX(Integer key, Integer value) {
        this.key = key;
        this.value = value;
    }

    public Integer getKey() {
        return key;
    }

    public void setKey(Integer key) {
        this.key = key;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    @Override public String toString() {
        return "ClassX (" + key.toString() + ", " + value.toString() + ")";
    }
}
