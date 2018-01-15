/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.gju.events.daos;

import edu.gju.events.models.User;
import edu.gju.events.utils.EventsEnum;
import edu.gju.events.utils.PopulateModels;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author hesham
 */
public class ConnectionDaoImpl implements ConnectionDAO, Serializable {

//    @Resource(lookup = "jdbc/events")
    private DataSource dataSource;
    private Connection connection;

    public ConnectionDaoImpl() {

    }

    @Override
    public Connection retrieveConnection() throws SQLException {
        try {
            Context ctx = new InitialContext();
            dataSource = (DataSource) ctx.lookup("jdbc/events");
        } catch (NamingException ex) {
            Logger.getLogger(ConnectionDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        connection = dataSource.getConnection();
        return connection;
    }

    @Override
    public void closeConnection() throws SQLException {
        if (connection != null) {
            connection.close();
        }
    }

    @Override
    public boolean login(String userName, String password) throws SQLException {
        connection = retrieveConnection();
        boolean result = false;
        PreparedStatement ps = connection.prepareStatement(EventsEnum.GET_LOGIN_INFO.toString());
        ps.setString(1, userName);
        ResultSet rs = ps.executeQuery();
        if (rs != null) {
            result = true;
        }
        return result;
    }

    @Override
    public void logout() throws SQLException {
        if (connection != null) {

            closeConnection();
            connection = null;
        }
    }

    @Override
    public User retriveUser(int userId) throws SQLException {
        Connection connection = retrieveConnection();
        User user = new User();
        PreparedStatement ps = connection.prepareStatement(EventsEnum.GET_USER_INFO.toString());
        ps.setInt(1, userId);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            user = PopulateModels.populateUser(rs);
        }
        return user;
    }

    public DataSource getDataSource() {
        return dataSource;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

}
