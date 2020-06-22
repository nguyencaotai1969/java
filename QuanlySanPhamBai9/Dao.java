/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QuanlySanPhamBai9;

import java.util.List;
import java.util.Optional;

/**
 *
 * @author Admin
 */
public interface Dao<T> {
    List<T> getAll();
    Optional<T> get(int id);
    int insert(T t);
    boolean update(T t);
    boolean delete(T t);
}
