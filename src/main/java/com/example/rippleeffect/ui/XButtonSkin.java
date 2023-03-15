package com.example.rippleeffect.ui;

import javafx.animation.FadeTransition;
import javafx.animation.Interpolator;
import javafx.animation.ScaleTransition;
import javafx.scene.control.skin.ButtonSkin;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class XButtonSkin extends ButtonSkin {

    private final Rectangle ripple;

    public XButtonSkin(XButton button) {
        super(button);

        ripple = new Rectangle();
        ripple.heightProperty().bind(button.heightProperty());
        ripple.widthProperty().bind(button.widthProperty());
        ripple.arcWidthProperty().bind(button.rippleRadiusProperty());
        ripple.arcHeightProperty().bind(button.rippleRadiusProperty());
        ripple.fillProperty().bind(button.rippleColorProperty());
        ripple.setOpacity(0);

        getChildren().add(ripple);

        var scaleAnimation = new ScaleTransition(Duration.millis(300), ripple);
        scaleAnimation.setFromX(0);
        scaleAnimation.setToX(1);
        scaleAnimation.setInterpolator(Interpolator.EASE_BOTH);

        var fadeAnimation = new FadeTransition(Duration.millis(300), ripple);
        fadeAnimation.setFromValue(0);
        fadeAnimation.toValueProperty().bind(button.rippleOpacityProperty());
        fadeAnimation.setInterpolator(Interpolator.EASE_BOTH);
        fadeAnimation.setCycleCount(2);
        fadeAnimation.setAutoReverse(true);
        fadeAnimation.setOnFinished(actionEvent -> button.setRippleState(false));

        button.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
            scaleAnimation.playFromStart();
            fadeAnimation.playFromStart();
            button.setRippleState(true);
        });
    }

    public Rectangle getRipple() {
        return ripple;
    }
}
