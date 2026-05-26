package runtime.values;

import lombok.Getter;

@Getter
public class NumberValue implements RuntimeValues{
    Values type = Values.NUMBER;
    Integer value;
    public NumberValue(Integer value){
        this.value = value;
    }

    @Override
    public String toString() {
        return "NumberValue{" +
                "type=" + type +
                ", value=" + value +
                '}';
    }
}
