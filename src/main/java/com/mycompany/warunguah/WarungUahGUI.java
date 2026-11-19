
package com.mycompany.warunguah;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class WarungUahGUI extends Application {

    @Override
    public void start(Stage primaryStage) {

        // 1. FORM INPUT
        Label lblNama = new Label("Nama Pelanggan:");
        TextField txtNama = new TextField();
        txtNama.setPromptText("Masukkan nama pelanggan");

        Label lblMenu = new Label("Nama Menu:");
        TextField txtMenu = new TextField();
        txtMenu.setPromptText("Masukkan nama menu");

        Label lblJumlah = new Label("Jumlah Pesanan:");
        TextField txtJumlah = new TextField();
        txtJumlah.setPromptText("Masukkan jumlah pesanan");

        Button btnSimpan = new Button("Simpan Pesanan");
        Button btnReset = new Button("Reset Form");

        // 2. TATA LETAK GRIDPANE
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(12);
        grid.setPadding(new Insets(25));

        grid.add(lblNama, 0, 0);
        grid.add(txtNama, 1, 0);

        grid.add(lblMenu, 0, 1);
        grid.add(txtMenu, 1, 1);

        grid.add(lblJumlah, 0, 2);
        grid.add(txtJumlah, 1, 2);

        HBox containerTombol = new HBox(10, btnSimpan, btnReset);
        grid.add(containerTombol, 1, 3);

        // 3. EVENT HANDLING TOMBOL RESET
        btnReset.setOnAction(e -> {
            txtNama.clear();
            txtMenu.clear();
            txtJumlah.clear();
            txtNama.requestFocus();
        });

        // 4. EVENT HANDLING TOMBOL SIMPAN
        btnSimpan.setOnAction(e -> {

            String nama = txtNama.getText().trim();
            String menu = txtMenu.getText().trim();
            String strJumlah = txtJumlah.getText().trim();

            // A. VALIDASI KOLOM KOSONG
            if (nama.isEmpty() || menu.isEmpty() || strJumlah.isEmpty()) {
                tampilkanAlert(AlertType.WARNING, "Peringatan",
                        "Seluruh kolom wajib diisi!");
                return;
            }

            // B. ERROR HANDLING
            try {
                int jumlah = Integer.parseInt(strJumlah);

                // C. VALIDASI JUMLAH PESANAN
                if (jumlah <= 0) {
                    tampilkanAlert(AlertType.WARNING, "Peringatan",
                            "Jumlah pesanan harus lebih dari 0!");
                    return;
                }

                // D. ALERT SUKSES
                String pesan = "Pesanan Berhasil Dicatat!\n\n"
                        + "Nama Pelanggan: " + nama + "\n"
                        + "Nama Menu: " + menu + "\n"
                        + "Jumlah Pesanan: " + jumlah;

                tampilkanAlert(AlertType.INFORMATION,
                        "Pesanan Berhasil", pesan);

                txtNama.clear();
                txtMenu.clear();
                txtJumlah.clear();
                txtNama.requestFocus();

            } catch (NumberFormatException ex) {
                tampilkanAlert(AlertType.ERROR, "Kesalahan Format",
                        "Jumlah pesanan harus berupa angka!");
            }
        });

        // 5. KONFIGURASI SCENE DAN STAGE
        Scene scene = new Scene(grid, 450, 250);

        primaryStage.setTitle("WarungUah");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    // HELPER METHOD ALERT
    private void tampilkanAlert(AlertType tipe, String judul, String pesan) {
        Alert alert = new Alert(tipe);
        alert.setTitle(judul);
        alert.setHeaderText(null);
        alert.setContentText(pesan);
        alert.showAndWait();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
