package ast.expersion;

import ast.NodeType;

public class NullLiteral implements Expr {
    NodeType kind = NodeType.NULLLITERAL;
    String value;
    public NullLiteral(String value){
        this.value = value;
    }

    @Override
    public String toString() {
        return "NullLiteral{" +
                "kind=" + kind +
                ", value='" + value + '\'' +
                '}';
    }
}
