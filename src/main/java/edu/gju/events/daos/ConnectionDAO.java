/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.gju.events.daos;

import edu.gju.events.models.User;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author hesham
 */
public interface ConnectionDAO {

    public Connection retrieveConnection() throws SQLException;

    public void closeConnection() throws SQLException;

    public boolean login(String userName, String password) throws SQLException;

    public void logout() throws SQLException;

    public User retriveUser(int userId) throws SQLException;

}
