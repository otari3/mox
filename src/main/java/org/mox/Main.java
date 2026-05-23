package org.mox;

import lexer.Lexer;
import parser.Parser;

public class Main {
    public static void main(String[] args) {
        String srcCode = "5+null";
        Parser lexer = new Parser();
        System.out.println(lexer.produceAST(srcCode));
    }
}