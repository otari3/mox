package ast.expersion;

import ast.NodeType;

public class NumericLiteral implements Expr{
    NodeType kind = NodeType.NUMERICLITERAL;
    Integer value;
    public NumericLiteral(Integer value){
        this.value = value;
    }

    @Override
    public String toString() {
        return "NumericLiteral{" +
                "kind=" + kind +
                ", value=" + value +
                '}';
    }
}
