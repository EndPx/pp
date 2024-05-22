/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOimplement;
import java.util.List;
import model.*;
/**
 *
 * @author abaym
 */
public interface databuku {
    public void insert(buku b);
    public void update(buku b);
    public void delete(buku b);
    public List<buku>getAll();
}
