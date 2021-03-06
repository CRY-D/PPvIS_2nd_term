package view;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import server.Server;

import java.io.IOException;

public class MainWindow {

    private Button run = new Button("Run");
    private Button stop = new Button("Stop");
    private Server server;


    public MainWindow(Stage stage, Server server){
        TextArea actions = new TextArea();
        this.server = server;
        this.server.addTextArea(actions);
        stage.setTitle("server");
        Group root = new Group();
        VBox vBox = new VBox();
        HBox hBox = new HBox();
        run.setMinSize(250,250);
        stop.setMinSize(250,250);
        hBox.getChildren().setAll(run, stop);
        vBox.getChildren().addAll(hBox, actions);
        root.getChildren().addAll(vBox);
        stage.setScene(new Scene(root, 500, 500));
        stage.show();
        addListeners();
    }

    private void addListeners(){
        run.setOnAction((e)->{
            server.makeTrue();
            server.runServer();

        });

        stop.setOnAction((e)->{
            try{
                server.makeFalse();
                server.stopServer();
            }
            catch (IOException exp){
                exp.printStackTrace();
            }
        });
    }
}
