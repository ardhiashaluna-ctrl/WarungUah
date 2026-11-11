
package com.mycompany.warunguah;

public class Transaksi {
    private Menu menu;
    private int jumlah;

    public Transaksi(Menu menu, int jumlah) {
        this.menu = menu;
        this.jumlah = jumlah;
    }

    public Menu getMenu() {
        return menu;
    }

    public int getJumlah() {
        return jumlah;
    }
}
