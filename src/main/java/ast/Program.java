package ast;


import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
@Getter
public class Program implements Statement {
    NodeType kind = NodeType.PROGRAM;
    ArrayList<Statement> body = new ArrayList<>();

    @Override
    public String toString() {
        return "Program{" +
                "kind=" + kind +
                ", body=" + body +
                '}';
    }
}
