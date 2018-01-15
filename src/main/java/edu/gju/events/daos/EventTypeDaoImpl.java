/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.gju.events.daos;

import edu.gju.events.models.EventType;
import edu.gju.events.utils.EventsEnum;
import edu.gju.events.utils.PopulateModels;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author hesham
 */
public class EventTypeDaoImpl extends ConnectionDaoImpl implements EventTypeDAO, Serializable {

    @Override
    public List<EventType> buildEventTypes() throws SQLException {
        List<EventType> types = new ArrayList<>();
        Connection connection = retrieveConnection();
        PreparedStatement ps = connection.prepareStatement(EventsEnum.GET_EVENT_TYPES.toString());
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            EventType et = new EventType();
            et = PopulateModels.populateEventType(rs);
            types.add(et);
        }
        return types;
    }

    @Override
    public Map<Integer, EventType> buildEventTypeMap() throws SQLException {
        Map<Integer, EventType> typesMap = new HashMap<>();
        Connection connection = retrieveConnection();
        PreparedStatement ps = connection.prepareStatement(EventsEnum.GET_EVENT_TYPES.toString());
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            EventType type = PopulateModels.populateEventType(rs);
            typesMap.put(type.getTypeId(), type);
        }
        return typesMap;
    }

}
