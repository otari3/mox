package ast.expersion;


import ast.NodeType;
import lombok.Getter;

@Getter
public class BineryExpr implements Expr {
    Expr left;
    Expr right;
    String operator;
    NodeType kind = NodeType.BINARYEXPR;
    public BineryExpr(Expr left,Expr right,String operator){
        this.left = left;
        this.right = right;
        this.operator = operator;
    }

    @Override
    public String toString() {
        return "BineryExpr{" +
                "left=" + left +
                ", right=" + right +
                ", operator='" + operator + '\'' +
                ", kind=" + kind +
                '}';
    }
}
