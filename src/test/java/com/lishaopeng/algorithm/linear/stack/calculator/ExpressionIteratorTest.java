package com.lishaopeng.algorithm.linear.stack.calculator;

import com.lishaopeng.algorithm.linear.stack.calculator.common.Element;
import com.lishaopeng.algorithm.linear.stack.calculator.common.ElementTypeEnum;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ExpressionIteratorTest {

    @Test
    void test1() {
        List<Element> expectedElements = Arrays.asList(
                Element.of(ElementTypeEnum.NUMBER, -11L),
                Element.of(ElementTypeEnum.PLUS),
                Element.of(ElementTypeEnum.NUMBER, 2L),
                Element.of(ElementTypeEnum.MULTIPLY),
                Element.of(ElementTypeEnum.PARENTHESIS_START),
                Element.of(ElementTypeEnum.NUMBER, -3L),
                Element.of(ElementTypeEnum.MINUS),
                Element.of(ElementTypeEnum.NUMBER, 14L),
                Element.of(ElementTypeEnum.PARENTHESIS_END)
        );

        assertDoesNotThrow(() -> {
            ExpressionIterator iterator = new ExpressionIterator("-11+2*(-3-14)");
            int i = 0;
            while (iterator.hasNext()) {
                Element actualElement = iterator.next();
                Element expectedElement = expectedElements.get(i);
                assertEquals(expectedElement.getElementType(), actualElement.getElementType());
                assertEquals(expectedElement.getValue(), actualElement.getValue());
                i++;
            }
        });

    }
}