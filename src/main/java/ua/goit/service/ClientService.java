package ua.goit.service;

import ua.goit.service.entity.Client;
import ua.goit.util.Database;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClientService {
    private static final String CREATE_CLIENT_SQL_TEMPLATE =
            "INSERT INTO client(name) VALUES (?)";
    private static final String SELECT_CLIENT_BY_ID_SQL_TEMPLATE =
            "SELECT name FROM client WHERE id = ?";
    private static final String UPDATE_CLIENT_NAME_BY_ID_SQL_TEMPLATE =
            "UPDATE client SET name = ? WHERE id = ?";
    private static final String DELETE_CLIENT_BY_ID_SQL_TEMPLATE =
            "DELETE FROM client WHERE id = ?";
    private static final String SELECT_ALL_CLIENTS_SQL_TEMPLATE =
            "SELECT id, name FROM client";


    public long create(String name) throws SQLException {
        checkName(name);
        Connection connection = Database.getConnection();
        long result = -1;

        try (PreparedStatement statement = connection.prepareStatement(CREATE_CLIENT_SQL_TEMPLATE,
                Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, name);
            statement.executeUpdate();
            ResultSet generatedKey = statement.getGeneratedKeys();
            generatedKey.next();
            result = generatedKey.getObject("id", Integer.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public String getById(long id) throws SQLException {
        checkId(id);
        Connection connection = Database.getConnection();
        try (PreparedStatement statement = connection.prepareStatement(SELECT_CLIENT_BY_ID_SQL_TEMPLATE)) {
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (!resultSet.next()) {
                throw new RuntimeException("No data found for id = " + id);
            }
            return resultSet.getString("name");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        throw new RuntimeException("No data found for id = " + id);
    }

    public void setName(long id, String name) throws SQLException {
        checkId(id);
        checkName(name);
        Connection connection = Database.getConnection();
        try (PreparedStatement statement = connection.prepareStatement(UPDATE_CLIENT_NAME_BY_ID_SQL_TEMPLATE)) {
            statement.setString(1, name);
            statement.setLong(2, id);
            int cntUpdated = statement.executeUpdate();
            if (cntUpdated == 0) {
                throw new RuntimeException("No data found for update!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteById(long id) throws SQLException {
        checkId(id);
        Connection connection = Database.getConnection();
        try (PreparedStatement statement = connection.prepareStatement(DELETE_CLIENT_BY_ID_SQL_TEMPLATE)) {
            statement.setLong(1, id);
            int cntUpdated = statement.executeUpdate();
            if (cntUpdated == 0) {
                throw new RuntimeException("No data found for update!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Client> listAll() throws SQLException {
        List<Client> result = new ArrayList<>();
        Connection connection = Database.getConnection();
        try (PreparedStatement statement = connection.prepareStatement(SELECT_ALL_CLIENTS_SQL_TEMPLATE)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                result.add(Client.builder()
                        .id(resultSet.getLong("id"))
                        .name(resultSet.getString("name"))
                        .build());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    private static void checkName(String name) {
        if (name.length() < 2 || name.length() > 1000) {
            throw new IllegalArgumentException("Name's length must be between 2 and 1000 characters.");
        }
    }

    private static void checkId(long id) {
        if (id < 0) {
            throw new IllegalArgumentException("Id must be positive.");
        }
    }

}

