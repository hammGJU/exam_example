/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.gju.events.daos;

import edu.gju.events.models.EventType;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 *
 * @author hesham
 */
public interface EventTypeDAO {

    List<EventType> buildEventTypes() throws SQLException;

    Map<Integer, EventType> buildEventTypeMap() throws SQLException;

}
