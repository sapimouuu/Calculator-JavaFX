import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.text.DecimalFormat;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("Calculator");

        Label label1 = new Label("MY CALCULATOR");
        StackPane layout = new StackPane();

        TextField angka1 = new TextField();
        angka1.setPromptText("Angka pertama");

        TextField angka2 = new TextField();
        angka2.setPromptText("Angka kedua");

        Button hasil = new Button("=");
        Label akhir = new Label("");

        Label error = new Label("");

        hasil.setOnAction(event -> {
            try {
                double num1 = Double.parseDouble(angka1.getText());
                double num2 = Double.parseDouble(angka2.getText());
                double hasilSum = num1 + num2;

                DecimalFormat format = new DecimalFormat("0.##########");
                String hasilFormat = format.format(hasilSum);
                String angkaFormat1 = format.format(num1);
                String angkaFormat2 = format.format(num2);

                akhir.setText("Total " + angkaFormat1 + " + " + angkaFormat2 + " = " + hasilFormat);
                error.setText("");
            } catch (NumberFormatException e) {
                error.setText("Masukkan angka yang valid!");
            }
        });

        //STYLE
        VBox layoutKalkulator = new VBox(12);

        layoutKalkulator.getChildren().addAll(
                label1, angka1, angka2, hasil, error, akhir
        );

        layout.getChildren().add(layoutKalkulator);
        layoutKalkulator.setAlignment(Pos.CENTER);
        layout.setAlignment(Pos.CENTER);
        Scene scene1 = new Scene(layout, 250, 250);
        angka1.setMaxWidth(150);
        angka2.setMaxWidth(150);
        hasil.setMaxWidth(150);

        layout.setStyle("-fx-background-color: #2C3E50;");
        label1.setStyle("-fx-font-size: 12px; -fx-text-fill: pink; -fx-font-weight: bold;");
        angka1.setStyle("-fx-background-color: pink; -fx-prompt-text-fill: #2C3E50; -fx-background-radius: 5;");
        angka2.setStyle("-fx-background-color: pink; -fx-prompt-text-fill: #2C3E50; -fx-background-radius: 5;");
        hasil.setStyle("-fx-background-color: pink; -fx-prompt-text-fill: #2C3E50;");
        error.setStyle("-fx-font-size: 12px; -fx-text-fill: red;");
        akhir.setStyle("-fx-font-size: 12px; -fx-text-fill: pink;");

        primaryStage.setScene(scene1);
        primaryStage.show();
    }

    public static void main(String[] args){
        launch(args);
    }
}