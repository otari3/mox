package ast.expersion;

import ast.NodeType;

public class NumericLiteral implements Expr{
    NodeType kind = NodeType.NUMERICLITERAL;
    Integer value;
}
