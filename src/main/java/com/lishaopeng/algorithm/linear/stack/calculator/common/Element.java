package com.lishaopeng.algorithm.linear.stack.calculator.common;

public class Element {
    private ElementTypeEnum elementType;
    private Object value;

    public Element(ElementTypeEnum elementType, Object value) {
        this.elementType = elementType;
        this.value = value;
    }

    public ElementTypeEnum getElementType() {
        return this.elementType;
    }

    public Object getValue() {
        return this.value;
    }

    public static Element of(ElementTypeEnum elementType, Object value) {
        return new Element(elementType, value);
    }

    public static Element of(ElementTypeEnum elementType) {
        return of(elementType, null);
    }
}
