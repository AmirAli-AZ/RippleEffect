package com.example.rippleeffect;

import javafx.css.*;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Skin;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.Collections;

public class XButton extends Button {

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
        var metaData = new ArrayList<CssMetaData<? extends Styleable, ?>>();
        Collections.addAll(metaData, rippleRadiusCssMetaData, rippleColorCssMetaData, rippleOpacityCssMetaData);
        getCssMetaData().addAll(Collections.unmodifiableList(metaData));
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
}
