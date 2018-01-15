/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.gju.events.daos;

import edu.gju.events.models.Event;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 *
 * @author hesham
 */
public interface EventDAO {

    public List<Event> buildEvents() throws SQLException;

    public Map<Integer, Event> buildEventMap() throws SQLException;

    public Event buildSelectedEvenet(int eventId) throws SQLException;

    public int updateEvent(Event event) throws SQLException;

    public int addEvent(Event event) throws SQLException;

    public int deleteEvent(int eventId) throws SQLException;

}
