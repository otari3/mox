package ast.expersion;

import ast.NodeType;

public class Identifier implements Expr {
    NodeType kind = NodeType.IDENTIFIER;
    String symbol;
}
