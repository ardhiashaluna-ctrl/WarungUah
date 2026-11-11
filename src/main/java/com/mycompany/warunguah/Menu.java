

package com.mycompany.warunguah;

public class Menu {
    private int id;
    private String nama;

    public Menu(int id, String nama) {
        this.id = id;
        this.nama = nama;
    }

    public int getId() {
        return id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getJenis() {
        return "Menu";
    }
}

