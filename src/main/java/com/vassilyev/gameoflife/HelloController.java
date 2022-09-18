package com.vassilyev.gameoflife;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.util.Callback;
import org.controlsfx.control.GridCell;
import org.controlsfx.control.GridView;
import org.controlsfx.control.cell.ColorGridCell;

import java.util.Random;

public class HelloController {
    @FXML
    private GridPane gridPane;

    private Board board = new Board(15, 15);

    @FXML
    private void initialize() {

        board.set(3, 3, true);
        board.set(3, 4, true);
        board.set(4, 3, true);
        board.set(4, 4, true);

        //
        board.set(5, 5, true);
        board.set(5, 6, true);
        board.set(6, 5, true);
        board.set(6, 6, true);

        draw();

    }

    private void draw() {
        for (int i = 1; i < board.width; i++) {
            for (int j = 1; j < board.height; j++) {
                Rectangle rectangle = new Rectangle(gridPane.getWidth() / board.width,
                        gridPane.getHeight() / board.height);
                rectangle.setStrokeWidth(2);
                rectangle.setStroke(new Color(0.5, 0.5, 0.5, 0.7));
                if (board.get(i, j) == 1) {
                    rectangle.setFill(new Color(0.0, 0.0, 0.0, 1.0));
                } else {
                    rectangle.setFill(new Color(1.0, 1.0, 1.0, 1.0));
                }
                gridPane.add(rectangle, j, i);
            }
        }
    }

    @FXML
    protected void onStepButtonClick() {
        //list.add(String.valueOf(Math.random()));
        board.step();
        draw();
    }



    @FXML
    protected void onGridClick(MouseEvent event) {
        System.out.println(event.getTarget());
        Node node = (Node) event.getTarget();

        int i = GridPane.getRowIndex(node);
        int j = GridPane.getColumnIndex(node);
        System.out.printf("i = %d, j = %d", i, j);
        if (board.get(i, j) == 0) {
            board.set(i, j, true);
        }
        else {
            board.set(i, j, false);
        }
        draw();
    }

    public void onRunButtonClick(ActionEvent actionEvent) {
    }

    public void onStopButtonClick(ActionEvent actionEvent) {
    }

    public void onClearButtonClick(ActionEvent actionEvent) {
        board.clear();
    }
}