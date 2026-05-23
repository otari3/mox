package parser;

import ast.Program;
import ast.Statement;
import ast.expersion.*;
import lexer.Lexer;
import lexer.token.Token;
import lexer.token.tokenTypes.TokenType;

import java.util.Queue;

public class Parser {
    Lexer lexer = new Lexer();
    Queue<Token> tokens;
    public Program produceAST(String sourceCode){
        tokens = lexer.tokenize(sourceCode);
        Program program = new Program();
        while (!isEOF(tokens.peek())){
            program.getBody().add(parseStmt());
        }
        return program;
    }
    public Boolean isEOF(Token token){
        return token.getType() == TokenType.EOF;
    }
    public Statement parseStmt(){
        return parseExpr();
    }
    public Expr parseExpr(){
        return parseAdditiveExpr();
    }
    public Expr parsePrimeryExpr(){
        TokenType tk = tokens.peek().getType();
        switch (tk){
            case TokenType.IDENTIFIER:
                return new Identifier(tokens.poll().getValue());
            case TokenType.NUMBER:
                return new NumericLiteral(Integer.parseInt(tokens.poll().getValue()));
            case TokenType.NULL:
                return new NullLiteral(tokens.poll().getValue());
            case TokenType.OPENPARE:
                tokens.poll();
                Expr value = parseExpr();
                expect(TokenType.CLOSEPARE,"Excpeted closing parm Found: ");
                return value;
        }
        return null;
    }
    public Expr parseAdditiveExpr(){
        Expr left = parseMultiplicitaveExpr();
        while (tokens.peek().getValue().equals("+") || tokens.peek().getValue().equals("-")){
            String operator = tokens.poll().getValue();
            Expr right = parseMultiplicitaveExpr();
            left = new BineryExpr(left,right,operator);
        }
        return left;
    }
    public Expr parseMultiplicitaveExpr(){
        Expr left = parsePrimeryExpr();
        while (tokens.peek().getValue().equals("*") || tokens.peek().getValue().equals("/")){
            String operator = tokens.poll().getValue();
            Expr right = parsePrimeryExpr();
            left = new BineryExpr(left,right,operator);
        }
        return left;
    }
    public Token expect(TokenType type,String errorMsg){
        Token value = tokens.poll();
        if (value.getType()!=type){
            throw new RuntimeException(errorMsg+value.getValue());
        }
        return value;
    }
}
