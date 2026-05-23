package ast;


import java.util.List;

public class Program implements Statement {
    NodeType kind = NodeType.PROGRAM;
    List<Statement> body;
}
