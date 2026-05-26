package org.mox;

import lexer.Lexer;
import parser.Parser;
import runtime.interpreter.Interpreter;

public class Main {
    public static void main(String[] args) {
        String srcCode = "5/5";
        Interpreter interpreter = new Interpreter();
        System.out.println(interpreter.evaluteProgram(srcCode));
    }
}