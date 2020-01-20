package com.lishaopeng.algorithm.linear.stack.calculator;

import com.lishaopeng.algorithm.linear.stack.calculator.common.Element;
import com.lishaopeng.algorithm.linear.stack.calculator.common.ElementTypeEnum;
import com.lishaopeng.algorithm.linear.stack.calculator.exception.CalculatorException;

import java.util.Iterator;

public class ExpressionIterator implements Iterator<Element> {
    private String expression;
    private int pos;
    private Element prevElement;

    public ExpressionIterator(String expression) throws CalculatorException {
        if (expression == null || expression == "") {
            throw new CalculatorException("expression is empty");
        }
        this.expression = expression;
    }

    public boolean hasNext() {
        if (expression.length() <= pos) {
            return false;
        }
        int storePos = pos;
        skipBlank();
        boolean hasNext = expression.length() > pos;
        pos = storePos;
        return hasNext;
    }

    public Element next() {
        skipBlank();
        if (expression.length() <= pos) {
            return null;
        }
        char current = expression.charAt(pos);
        ElementTypeEnum elementType = ElementTypeEnum.valueOf(current);
        Element element = null;
        switch (elementType) {
            case PLUS:
            case MULTIPLY:
            case DIVISION:
            case PARENTHESIS_START:
            case PARENTHESIS_END:
                element = Element.of(elementType);
                break;
            case MINUS:
                if (prevElement != null && prevElement.getElementType() == ElementTypeEnum.NUMBER) {
                    element = Element.of(elementType);
                }
                break;
            default:
        }
        if (element != null) {
            prevElement = element;
            pos++;
            return prevElement;
        }
        StringBuilder sb = new StringBuilder(String.valueOf(current));
        while (expression.length() > (pos + 1)) {
            char next = expression.charAt(pos + 1);
            ElementTypeEnum nextElementType = ElementTypeEnum.valueOf(next);
            if (nextElementType == ElementTypeEnum.UNKNOWN) {
                sb.append(next);
                pos++;
            } else {
                break;
            }
        }
        Long number = Long.valueOf(sb.toString());
        pos++;
        prevElement = Element.of(ElementTypeEnum.NUMBER, number);
        return prevElement;
    }

    private void skipBlank() {
        while (ElementTypeEnum.BLANK.getSymbol().equals(String.valueOf(expression.charAt(pos)))) {
            pos++;
        }
    }
}
