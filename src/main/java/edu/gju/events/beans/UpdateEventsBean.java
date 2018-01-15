/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.gju.events.beans;

import edu.gju.events.daos.EventDAO;
import edu.gju.events.daos.EventDaoImpl;
import edu.gju.events.daos.EventTypeDAO;
import edu.gju.events.daos.EventTypeDaoImpl;
import edu.gju.events.models.Event;
import edu.gju.events.models.EventType;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.PostActivate;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author hesham
 */
@Named(value = "updateEventBean")
@ViewScoped
public class UpdateEventsBean implements Serializable {

    private List<EventType> typesList;
    private Map<Integer, EventType> eTypesMap;
    private Event event;
    private int selectedEventId;
    private int eventTypeId;
    private String eventTpyeNameEn;
    private String eventTypeNameAr;
    private EventDAO eventDao;
    private EventTypeDAO eTypeDao;
    @Inject
    private SessionBean sessionBean;

    public UpdateEventsBean() {
    }

    @PostConstruct
    public void init() {
        eventDao = new EventDaoImpl();
        eTypeDao = new EventTypeDaoImpl();
        event = new Event();
        selectedEventId = sessionBean.getSelectedItemId();
        try {
            typesList = eTypeDao.buildEventTypes();
            eTypesMap = eTypeDao.buildEventTypeMap();
            if (selectedEventId > 0) {
                event = eventDao.buildSelectedEvenet(selectedEventId);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UpdateEventsBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void insertNewEvent() {
        try {
            EventType type = new EventType();
            type.setTypeId(eventTypeId);
            eventTpyeNameEn = eTypesMap.get(eventTypeId).getNameEn();
            eventTypeNameAr = eTypesMap.get(eventTypeId).getNameAr();
            event.setType(type);
            eventDao.addEvent(event);

        } catch (SQLException ex) {
            Logger.getLogger(UpdateEventsBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void updateEvent() {
        try {
            EventType type = new EventType();
            type.setTypeId(eventTypeId);
            eventTpyeNameEn = eTypesMap.get(eventTypeId).getNameEn();
            eventTypeNameAr = eTypesMap.get(eventTypeId).getNameAr();
            event.setType(type);
            eventDao.updateEvent(event);
        } catch (SQLException ex) {
            Logger.getLogger(UpdateEventsBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<EventType> getTypesList() {
        return typesList;
    }

    public void setTypesList(List<EventType> typesList) {
        this.typesList = typesList;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public int getSelectedEventId() {
        return selectedEventId;
    }

    public void setSelectedEventId(int selectedEventId) {
        this.selectedEventId = selectedEventId;
    }

    public EventDAO getEventDao() {
        return eventDao;
    }

    public void setEventDao(EventDAO eventDao) {
        this.eventDao = eventDao;
    }

    public SessionBean getSessionBean() {
        return sessionBean;
    }

    public void setSessionBean(SessionBean sessionBean) {
        this.sessionBean = sessionBean;
    }

    public Map<Integer, EventType> geteTypesMap() {
        return eTypesMap;
    }

    public void seteTypesMap(Map<Integer, EventType> eTypesMap) {
        this.eTypesMap = eTypesMap;
    }

    public EventTypeDAO geteTypeDao() {
        return eTypeDao;
    }

    public void seteTypeDao(EventTypeDAO eTypeDao) {
        this.eTypeDao = eTypeDao;
    }

    public int getEventTypeId() {
        return eventTypeId;
    }

    public void setEventTypeId(int eventTypeId) {
        this.eventTypeId = eventTypeId;
    }

}
