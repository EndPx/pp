/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.databukuDAO;
import java.util.List;
import model.*;
import responsi_079.MainView;

/**
 *
 * @author abaym
 */
public class bukucontroller {
    MainView frame;
    databukuDAO impldatabuku;
    List<buku> dp;
    
    public bukucontroller(MainView frame){
        this.frame=frame;
        impldatabuku = new databukuDAO();
        dp = impldatabuku.getAll();
    }
    
    public void isitabel(){
        dp = impldatabuku.getAll();
        tabelbuku tb = new tabelbuku(dp);
        frame.getTabeldata().setModel(tb);
    }
    
    public void insert(){
        buku dp = new buku();
        dp.setJudul(frame.getJudul().getText());
        dp.setPenulis(frame.getPenulis().getText());
        dp.setRating(Double.parseDouble(frame.getRating().getText()));
        dp.setHarga(dp.menghitungHarga(Integer.parseInt(frame.getHarga().getText())));
        impldatabuku.insert(dp);
    }
    
    public void update(){
        buku dp = new buku();
        dp.setJudul(frame.getJudul().getText());
        dp.setPenulis(frame.getPenulis().getText());
        dp.setRating(Double.parseDouble(frame.getRating().getText()));
        dp.setHarga(dp.menghitungHarga(Integer.parseInt(frame.getHarga().getText())));
        impldatabuku.update(dp);
    }
    
    public void delete(){
        buku dp = new buku();
        dp.setJudul(frame.getJudul().getText());
        impldatabuku.delete(dp);
    }
}
