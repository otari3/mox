package ast.expersion;


import ast.NodeType;

public class BineryExpr implements Expr {
    Expr left;
    Expr right;
    String operator;
    NodeType kind = NodeType.BINARYEXPR;
}
