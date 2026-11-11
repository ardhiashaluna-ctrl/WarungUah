
package com.mycompany.warunguah;

public class Minuman extends Menu {

    public Minuman(int id, String nama) {
        super(id, nama);
    }

    @Override
    public String getJenis() {
        return "Minuman";
    }
}
