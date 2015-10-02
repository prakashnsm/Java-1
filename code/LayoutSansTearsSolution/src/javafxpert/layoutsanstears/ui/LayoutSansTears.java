/*
 * LayoutSansTears.java - JavaFX layout example
 * Author - Jim Weaver jim.weaver@javafxpert.com
 */
package javafxpert.layoutsanstears.ui;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.SceneBuilder;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class LayoutSansTears extends Application {

  public static void main(String[] args) {
    Application.launch(args);
  }
  
  @Override
  public void start(Stage primaryStage) {
    Region headerLeftSpring = new Region();
    Region headerRightSpring = new Region();
    Region footerCenterSpring = new Region();
    
    ImageView logo = new ImageView(
      new Image(getClass().getResourceAsStream("images/javafx-logo.png"))
    );
    
    HBox searchBox = HBoxBuilder.create()
      .spacing(5)
      .children(
        TextAreaBuilder.create()
          .prefWidth(120)
          .prefHeight(40)
          .maxHeight(Region.USE_PREF_SIZE)
          .build(),
        ButtonBuilder.create()
          .text("Go")
          .build()
      )
      .build();
    
    Scene scene = SceneBuilder.create()
      .stylesheets("javafxpert/layoutsanstears/ui/myStyles.css")
      .width(800)
      .height(500)
      .root(
        BorderPaneBuilder.create()
          .top(
            HBoxBuilder.create()
              .children(
                logo,
                headerLeftSpring,
                LabelBuilder.create()
                  .id("app-title")
                  .text("App Title")
                  .build(),
                headerRightSpring,
                searchBox
              )
              .build()
          )
          .center(
            TabPaneBuilder.create()
              .tabs(
                TabBuilder.create()
                  .text("Tab A")
                  .build(),
                TabBuilder.create()
                  .text("Tab B")
                  .build(),
                TabBuilder.create()
                  .text("Tab C")
                  .build()
              )
              .build()
          )
          .bottom(
            HBoxBuilder.create()
              .id("footer")
              .children(
                new Label("Footer Left"),
                footerCenterSpring,
                new Label("Footer Right")
              )
              .build()
          )
          .build()
      )
      .build();
    
    HBox.setHgrow(headerLeftSpring, Priority.ALWAYS);
    HBox.setHgrow(headerRightSpring, Priority.ALWAYS);
        
    HBox.setHgrow(footerCenterSpring, Priority.ALWAYS);
    
    HBox.setMargin(searchBox, new Insets(20, 10, 0, 0));
    
    primaryStage.setTitle("Layout Sans Tears: Solution");
    primaryStage.setScene(scene);
    primaryStage.show();
  }
}
