package lexer;

import lexer.token.Token;
import lexer.token.keywords.KeyWords;
import lexer.token.tokenTypes.TokenType;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Lexer {

    public List<Token> tokenize(String sourceCode){
        ArrayList<Token> tokens = new ArrayList<>();
        Queue<Character> src = getQueueOfChars(sourceCode.toCharArray());
        while (!src.isEmpty()){
            switch (src.peek()){
                case '(':
                    tokens.add(new Token(src.poll().toString(),TokenType.OPENPARE));
                    break;
                case ')':
                    tokens.add(new Token(src.poll().toString(),TokenType.CLOSEPARE));
                    break;
                case '+', '-', '*', '/':
                    tokens.add(new Token(src.poll().toString(),TokenType.BINERYOPERATOR));
                    break;
                case '=':
                    tokens.add(new Token(src.poll().toString(),TokenType.EQUALS));
                default:
                    if (isInteger(src.peek())){
                        StringBuilder num = new StringBuilder();
                        while (!src.isEmpty() && isInteger(src.peek())){
                            num.append(src.poll());
                        }
                        tokens.add(new Token(num.toString(),TokenType.NUMBER));
                    }else if (isAlpa(src.peek())){
                        StringBuilder identifier = new StringBuilder();
                        while (!src.isEmpty() && isAlpa(src.peek())){
                            identifier.append(src.poll());
                        }
                        String identiferAsString = identifier.toString();
                        if (KeyWords.KEYWORDS.containsKey(identiferAsString)){
                            tokens.add(new Token(identiferAsString,KeyWords.KEYWORDS.get(identiferAsString)));
                        }else {
                            tokens.add(new Token(identiferAsString,TokenType.IDENTIFIER));
                        }
                    }else if (isSkipAble(src.peek())){
                        src.poll();
                    }else {
                        System.out.println("Unreconizde Char Found: "+src.peek());
                        throw new RuntimeException("Unreconizde Char Found: "+src.peek());
                    }

            }
        }
        return tokens;
    }

    public Queue<Character> getQueueOfChars(char[] srcAsChar){
        Queue<Character> src = new LinkedList<>();
        for(char c:srcAsChar){
            src.offer(c);
        }
        return src;
    }
    public Boolean isAlpa(Character src){
        return Character.isAlphabetic(src);
    }
    public Boolean isInteger(Character src){
        return Character.isDigit(src);
    }
    public Boolean isSkipAble(Character src){
        return src==' ' || src=='\n' || src=='\t';
    }
}
