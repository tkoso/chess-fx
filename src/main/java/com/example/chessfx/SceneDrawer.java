package com.example.chessfx;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeType;

public class SceneDrawer {
    private final Group root;

    public SceneDrawer(Group root) {
        this.root = root;
    }

    public void updateScene() {
        Rectangle[] lastRectangleMarked = new Rectangle[1];
        for (int i = 0; i < 8; ++i) {
            for (int j = 0; j < 8; ++j) {
                Rectangle rectangle = new Rectangle();
                rectangle.setX(i * 100);
                rectangle.setY(j * 100);
                rectangle.setWidth(100);
                rectangle.setHeight(100);
                rectangle.setFill(((i + j) % 2 == 0) ? Color.LIGHTGRAY : Color.ROSYBROWN);
                rectangle.setStrokeType(StrokeType.INSIDE);
                rectangle.setStroke(Color.BLACK);
                rectangle.setOnMouseClicked(event -> {
                    if (lastRectangleMarked[0] == null) {
                        rectangle.setStrokeWidth(5);
                        lastRectangleMarked[0] = rectangle;
                    } else {
                        if (rectangle == lastRectangleMarked[0]) {
                            rectangle.setStrokeWidth(1);
                            lastRectangleMarked[0] = null;
                        } else {
                            rectangle.setStrokeWidth(5);
                            lastRectangleMarked[0].setStrokeWidth(1);
                            lastRectangleMarked[0] = rectangle;
                        }
                    }
                });
                root.getChildren().add(rectangle);
            }
        }
    }
}
