/**
 *
 * @author med Reda Benchraa
 */
package matrace;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Connection {

    public java.sql.Connection con;

    public Connection() throws SQLException {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = (java.sql.Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/matrace_db", "root", "");
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
