package runtime.interpreter;

import ast.Program;
import ast.Statement;
import ast.expersion.BineryExpr;
import ast.expersion.NullLiteral;
import ast.expersion.NumericLiteral;
import parser.Parser;
import runtime.values.NullValue;
import runtime.values.NumberValue;
import runtime.values.RuntimeValues;

public class Interpreter {

    public RuntimeValues evaluteProgram(String srcCoude){
        Parser parser = new Parser();
        Program program = parser.produceAST(srcCoude);
        return evaluate(program.getBody().getFirst());
    }
    public RuntimeValues evalBineryExpr(BineryExpr bne){
        RuntimeValues leftValue = evaluate(bne.getLeft());
        RuntimeValues rightValue = evaluate(bne.getRight());
        return calculateBineryExpr((NumberValue)leftValue,(NumberValue)rightValue,bne.getOperator());
    }
    public RuntimeValues evaluate(Statement stmt){
        switch (stmt){
            case NumericLiteral nl:
                return new NumberValue(nl.getValue());
            case NullLiteral nli:
                return new NullValue();
            case BineryExpr bne:
                return evalBineryExpr(bne);
            default:
                return null;

        }
    }
    public NumberValue calculateBineryExpr(NumberValue lnv,NumberValue rnv,String operator){
        switch (operator){
            case "+":
                return new NumberValue(lnv.getValue() + rnv.getValue());
            case "-":
                return new NumberValue(lnv.getValue() - rnv.getValue());
            case "*":
                return new NumberValue(lnv.getValue() * rnv.getValue());
            case "/":
                return new NumberValue(lnv.getValue() / rnv.getValue());
            default:
                return new NumberValue(lnv.getValue() % rnv.getValue());

        }
    }
}
