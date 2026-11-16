import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.text.DecimalFormat;
import javafx.scene.layout.Priority;
import javafx.geometry.Insets;
import javafx.scene.control.Separator;

public class Main extends Application {
    private void hitung(String operator, TextField angka1, TextField angka2, Label akhir, Label error) {
        DecimalFormat format = new DecimalFormat("0.##########");
        try {
            error.setText("");
            double num1 = Double.parseDouble(angka1.getText());
            double num2 = Double.parseDouble(angka2.getText());
            double hasil = 0;

            switch (operator) {
                case "+":
                    hasil = num1 + num2;
                    break;

                case "-":
                    hasil = num1 - num2;
                    break;

                case "x":
                    hasil = num1 * num2;
                    break;

                case "÷":
                    if (num2 == 0){
                        error.setText("Tidak bisa membagi dengan nol!");
                        akhir.setText("");
                        return;
                    } else {
                        hasil = num1 / num2;
                    }
                    break;
            }
            String hasilFormat = format.format(hasil);
            akhir.setText(hasilFormat);

        } catch (NumberFormatException e) {
            error.setText("Masukkan angka yang valid!");
            akhir.setText("");
        }
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("Calculator");

        Label label1 = new Label("MY CALCULATOR");
        StackPane layout = new StackPane();
        Separator garis1 = new Separator();

        Label labelAng1 = new Label("ANGKA PERTAMA");
        TextField angka1 = new TextField();
        angka1.setPromptText("Angka pertama");

        VBox inputPertama = new VBox(5);
        inputPertama.getChildren().addAll(labelAng1, angka1);
        inputPertama.setAlignment(Pos.CENTER_LEFT);

        Label labelAng2 = new Label("ANGKA KEDUA");
        TextField angka2 = new TextField();
        angka2.setPromptText("Angka kedua");

        VBox inputKedua = new VBox(5);
        inputKedua.getChildren().addAll(labelAng2, angka2);
        inputKedua.setAlignment(Pos.CENTER_LEFT);

        Label labelHasil = new Label("HASIL");
        Separator garis2 = new Separator();

        //BUTTON
        Button tambah = new Button("+");
        Button kurang = new Button("-");
        Button kali = new Button("x");
        Button bagi = new Button("÷");

        Label akhir = new Label("");
        Label error = new Label("");
        Separator garis3 = new Separator();

        tambah.setOnAction(event ->
                hitung("+", angka1, angka2, akhir, error));

        kurang.setOnAction(event ->
                hitung("-", angka1, angka2, akhir, error));

        kali.setOnAction(event ->
                hitung("x", angka1, angka2, akhir, error));

        bagi.setOnAction(event ->
                hitung("÷", angka1, angka2, akhir, error));

        //STYLE😍😡💐🌹🪻🌻❤️😂😢🌼😭🥺
        HBox operasi = new HBox(15);
        operasi.setAlignment(Pos.CENTER);

        operasi.getChildren().addAll(
                tambah, kurang, kali, bagi
        );

        VBox layoutKalkulator = new VBox(10);

        layoutKalkulator.getChildren().addAll(
                label1,
                garis1,
                inputPertama,
                inputKedua,
                operasi,
                garis2,
                labelHasil, akhir,
                garis3,
                error
        );

        layout.getChildren().add(layoutKalkulator);
        layoutKalkulator.setPadding(new Insets(20, 15, 15, 15));
        layoutKalkulator.setAlignment(Pos.CENTER);
        layout.setAlignment(Pos.CENTER);
        layoutKalkulator.setMaxWidth(280);
        layoutKalkulator.setPrefWidth(280);

        Scene scene1 = new Scene(layout, 300, 400);
        angka1.setMaxWidth(Double.MAX_VALUE);
        angka2.setMaxWidth(Double.MAX_VALUE);
        inputPertama.setMaxWidth(Double.MAX_VALUE);
        inputKedua.setMaxWidth(Double.MAX_VALUE);

        for (Separator garis : new Separator[]{garis1, garis2, garis3}){
            garis.setStyle("-fx-background-color: pink; -fx-font-size: 5px");
        }

        labelHasil.setStyle("-fx-text-fill: pink; -fx-font-size: 14px; -fx-font-weight: bold");

        for (Label label : new Label[]{labelAng1, labelAng2}){
            label.setStyle("-fx-text-fill: pink; -fx-font-size: 12px; -fx-font-weight: bold");
        };

        layout.setStyle("-fx-background-color: #2C3E50;");
        label1.setStyle("-fx-font-size: 16px;" +
                        "-fx-text-fill: pink;" +
                        "-fx-font-weight: bold;");
        angka1.setStyle("-fx-background-color: white;" +
                        "-fx-prompt-text-fill: #2C3E50;" +
                        "-fx-background-radius: 5;");
        angka2.setStyle("-fx-background-color: white;" +
                        "-fx-prompt-text-fill: #2C3E50;" +
                        "-fx-background-radius: 5;");
        error.setStyle("-fx-font-size: 12px; -fx-text-fill: red;");
        akhir.setStyle("-fx-font-size: 12px;" +
                       "-fx-text-fill: pink;" +
                       "-fx-font-weight: bold");

        for (Button btn : new Button[]{tambah, kurang, kali, bagi}) {
            btn.setMaxWidth(Double.MAX_VALUE);
            HBox.setHgrow(btn, Priority.ALWAYS);

            btn.setStyle(
                "-fx-background-color: pink; -fx-prompt-text-fill: #2C3E50;"
            );
        }

        primaryStage.setScene(scene1);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public static void main(String[] args){
        launch(args);
    }
}