
package com.mycompany.warunguah;

public class Makanan extends Menu {

    public Makanan(int id, String nama) {
        super(id, nama);
    }

    @Override
    public String getJenis() {
        return "Makanan";
    }
}
