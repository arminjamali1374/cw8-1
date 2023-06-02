package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtils {
    private final  String url  =  "jdbc:postgresql://localhost:5432/cw " ;
    private final  String username = "postgres" ;
    private final  String password = "iran12345" ;

public Connection getConnection ()
{
    Connection connection = null ;
    try {
         connection = DriverManager.getConnection( url , username , password) ;
    } catch (SQLException e) {
        throw new RuntimeException(e);
    }
    return  connection ;
}

}
