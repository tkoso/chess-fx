package com.example.chessfx.view;

import com.example.chessfx.model.TileListener;
import com.example.chessfx.model.Position;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class PieceView extends ImageView implements TileListener {
    public PieceView(Image image) {
        super(image);
//        setImage()
    }

    @Override
    public void update(Position from, Position to) {
        if (to == null) { // this means that the piece is getting captured so we want to delete it
            setImage(null);
        } else {
            setX((to.getFile() - 'A') * 100);
            setY(800 - (to.getRank() - '0') * 100);
        }
    }

    @Override
    public Node getStyleableNode() {
        return super.getStyleableNode();
    }
}
