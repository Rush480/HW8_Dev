package ua.goit.service;

import ua.goit.util.Database;
import ua.goit.util.FileReader;

import java.nio.file.Path;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class DatabasePopulateService {
    public static void main(String[] args) {

        String populateScript = new FileReader().readFile(Path.of("sql/populate_db.sql"));

        try (Connection connection = Database.getConnection();
            PreparedStatement statement = connection.prepareStatement(populateScript)) {
             statement.execute();
        } catch (SQLException e) {
            throw new RuntimeException("Failed to execute SQL script",e);
        }
    }
}
