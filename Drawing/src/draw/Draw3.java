// Draw3.java

// Implement an animated fade for the Clear button
package draw;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import javafx.animation.FadeTransition;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.SequentialTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.Tooltip;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Draw3 extends Application {

    private Path path;
    private Group lineGroup;
    private static final Double DEFAULTSTROKE = 3.0;
    private static final Double MAXSTROKE = 30.0;
    private static final Double MINSTROKE = 1.0;
    private SequentialTransition seqtran = null;
    private Timeline timeline = null;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Drawing Tool");
        final Group root = new Group();

        Scene scene = new Scene(root, 600, 400);

        // A group to hold all the drawn path elements
        lineGroup = new Group();

        // Build the slider, label, and button and their VBox layout container 
        Button btnClear = new Button();
        btnClear.setText("Clear");
        btnClear.setOnAction(new EventHandler<ActionEvent>() {

            public void handle(ActionEvent event) {
                if (lineGroup.getChildren().size() == 0) {
                    return;
                }
                if (seqtran != null) {
                    seqtran.stop();
                }
                seqtran = new SequentialTransition();
                for (final Node node : lineGroup.getChildren()) {
                    FadeTransition ft = new FadeTransition(Duration.millis(1000), node);
                    ft.setToValue(0.0);
                    ft.setInterpolator(Interpolator.EASE_BOTH);
                    // fade in reverse order
                    seqtran.getChildren().add(0, ft);
                }

                if (timeline != null) {
                    timeline.stop();
                }
                timeline = new Timeline();
                timeline.getKeyFrames().add(
                        new KeyFrame(Duration.millis(1),
                        new EventHandler<ActionEvent>() {

                            public void handle(ActionEvent event) {
                                lineGroup.getChildren().removeAll(lineGroup.getChildren());

                            }
                        }));
                seqtran.getChildren().add(timeline);
                seqtran.playFromStart();

            }
        });

        Slider strokeSlider = new Slider(MINSTROKE, MAXSTROKE, DEFAULTSTROKE);
        Label labelStroke = new Label("Stroke Width");
        VBox utilBox = new VBox(10);
        utilBox.setAlignment(Pos.TOP_CENTER);
        utilBox.getChildren().addAll(btnClear, labelStroke, strokeSlider);

        // Build the sample line and its layout container
        final Line sampleLine = new Line(0, 0, 140, 0);
        sampleLine.strokeWidthProperty().bind(strokeSlider.valueProperty());
        sampleLine.setStroke(Color.BLUE);
        StackPane stackpane = new StackPane();
        stackpane.setPrefHeight(MAXSTROKE);
        stackpane.setPrefWidth(sampleLine.getEndX() + MAXSTROKE);
        stackpane.setAlignment(Pos.CENTER);
        stackpane.getChildren().add(sampleLine);

        // Build the color label and its layout container
        final Label colorLabel = new Label("color: blue");
        StackPane stackpane2 = new StackPane();
        stackpane2.setPrefHeight(MAXSTROKE);
        stackpane2.setPrefWidth(sampleLine.getEndX() + MAXSTROKE);
        stackpane2.setAlignment(Pos.CENTER_LEFT);
        stackpane2.getChildren().add(colorLabel);

        // Build the HBox layout container for the two stackpane's
        HBox lineBox = new HBox(20);
        lineBox.setAlignment(Pos.CENTER);
        lineBox.getChildren().addAll(stackpane, stackpane2);

        // Build the color picker and use a flowpane
        FlowPane flow = new FlowPane();

        flow.setVgap(2);
        flow.setHgap(2);
        flow.setPrefWrapLength(400);
        // Get the declared fields for the Color class
        Field[] colorFields = Color.class.getDeclaredFields();
        for (Field fieldname : colorFields) {
            int mods = fieldname.getModifiers();

            // Only look at the field if it's public, static, and NOT 'TRANSPARENT'
            if (Modifier.isPublic(mods) && Modifier.isStatic(mods)
                    && !(fieldname.getName().equals("TRANSPARENT"))) {
                try {

                    Color c = Color.web(fieldname.getName());
                    // Make a rectangle with that field name's color
                    final Rectangle r = new Rectangle(15, 15, c);
                    // Configure the rectangle 
                    r.setCursor(Cursor.HAND);
                    Tooltip t = new Tooltip(fieldname.getName().toLowerCase());
                    Tooltip.install(r, t);
                    r.setUserData(t.getText());
                    r.setOnMouseClicked(new EventHandler<MouseEvent>() {

                        @Override
                        public void handle(MouseEvent me) {
                            sampleLine.setStroke(r.getFill());
                            colorLabel.setText("color: " + ((String) r.getUserData()));
                        }
                    });
                    flow.getChildren().add(r);
                } catch (IllegalArgumentException e) {
                    // just ignore it if for some reason we can't make
                    // a color
                }

            }
        }

        // Build the layout container for the VBox utility box and the flowpane
        HBox toolBox = new HBox(10);
        toolBox.setAlignment(Pos.TOP_CENTER);
        toolBox.getChildren().addAll(utilBox, flow);

        // Build the canvas
        final Rectangle canvas = new Rectangle(scene.getWidth() - 20, scene.getHeight() - 230);
        canvas.setCursor(Cursor.CROSSHAIR);
        canvas.setFill(Color.LIGHTGRAY);
        canvas.setOnMousePressed(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent me) {

                path = new Path();
                path.setMouseTransparent(false);
                path.setStrokeWidth(sampleLine.getStrokeWidth());
                path.setStroke(sampleLine.getStroke());
                lineGroup.getChildren().add(path);
                path.getElements().add(new MoveTo(me.getSceneX(), me.getSceneY()));
            }
        });

        canvas.setOnMouseReleased(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent me) {
                path = null;

            }
        });

        canvas.setOnMouseDragged(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent me) {

                // keep lines within rectangle
                if (canvas.getBoundsInLocal().contains(me.getX(), me.getY())) {
                    path.getElements().add(new LineTo(me.getSceneX(), me.getSceneY()));
                }

            }
        });

        // Build the VBox container for the lineBox, canvas, and toolBox
        VBox vb = new VBox(20);
        vb.setLayoutX(10);
        vb.setLayoutY(20);
        vb.getChildren().addAll(lineBox, canvas, toolBox);
        root.getChildren().addAll(vb, lineGroup);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}