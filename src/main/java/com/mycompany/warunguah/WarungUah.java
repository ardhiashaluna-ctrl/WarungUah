
package com.mycompany.warunguah;

import java.util.ArrayList;
import java.util.Scanner;

public class WarungUah {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        ArrayList<Menu> daftarMenu = new ArrayList<>();
        ArrayList<Transaksi> daftarTransaksi = new ArrayList<>();

        daftarMenu.add(new Makanan(1, "Pecel"));
        daftarMenu.add(new Makanan(2, "Soto"));
        daftarMenu.add(new Makanan(3, "Rujak Soun"));
        daftarMenu.add(new Makanan(4, "Lontong Sayur"));
        daftarMenu.add(new Makanan(5, "Nasi Sayur"));
        daftarMenu.add(new Makanan(6, "Lontong Kecap"));
        daftarMenu.add(new Makanan(7, "Gorengan"));
        daftarMenu.add(new Minuman(8, "Es Cendol"));
        daftarMenu.add(new Minuman(9, "Es Teh"));
        daftarMenu.add(new Minuman(10, "Es Cincau"));
        daftarMenu.add(new Minuman(11, "Air Mineral"));

        int pilihan;

        do {
            System.out.println("\n=== WARUNGUH ===");
            System.out.println("1. Lihat Menu");
            System.out.println("2. Catat Pembelian");
            System.out.println("3. Keluar");
            System.out.print("Pilih menu: ");

            pilihan = input.nextInt();

            switch (pilihan) {
                case 1:
                    System.out.println("\n=== DAFTAR MENU ===");

                    for (Menu menu : daftarMenu) {
                        System.out.println(menu.getId() + ". "
                                + menu.getNama() + " - "
                                + menu.getJenis());
                    }
                    break;

                case 2:
                    System.out.print("Masukkan ID menu: ");
                    int id = input.nextInt();

                    Menu menuDipilih = null;

                    for (Menu menu : daftarMenu) {
                        if (menu.getId() == id) {
                            menuDipilih = menu;
                            break;
                        }
                    }

                    if (menuDipilih != null) {
                        System.out.print("Masukkan jumlah: ");
                        int jumlah = input.nextInt();

                        if (jumlah > 0) {
                            Transaksi transaksi = new Transaksi(
                                    menuDipilih, jumlah);

                            daftarTransaksi.add(transaksi);

                            System.out.println("Pembelian berhasil dicatat!");
                            System.out.println("Menu: " + menuDipilih.getNama());
                            System.out.println("Jumlah: " + jumlah);
                        } else {
                            System.out.println("Jumlah harus lebih dari 0.");
                        }
                    } else {
                        System.out.println("Menu tidak ditemukan.");
                    }
                    break;

                case 3:
                    System.out.println("Terima kasih telah menggunakan WarungUah!");
                    break;

                default:
                    System.out.println("Pilihan tidak tersedia.");
            }

        } while (pilihan != 3);

        input.close();
    }
}
