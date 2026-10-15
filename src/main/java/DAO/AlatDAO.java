package DAO;

import model.AlatPosyandu;
import java.util.List;

public interface AlatDAO {
    void create(AlatPosyandu alat);
    List<AlatPosyandu> readAll();
    void update(AlatPosyandu alat);
    void delete(int id);
}