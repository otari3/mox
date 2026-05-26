package runtime.values;

public class NullValue implements RuntimeValues {
    Values type = Values.NULL;
    String value = "null";

    @Override
    public String toString() {
        return "NullValue{" +
                "type=" + type +
                ", value='" + value + '\'' +
                '}';
    }
}
