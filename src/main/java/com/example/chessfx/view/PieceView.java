package com.example.chessfx.view;

import com.example.chessfx.model.TileListener;
import com.example.chessfx.model.Position;
import javafx.scene.Node;
import javafx.scene.image.ImageView;

public class PieceView extends ImageView implements TileListener {
    public PieceView() {

    }

    @Override
    public void update(Position from, Position to) {

    }

    @Override
    public Node getStyleableNode() {
        return super.getStyleableNode();
    }
}
