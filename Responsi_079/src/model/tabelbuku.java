/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import java.util.List;
import javax.swing.table.AbstractTableModel;
/**
 *
 * @author abaym
 */
public class tabelbuku extends AbstractTableModel{
    List<buku> dp;

    public tabelbuku(List<buku> dp) {
        this.dp=dp;
    }
    @Override
    public int getRowCount() {
        return dp.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public String getColumnName(int column){
        switch(column){
            case 0:
                return "JUDUL";
            case 1:
                return "PENULIS";
            case 2:
                return "RATING";
            case 3:
                return "HARGA";
            default:
                return null;
        }
    }

    @Override
    public Object getValueAt(int row, int column) {
        switch(column){
            case 0:
                return dp.get(row).getJudul();
            case 1:
                return dp.get(row).getPenulis();
            case 2:
                return dp.get(row).getRating();
            case 3:
                return dp.get(row).getHarga();
            default:
                return null;
        }
    }
}
