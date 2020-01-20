package com.lishaopeng.algorithm.linear.stack.calculator.common;

public enum ElementTypeEnum {
    UNKNOWN(null, 0),
    BLANK(" ", 0),
    NUMBER(null, 1),
    PLUS("+", 5),
    MINUS("-", 5),
    MULTIPLY("*", 10),
    DIVISION("/", 10),
    PARENTHESIS_START("(", 50),
    PARENTHESIS_END(")", 50);

    private String symbol;
    private int priority;

    ElementTypeEnum(String symbol, int priority) {
        this.symbol = symbol;
        this.priority = priority;
    }

    public String getSymbol() {
        return this.symbol;
    }

    public int getPriority() {
        return this.priority;
    }

    public static ElementTypeEnum valueOf(char c) {
        String character = String.valueOf(c);
        if (character.equals(BLANK.getSymbol())) {
            return BLANK;
        }
        if (character.equals(PLUS.getSymbol())) {
            return PLUS;
        }
        if (character.equals(MINUS.getSymbol())) {
            return MINUS;
        }
        if (character.equals(MULTIPLY.getSymbol())) {
            return MULTIPLY;
        }
        if (character.equals(DIVISION.getSymbol())) {
            return DIVISION;
        }
        if (character.equals(PARENTHESIS_START.getSymbol())) {
            return PARENTHESIS_START;
        }
        if (character.equals(PARENTHESIS_END.getSymbol())) {
            return PARENTHESIS_END;
        }
        return UNKNOWN;
    }
}
