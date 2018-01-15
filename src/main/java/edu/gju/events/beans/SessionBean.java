/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.gju.events.beans;

import edu.gju.events.daos.ConnectionDAO;
import edu.gju.events.daos.ConnectionDaoImpl;
import edu.gju.events.models.User;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.PostActivate;
import javax.enterprise.context.SessionScoped;

import javax.faces.application.NavigationHandler;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author hesham
 */
@ManagedBean(name = "userBean")
@SessionScoped
public class SessionBean implements Serializable {

    private ConnectionDAO connDao;
    private Connection connection;
    private String userName;
    private String userPassword;
    private String userGroup;
    private String sessionName;
    private int selectedItemId;
    private User loggedUser;
    private HttpServletRequest request;
    private HttpSession session;
    private FacesContext facesContext;

    public SessionBean() {
    }

    @PostConstruct
    @PostActivate
    public void init() {
        facesContext = FacesContext.getCurrentInstance();
        request = (HttpServletRequest) facesContext.getExternalContext().getRequest();
        session = request.getSession();
        loggedUser = new User();
        connDao = new ConnectionDaoImpl();
        try {
            connection = connDao.retrieveConnection();
        } catch (SQLException ex) {
            Logger.getLogger(SessionBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void login() {
        NavigationHandler navHandler = facesContext.getApplication().getNavigationHandler();
        boolean success = false;
        try {
            success = connDao.login(userName, userPassword);
            if (success) {
                if (facesContext != null) {
                    loggedUser = connDao.retriveUser(Integer.parseInt(userName));
                    userGroup = loggedUser.getUserGroup().getGroupName();
                    sessionName = (String) session.getAttribute("userName");
                    if (sessionName == null) {
                        sessionName = loggedUser.getFirstName();
                    }
                    session.setAttribute("userName", sessionName);
                    if (userGroup.equalsIgnoreCase("admin")) {
                        navHandler.handleNavigation(facesContext, null, "/admin/admin_first_page?faces-redirect=true");
                    } else if (userGroup.equalsIgnoreCase("user")) {
                        navHandler.handleNavigation(facesContext, null, "/user/user_first_page?faces-redirect=true");
                    }

                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(SessionBean.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void logout() {
        try {
            connDao.logout();
        } catch (SQLException ex) {
            Logger.getLogger(SessionBean.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            setUserName(null);
            setUserPassword(null);
            facesContext.getExternalContext().invalidateSession();
        }
    }

    public ConnectionDAO getConnDao() {
        return connDao;
    }

    public void setConnDao(ConnectionDAO connDao) {
        this.connDao = connDao;
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserGroup() {
        return userGroup;
    }

    public void setUserGroup(String userGroup) {
        this.userGroup = userGroup;
    }

    public User getLoggedUser() {
        return loggedUser;
    }

    public void setLoggedUser(User loggedUser) {
        this.loggedUser = loggedUser;
    }

    public HttpServletRequest getRequest() {
        return request;
    }

    public void setRequest(HttpServletRequest request) {
        this.request = request;
    }

    public HttpSession getSession() {
        return session;
    }

    public void setSession(HttpSession session) {
        this.session = session;
    }

    public String getSessionName() {
        return sessionName;
    }

    public void setSessionName(String sessionName) {
        this.sessionName = sessionName;
    }

    public int getSelectedItemId() {
        return selectedItemId;
    }

    public void setSelectedItemId(int selectedItemId) {
        this.selectedItemId = selectedItemId;
    }

}
