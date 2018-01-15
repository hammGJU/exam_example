/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.gju.events.utils;

/**
 *
 * @author hesham
 */
public enum EventsEnum {
    //Events
    EVENT_ID("EVENT_ID"),
    EVENT_NAME_EN("NAME_EN"),
    EVENT_NAME_AR("NAME_AR"),
    EVENT_PALCE_EN("PLACE_EN"),
    EVENT_PLACE_AR("PLACE_AR"),
    EVENT_DATE("EVENT_DATE"),
    EVENT_CAPACITY("CAPACITY"),
    EVENT_TYPE_ID("EVENT_TYPE_ID"),
    //EVENT_TYPE:
    EVENT_TYPE_NAME_EN("NAME_EN"),
    V_EVENT_TYPE_NAME_EN("TNE"),
    EVENT_TYPE_NAME_AR("NAME_AR"),
    V_EVENT_TYPE_NAME_AR("TNA"),
    //USERS:
    USER_ID("USER_ID"),
    USER_NAME("USER_NAME"),
    USER_PASSWORD("USER_PASSWORD"),
    FIRST_NAME("FIRST_NAME"),
    LAST_NAME("LAST_NAME"),
    GROUP_ID("GROUP_ID"),
    //USER_GROUPS
    GROUP_NAME("G_NAME"),
    //Queries
    GET_EVENT_TYPES("SELECT EVENT_TYPE_ID, NAME_EN, NAME_AR FROM EVENT_TYPES ORDER BY EVENT_TYPE_ID"),
    GET_EVENTS("SELECT * FROM V_EVENT_DATA ORDER BY EVENT_ID"),
    FETCH_EVENT("SELECT * FROM V_EVENT_DATA WHERE EVENT_ID=?"),
    UPDATE_EVENTS("UPDATE EVENTS SET NAME_EN=?, NAME_AR=?,"
            + "PLACE_EN=?, PLACE_AR=?, "
            + "EVENT_DATE=?, CAPACITY=?, EVENT_TYPE_ID=? "
            + "WHERE EVENT_ID=?"),
    INSERT_EVENT("INSERT INTO EVENTS (EVENT_ID, NAME_EN, NAME_AR, "
            + "PLACE_EN, PLACE_AR, EVENT_DATE, CAPACITY, EVENT_TYPE_ID)"
            + "VALUES((SELECT max(EVENT_ID) FROM EVENTS )+1, ?,?,?,?,?,?,?)"),
    DELETE_EVENT("DELETE FROM EVENTS WHERE EVENT_ID=?"),
    GET_LOGIN_INFO("SELECT USER_PASSWORD, G_NAME FROM V_USER_ROLE WHERE USER_NAME=?"),
    GET_USER_INFO("SELECT USER_ID, USER_NAME, USER_PASSWORD, FIRST_NAME, "
            + "LAST_NAME, USERS.GROUP_ID, USER_GROUPS.G_NAME "
            + "FROM USERS, USER_GROUPS WHERE "
            + "USERS.GROUP_ID= USER_GROUPS.GROUP_ID AND USER_ID=?");

    private String columnName;

    private EventsEnum(String columnName) {
        this.columnName = columnName;
    }

    @Override
    public String toString() {
        return columnName;
    }

}
