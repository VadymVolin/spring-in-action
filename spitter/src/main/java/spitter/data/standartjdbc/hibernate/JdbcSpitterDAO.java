package spitter.data.standartjdbc.hibernate;

import spitter.data.Spitter;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcSpitterDAO implements SpitterDAO {

    DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    private static final String SQL_INSERT = "INSERT INTO spitter(id, username, password, fullname) values(?, ?, ?, ?)";

    @Override
    public void insert(Spitter spitter) {

        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = dataSource.getConnection();
            statement = connection.prepareStatement(SQL_INSERT);
            statement.setInt(1, spitter.getId());
            statement.setString(2, spitter.getUserName());
            statement.setString(3, spitter.getPassword());
            statement.setString(4, spitter.getFullName());
            statement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                }
            }

        }
    }

    private static final String SQL_SELECT = "SELECT id, username, password, fullname FROM spitter WHERE id = ?";

    @Override
    public Spitter findById(int id) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = dataSource.getConnection();
            statement = connection.prepareStatement(SQL_SELECT);
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
            Spitter spitter = null;
            if (resultSet.next()) {
                spitter = new Spitter(
                        resultSet.getInt("id"),
                        resultSet.getString("username"),
                        resultSet.getString("password"),
                        resultSet.getString("fullname"));
            }
            return spitter;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                }
            }

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                }
            }

        }
    }

    @Override
    public void delete(Spitter spitter) {

    }

}
