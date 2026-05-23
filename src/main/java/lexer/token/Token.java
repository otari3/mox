package lexer.token;

import lexer.token.tokenTypes.TokenType;
import lombok.Getter;

@Getter
public class Token {
    private String value;
    private TokenType type;
    public Token(String value,TokenType type){
        this.value = value;
        this.type = type;
    }

    @Override
    public String toString() {
        return "Token{" +
                "value='" + value + '\'' +
                ", type=" + type +
                '}';
    }
}
