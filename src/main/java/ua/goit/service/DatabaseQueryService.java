package ua.goit.service;


import ua.goit.service.entity.*;
import ua.goit.util.Database;
import ua.goit.util.FileReader;

import java.nio.file.Path;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DatabaseQueryService {

    FileReader fileReader = new FileReader();

    private ResultSet getResultSet(Connection connection, String query) throws SQLException {
         PreparedStatement statement = connection.prepareStatement(query);
        return statement.executeQuery();
    }


    public List<MaxProjectCountClient> findMaxProjectsClient() throws SQLException {
        List<MaxProjectCountClient> result = new ArrayList<>();

        try (ResultSet resultSet = getResultSet(Database.getConnection(), fileReader.readFile(Path.of("sql/find_max_projects_client.sql")))) {
            while (resultSet.next()) {
                result.add(MaxProjectCountClient.builder()
                        .clientName(resultSet.getString("name"))
                        .projectCount(resultSet.getObject("project_count", Long.class))
                        .build());

            }
        }
        return result;
    }

    public List<MaxSalaryWorker> findMaxSalaryWorker() throws SQLException {
        List<MaxSalaryWorker> result = new ArrayList<>();
        try (ResultSet resultSet = getResultSet(Database.getConnection(), fileReader.readFile(Path.of("sql/find_max_salary_worker.sql")))) {
            while (resultSet.next()) {
                result.add(MaxSalaryWorker.builder()
                        .workerName(resultSet.getString("name"))
                        .salary(resultSet.getObject("salary", Integer.class))
                        .build());
            }
        }
        return result;
    }

    public List<LongestProject> findLongestProject() throws SQLException {
        List<LongestProject> result = new ArrayList<>();
        try (ResultSet resultSet = getResultSet(Database.getConnection(), fileReader.readFile(Path.of("sql/find_longest_project.sql")))) {
            while (resultSet.next()) {
                result.add(LongestProject.builder()
                        .id(resultSet.getInt("id"))
                        .monthCount(resultSet.getInt("month_count"))
                        .build());
            }
        }
        return result;
    }

    public List<YongestOldestWorker> findYongestOldestWorker() throws SQLException {
        List<YongestOldestWorker> result = new ArrayList<>();
        try (ResultSet resultSet = getResultSet(Database.getConnection(), fileReader.readFile(Path.of("sql/find_youngest_oldest_worker.sql")))) {
            while (resultSet.next()) {
                result.add(YongestOldestWorker.builder()
                        .typeOfAge(resultSet.getString("type"))
                        .workerName(resultSet.getString("name"))
                        .birthDate(resultSet.getObject("birthday", LocalDate.class))
                        .build());
            }
        }
        return result;
    }

    public List<ProjectPrice> getProjectPrices() throws SQLException {
        List<ProjectPrice> result = new ArrayList<>();
        try (ResultSet resultSet = getResultSet(Database.getConnection(), fileReader.readFile(Path.of("sql/print_project_prices.sql")))) {
            while (resultSet.next()) {
                result.add(ProjectPrice.builder()
                        .id(resultSet.getInt("project_id"))
                        .price(resultSet.getInt("price"))
                        .build());
            }
        }
        return result;
    }
}
