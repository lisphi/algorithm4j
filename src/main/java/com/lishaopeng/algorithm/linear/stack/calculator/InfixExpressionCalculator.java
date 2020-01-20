package com.lishaopeng.algorithm.linear.stack.calculator;

import com.lishaopeng.algorithm.linear.stack.ArrayStack;
import com.lishaopeng.algorithm.linear.stack.calculator.common.Element;
import com.lishaopeng.algorithm.linear.stack.calculator.common.ElementTypeEnum;
import com.lishaopeng.algorithm.linear.stack.calculator.exception.CalculatorException;

public class InfixExpressionCalculator implements ExpressionCalculator {
    private ArrayStack<Element> operatorStack;
    private ArrayStack<Element> numberStack;

    public InfixExpressionCalculator() {
        operatorStack = new ArrayStack<>();
        numberStack = new ArrayStack<>();
    }

    @Override
    public Long evaluate(String expression) throws CalculatorException {
        ExpressionIterator iterator = new ExpressionIterator(expression);
        while (iterator.hasNext()) {
            Element current = iterator.next();
            switch (current.getElementType()) {
                case PLUS:
                case MINUS:
                case MULTIPLY:
                case DIVISION:
                    if (operatorStack.isEmpty() ||
                            ElementTypeEnum.PARENTHESIS_START.equals(peekTop(operatorStack).getElementType())) {
                        operatorStack.push(current);
                    } else {
                        Element prevOperator = peekTop(operatorStack);
                        if (prevOperator == null) {
                            throw new CalculatorException("invalid symbol in symbolStack");
                        }
                        if (current.getElementType().getPriority() <= prevOperator.getElementType().getPriority()) {
                            executeUnits();
                        }
                        operatorStack.push(current);
                    }
                    break;
                case PARENTHESIS_START:
                    numberStack.push(current);
                    operatorStack.push(current);
                    break;
                case PARENTHESIS_END:
                    numberStack.push(current);
                    operatorStack.push(current);
                    executeUnits();
                    break;
                case NUMBER:
                    numberStack.push(current);
                    break;
                default:
                    break;
            }
        }
        return executeEoe();
    }


    private Long executeEoe() throws CalculatorException {
        while (!operatorStack.isEmpty()) {
            executeUnits();
        }
        return (Long)numberStack.pop().getValue();
    }

    private void executeUnits() throws CalculatorException {
        Element operatorElement = operatorStack.pop();
        if (ElementTypeEnum.PARENTHESIS_END.equals(operatorElement.getElementType())) {
            Element numberElement = numberStack.pop();
            if (!ElementTypeEnum.PARENTHESIS_END.equals(numberElement.getElementType())) {
                throw new CalculatorException("bracket not match");
            }
            operatorElement = operatorStack.pop();
            while (!ElementTypeEnum.PARENTHESIS_START.equals(operatorElement.getElementType())) {
                executeCurrentUnit(operatorElement);
                operatorElement = operatorStack.pop();
            }
            Element resultElement = numberStack.pop();
            Element parenthesisStart = numberStack.pop();
            if (!ElementTypeEnum.PARENTHESIS_START.equals(parenthesisStart.getElementType())) {
                throw new CalculatorException("bracket not match");
            }
            numberStack.push(resultElement);
        } else {
            executeCurrentUnit(operatorElement);
        }
    }

    private void executeCurrentUnit(Element operatorElement) throws CalculatorException {
        Long right = (Long)numberStack.pop().getValue();
        Long left = (Long)numberStack.pop().getValue();
        Long result = execute(operatorElement, left, right);
        numberStack.push(Element.of(ElementTypeEnum.NUMBER, result));
    }

    private Long execute(Element operatorElement, Long left, Long right) throws CalculatorException {
        switch (operatorElement.getElementType()) {
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

    private Element peekTop(ArrayStack<Element> stack) {
        if (stack.isEmpty()) {
            return null;
        }
        Element top = stack.pop();
        stack.push(top);
        return top;
    }
}
