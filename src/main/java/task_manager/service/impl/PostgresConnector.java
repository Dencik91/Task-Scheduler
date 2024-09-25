package task_manager.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import task_manager.Status;
import task_manager.dataTransferObject.TaskDTO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PostgresConnector {
    private static final Logger logger = LoggerFactory.getLogger(PostgresConnector.class);
    private static final String URL = "jdbc:postgresql://192.168.136.129:5432/postgres";
    private static final String USER = "postgres";
    private static final String PASSWORD = "yourpassword";
    private static final List<TaskDTO> results = new ArrayList<>();

    private PostgresConnector() {
        throw new IllegalStateException("Utility class");
    }

    public static List<TaskDTO> connect() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            logger.info("Connection to database for consume is successful");
            String sqlGetAllTasks = "SELECT * FROM tasks";
            preparedStatement = connection.prepareStatement(sqlGetAllTasks);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                results.add(new TaskDTO(resultSet.getString("taskName"),
                        resultSet.getTimestamp("executionTime").toLocalDateTime(),
                        Status.valueOf(resultSet.getString("taskStatus"))));
                logger.info("Task {} is added to the list", resultSet.getString("taskName"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) resultSet.close();
                if (preparedStatement != null) preparedStatement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return results;
    }

    public static void taskCompleted(String taskName) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        String sqlUpdate = "UPDATE tasks SET taskStatus = 'COMPLETED' WHERE taskName = ?;";

        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            logger.info("Connection to database for Update is successful");
            preparedStatement = connection.prepareStatement(sqlUpdate);
            preparedStatement.setString(1, taskName);
            preparedStatement.executeUpdate();
            logger.info("Task {} in DB is changed to COMPLETED", taskName);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (preparedStatement != null) preparedStatement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
