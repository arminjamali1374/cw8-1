package org.example.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtils {
    private final  String url  =  "jdbc:postgresql://localhost:5432/cw8" ;
    private final  String username = "postgres" ;
    private final  String password = "12161213" ;

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
