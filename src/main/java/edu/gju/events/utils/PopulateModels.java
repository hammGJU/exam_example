/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.gju.events.utils;

import edu.gju.events.models.Event;
import edu.gju.events.models.EventType;
import edu.gju.events.models.Group;
import edu.gju.events.models.User;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author hesham
 */
public class PopulateModels {

    public static EventType populateEventType(ResultSet rs) throws SQLException {
        EventType eventType = new EventType();
        eventType.setTypeId(rs.getInt(EventsEnum.EVENT_TYPE_ID.toString()));
        eventType.setNameEn(rs.getString(EventsEnum.EVENT_TYPE_NAME_EN.toString()));
        eventType.setNameAr(rs.getString(EventsEnum.EVENT_TYPE_NAME_AR.toString()));
        return eventType;
    }

    public static Event populateEvent(ResultSet rs) throws SQLException {
        Event event = new Event();
        event.setEventId(rs.getInt(EventsEnum.EVENT_ID.toString()));
        event.setNameEn(rs.getString(EventsEnum.EVENT_NAME_EN.toString()));
        event.setNameAr(rs.getString(EventsEnum.EVENT_NAME_AR.toString()));
        event.setPlaceEn(rs.getString(EventsEnum.EVENT_PALCE_EN.toString()));
        event.setPlaceAr(rs.getString(EventsEnum.EVENT_PLACE_AR.toString()));
        event.setCapacity(rs.getInt(EventsEnum.EVENT_CAPACITY.toString()));
        event.setEventDate(rs.getDate(EventsEnum.EVENT_DATE.toString()));
        EventType type = new EventType();
        type.setTypeId(rs.getInt(EventsEnum.EVENT_TYPE_ID.toString()));
        type.setNameEn(rs.getString(EventsEnum.V_EVENT_TYPE_NAME_EN.toString()));
        type.setNameAr(rs.getString(EventsEnum.V_EVENT_TYPE_NAME_AR.toString()));
        event.setType(type);
        return event;
    }

    public static User populateUser(ResultSet rs) throws SQLException {
        User user = new User();
        user.setUserId(rs.getInt(EventsEnum.USER_ID.toString()));
        user.setFirstName(rs.getString(EventsEnum.FIRST_NAME.toString()));
        user.setLastName(rs.getString(EventsEnum.LAST_NAME.toString()));
        user.setUserName(rs.getString(EventsEnum.USER_NAME.toString()));
        user.setUserPassword(rs.getString(EventsEnum.USER_PASSWORD.toString()));
        Group group = new Group();
        group.setGroupId(rs.getInt(EventsEnum.GROUP_ID.toString()));
        group.setGroupName(rs.getString(EventsEnum.GROUP_NAME.toString()));
        user.setUserGroup(group);
        return user;
    }

}
