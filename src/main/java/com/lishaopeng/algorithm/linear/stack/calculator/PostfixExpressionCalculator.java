package com.lishaopeng.algorithm.linear.stack.calculator;

import com.lishaopeng.algorithm.linear.array.SimpleArrayList;
import com.lishaopeng.algorithm.linear.stack.ArrayStack;
import com.lishaopeng.algorithm.linear.stack.calculator.common.Element;
import com.lishaopeng.algorithm.linear.stack.calculator.common.ElementTypeEnum;
import com.lishaopeng.algorithm.linear.stack.calculator.exception.CalculatorException;

public class PostfixExpressionCalculator implements ExpressionCalculator {
    @Override
    public Long evaluate(String expressoin) throws CalculatorException {
        ExpressionIterator iterator = new ExpressionIterator(expressoin);
        Iterable<Element> postfixElements = generatePostfixElements(iterator);
        ArrayStack<Element> elementStack = new ArrayStack<>();
        for (Element currentElement : postfixElements) {
            if (currentElement == null) {
                break;
            }
            switch (currentElement.getElementType()) {
                case PLUS:
                case MINUS:
                case MULTIPLY:
                case DIVISION:
                    Element right = elementStack.pop();
                    Element left = elementStack.pop();
                    Long result = calculate(currentElement.getElementType(), (Long)left.getValue(), (Long)right.getValue());
                    elementStack.push(Element.of(ElementTypeEnum.NUMBER, result));
                    break;
                case NUMBER:
                    elementStack.push(currentElement);
                    break;
                default:
                    break;
            }
        }
        Element resultElement = elementStack.pop();
        return (Long)resultElement.getValue();
    }

    private Iterable<Element> generatePostfixElements(ExpressionIterator iterator) {
        SimpleArrayList<Element> postfixElements = new SimpleArrayList<>();
        ArrayStack<Element> symbolElementStack = new ArrayStack<>();
        while (iterator.hasNext()) {
            Element currentElement = iterator.next();
            if (currentElement.getElementType() == ElementTypeEnum.NUMBER) {
                postfixElements.add(currentElement);
                continue;
            }

            if (currentElement.getElementType() == ElementTypeEnum.PARENTHESIS_START) {
                symbolElementStack.push(currentElement);
                continue;
            }

            if (currentElement.getElementType() == ElementTypeEnum.PLUS ||
                    currentElement.getElementType() == ElementTypeEnum.MINUS ||
                    currentElement.getElementType() == ElementTypeEnum.MULTIPLY ||
                    currentElement.getElementType() == ElementTypeEnum.DIVISION) {
                while (!symbolElementStack.isEmpty()) {
                    Element topSymbolElement = symbolElementStack.pop();
                    if (topSymbolElement.getElementType() == ElementTypeEnum.PARENTHESIS_START) {
                        symbolElementStack.push(topSymbolElement);
                        symbolElementStack.push(currentElement);
                        break;
                    }
                    if (topSymbolElement.getElementType().getPriority() >= currentElement.getElementType().getPriority()) {
                        postfixElements.add(topSymbolElement);
                    } else {
                        symbolElementStack.push(topSymbolElement);
                        symbolElementStack.push(currentElement);
                        break;
                    }
                }
                if (symbolElementStack.isEmpty()) {
                    symbolElementStack.push(currentElement);
                }
                continue;
            }

            if (currentElement.getElementType() == ElementTypeEnum.PARENTHESIS_END) {
                while (!symbolElementStack.isEmpty()) {
                    Element topSymbolElement = symbolElementStack.pop();
                    if (topSymbolElement.getElementType() == ElementTypeEnum.PARENTHESIS_START) {
                        break;
                    }
                    postfixElements.add(topSymbolElement);
                }
                continue;
            }
        }
        while (!symbolElementStack.isEmpty()) {
            postfixElements.add(symbolElementStack.pop());
        }
        return postfixElements;
    }

    private Long calculate(ElementTypeEnum elementType, Long left, Long right) throws CalculatorException {
        switch (elementType) {
            case PLUS:
                return left + right;
            case MINUS:
                return left - right;
            case MULTIPLY:
                return left * right;
            case DIVISION:
                return left / right;
            default:
                throw new CalculatorException("operator not support");
        }
    }
}