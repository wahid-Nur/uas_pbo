import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Acer
 */
public interface tk {
    Data insert(Data data) throws SQLException;
    void update(Data data) throws SQLException;
    void delete(String kode) throws SQLException;
    List getAll() throws SQLException;
}
