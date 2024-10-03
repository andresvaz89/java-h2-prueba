package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class H2EnMemoria {
    public static void main(String[] args) {
        // URL de la base de datos H2 en memoria
        String url = "jdbc:h2:mem:testdb";  // 'testdb' es opcional, es el nombre de la base de datos en memoria
        String user = "sa";  // Nombre de usuario por defecto
        String password = "";  // Contraseña por defecto es una cadena vacía

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            // Crear una tabla de ejemplo
            String createTableSQL = "CREATE TABLE USUARIO (ID INT PRIMARY KEY, NOMBRE VARCHAR(255))";
            Statement statement = connection.createStatement();
            statement.execute(createTableSQL);

            // Insertar datos
            statement.execute("INSERT INTO USUARIO VALUES(1, 'Mercy')");
            statement.execute("INSERT INTO USUARIO VALUES(2, 'Andrés')");
            statement.execute("INSERT INTO USUARIO VALUES(3, 'Juan Camilo')");
            statement.execute("INSERT INTO USUARIO VALUES(4, 'Susana')");
            statement.execute("INSERT INTO USUARIO VALUES(5, 'Guadalupe')");

            // Mostrar que la tabla y los datos están en memoria
            var resultSet = statement.executeQuery("SELECT * FROM USUARIO");
            while (resultSet.next()) {
                System.out.println("ID: " + resultSet.getInt("ID") + ", Nombre: " + resultSet.getString("NOMBRE"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
