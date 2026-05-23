package ast.expersion;

import ast.NodeType;

public class Identifier implements Expr {
    NodeType kind = NodeType.IDENTIFIER;
    String symbol;
    public Identifier(String symbol){
        this.symbol = symbol;
    }

    @Override
    public String toString() {
        return "Identifier{" +
                "kind=" + kind +
                ", symbol='" + symbol + '\'' +
                '}';
    }
}
