package com.example.rippleeffect.ui;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.BooleanPropertyBase;
import javafx.css.*;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Skin;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class XButton extends Button {

    private final PseudoClass ripplePseudoClass = PseudoClass.getPseudoClass("ripple");


    private final BooleanProperty rippleStateProperty = new BooleanPropertyBase() {

        @Override
        protected void invalidated() {
            super.invalidated();
            pseudoClassStateChanged(ripplePseudoClass, get());
        }

        @Override
        public Object getBean() {
            return this;
        }

        @Override
        public String getName() {
            return "ripplePseudoClassListener";
        }
    };

    public XButton() {
        super();
        init();
    }

    public XButton(String text) {
        super(text);
        init();
    }

    public XButton(String text, Node node) {
        super(text, node);
        init();
    }

    @Override
    protected Skin<?> createDefaultSkin() {
        return new XButtonSkin(this);
    }

    private void init() {
        getStyleClass().add("xbutton");
    }

    @Override
    public List<CssMetaData<? extends Styleable, ?>> getControlCssMetaData() {
        var metaData = new ArrayList<>(super.getControlCssMetaData());
        Collections.addAll(metaData, rippleRadiusCssMetaData, rippleColorCssMetaData, rippleOpacityCssMetaData);
        return metaData;
    }

    private final StyleableDoubleProperty rippleRadiusProperty = new SimpleStyleableDoubleProperty(rippleRadiusCssMetaData, this, "styleableRippleRadius");

    private static final CssMetaData<XButton, Number> rippleRadiusCssMetaData = new CssMetaData<>("-fx-ripple-radius", StyleConverter.getSizeConverter()) {
        @Override
        public boolean isSettable(XButton xButton) {
            return !xButton.rippleRadiusProperty.isBound();
        }

        @Override
        public StyleableProperty<Number> getStyleableProperty(XButton xButton) {
            return xButton.rippleRadiusProperty;
        }
    };

    private final StyleableObjectProperty<Color> rippleColorProperty = new SimpleStyleableObjectProperty<>(rippleColorCssMetaData, this, "styleableRippleColorProperty", Color.LIGHTGRAY);

    private static final CssMetaData<XButton, Color> rippleColorCssMetaData = new CssMetaData<>("-fx-ripple-color", StyleConverter.getColorConverter()) {
        @Override
        public boolean isSettable(XButton xButton) {
            return !xButton.rippleColorProperty.isBound();
        }

        @Override
        public StyleableProperty<Color> getStyleableProperty(XButton xButton) {
            return xButton.rippleColorProperty;
        }
    };

    private final StyleableDoubleProperty rippleOpacityProperty = new SimpleStyleableDoubleProperty(rippleRadiusCssMetaData, this, "styleableRippleRadius", 0.0);

    private static final CssMetaData<XButton, Number> rippleOpacityCssMetaData = new CssMetaData<>("-fx-ripple-opacity", StyleConverter.getSizeConverter()) {
        @Override
        public boolean isSettable(XButton xButton) {
            return !xButton.rippleOpacityProperty.isBound();
        }

        @Override
        public StyleableProperty<Number> getStyleableProperty(XButton xButton) {
            return xButton.rippleOpacityProperty;
        }
    };

    public double getRippleRadius() {
        return rippleRadiusProperty.get();
    }

    public StyleableDoubleProperty rippleRadiusProperty() {
        return rippleRadiusProperty;
    }

    public void setRippleRadius(double rippleRadiusProperty) {
        this.rippleRadiusProperty.set(rippleRadiusProperty);
    }

    public Color getRippleColor() {
        return rippleColorProperty.get();
    }

    public StyleableObjectProperty<Color> rippleColorProperty() {
        return rippleColorProperty;
    }

    public void setRippleColor(Color rippleColorProperty) {
        this.rippleColorProperty.set(rippleColorProperty);
    }

    public double getRippleOpacity() {
        return rippleOpacityProperty.get();
    }

    public StyleableDoubleProperty rippleOpacityProperty() {
        return rippleOpacityProperty;
    }

    public void setRippleOpacity(double rippleOpacityProperty) {
        this.rippleOpacityProperty.set(rippleOpacityProperty);
    }

    protected void setRippleState(boolean rippleState) {
        rippleStateProperty.set(rippleState);
    }

    protected boolean getRippleState() {
        return rippleStateProperty.get();
    }

    protected BooleanProperty rippleStateProperty() {
        return rippleStateProperty;
    }
}
