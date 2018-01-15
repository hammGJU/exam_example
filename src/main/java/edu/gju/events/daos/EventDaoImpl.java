/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.gju.events.daos;

import edu.gju.events.models.Event;
import edu.gju.events.models.EventType;
import edu.gju.events.utils.EventsEnum;
import edu.gju.events.utils.PopulateModels;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author hesham
 */
public class EventDaoImpl extends ConnectionDaoImpl implements EventDAO, Serializable {

    @Override
    public List<Event> buildEvents() throws SQLException {
        List<Event> events = new ArrayList<>();
        Connection connection = retrieveConnection();
        PreparedStatement ps = connection.prepareStatement(EventsEnum.GET_EVENTS.toString());
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            events.add(PopulateModels.populateEvent(rs));
        }
        return events;
    }

    @Override
    public Map<Integer, Event> buildEventMap() throws SQLException {
        Map<Integer, Event> eventMap = new HashMap<>();
        Connection connection = retrieveConnection();
        PreparedStatement ps = connection.prepareStatement(EventsEnum.GET_EVENTS.toString());
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Event event = PopulateModels.populateEvent(rs);
            eventMap.put(event.getEventId(), event);
        }
        return eventMap;
    }

    @Override
    public int updateEvent(Event event) throws SQLException {
        Connection connection = retrieveConnection();
        PreparedStatement ps = connection.prepareStatement(EventsEnum.UPDATE_EVENTS.toString());
        ps.setString(1, event.getNameEn());
        ps.setString(2, event.getNameAr());
        ps.setString(3, event.getPlaceEn());
        ps.setString(4, event.getPlaceAr());
        ps.setTimestamp(5, new Timestamp(event.getEventDate().getTime()));
        ps.setInt(6, event.getCapacity());
        ps.setInt(7, event.getType().getTypeId());
        ps.setInt(8, event.getEventId());
        int result = ps.executeUpdate();
        return result;
    }

    @Override
    public int addEvent(Event event) throws SQLException {
        Connection connection = retrieveConnection();
        PreparedStatement ps = connection.prepareStatement(EventsEnum.INSERT_EVENT.toString());
        ps.setString(1, event.getNameEn());
        ps.setString(2, event.getNameAr());
        ps.setString(3, event.getPlaceEn());
        ps.setString(4, event.getPlaceAr());
        ps.setTimestamp(5, new Timestamp(event.getEventDate().getTime()));
        ps.setInt(6, event.getCapacity());
        ps.setInt(7, event.getType().getTypeId());
        int result = ps.executeUpdate();
        return result;
    }

    @Override
    public int deleteEvent(int eventId) throws SQLException {
        Connection connection = retrieveConnection();
        PreparedStatement ps = connection.prepareStatement(EventsEnum.DELETE_EVENT.toString());
        ps.setInt(1, eventId);
        int result = ps.executeUpdate();
        return result;
    }

    @Override
    public Event buildSelectedEvenet(int eventId) throws SQLException {
        Connection connection = retrieveConnection();
        Event event = new Event();
        PreparedStatement ps = connection.prepareStatement(EventsEnum.FETCH_EVENT.toString());
        ps.setInt(1, eventId);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            event = PopulateModels.populateEvent(rs);

        }
        return event;
    }

}
