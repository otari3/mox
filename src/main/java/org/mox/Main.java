package org.mox;

import lexer.Lexer;

public class Main {
    public static void main(String[] args) {
        String srcCode = "let x = 1*(2/5)";
        Lexer lexer = new Lexer();
        System.out.println(lexer.tokenize(srcCode));
    }
}