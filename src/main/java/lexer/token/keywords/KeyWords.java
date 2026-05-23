package lexer.token.keywords;

import lexer.token.tokenTypes.TokenType;

import java.util.Map;

public class KeyWords {
    public static final Map<String, TokenType> KEYWORDS = Map.of(
            "let",TokenType.LET
    );
}
