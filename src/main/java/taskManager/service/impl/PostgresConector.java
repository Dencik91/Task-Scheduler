package taskManager.service.impl;

import taskManager.Status;
import taskManager.dataTransferObject.TaskDTO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class PostgresConector {
    private static Logger logger = Logger.getLogger(PostgresConector.class.getName());
    private static String URL = "jdbc:postgresql://192.168.136.129:5432/postgres";
    private static String USER = "postgres";
    private static String PASSWORD = "yourpassword";
    private static String sqlGetAllTasks = "SELECT * FROM tasks";
    private static List<TaskDTO> results = new ArrayList<>();

    public static List<TaskDTO> connect() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            logger.info("Connection to database is successful");
            preparedStatement = connection.prepareStatement(sqlGetAllTasks);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                results.add(new TaskDTO(resultSet.getString("taskName"),
                        resultSet.getTimestamp("executionTime").toLocalDateTime(),
                        Status.valueOf(resultSet.getString("taskStatus"))));
                logger.info("Task " + resultSet.getString("taskName") + " is added to the list");
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
        ResultSet resultSet = null;
        String sqlUpdate = "UPDATE tasks SET taskStatus = 'COMPLETED' WHERE taskName = ?";

        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            logger.info("Connection to database is successful");
            preparedStatement = connection.prepareStatement(sqlUpdate);
            preparedStatement.setString(1, taskName);
            preparedStatement.executeUpdate();
            logger.info("Task " + taskName + " in DB is changed to COMPLETED");
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
