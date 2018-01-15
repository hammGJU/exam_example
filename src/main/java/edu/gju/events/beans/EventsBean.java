/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.gju.events.beans;

import edu.gju.events.daos.EventDAO;
import edu.gju.events.daos.EventDaoImpl;
import edu.gju.events.models.Event;
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
@Named(value = "eventBean")
@ViewScoped
public class EventsBean implements Serializable {

    private List<Event> eventsList;
    private Map<Integer, Event> eventsMap;
    private Event selectedEvent;
    private Event editEvent;
    private EventDAO eventDao;
    @Inject
    private SessionBean sessionBean;

    @PostConstruct
    @PostActivate
    public void init() {
        eventDao = new EventDaoImpl();
        editEvent = new Event();
        try {
            eventsList = eventDao.buildEvents();
        } catch (SQLException ex) {
            Logger.getLogger(EventsBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void deleteEvent() {
        try {
            eventDao.deleteEvent(selectedEvent.getEventId());
        } catch (SQLException ex) {
            Logger.getLogger(EventsBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void sendSelectedItemIdToSession() {
        sessionBean.setSelectedItemId(selectedEvent.getEventId());
        setEditEvent(selectedEvent);
    }

    public List<Event> getEventsList() {
        return eventsList;
    }

    public void setEventsList(List<Event> eventsList) {
        this.eventsList = eventsList;
    }

    public Map<Integer, Event> getEventsMap() {
        return eventsMap;
    }

    public void setEventsMap(Map<Integer, Event> eventsMap) {
        this.eventsMap = eventsMap;
    }

    public EventDAO getEventDao() {
        return eventDao;
    }

    public void setEventDao(EventDAO eventDao) {
        this.eventDao = eventDao;
    }

    public Event getSelectedEvent() {
        return selectedEvent;
    }

    public void setSelectedEvent(Event selectedEvent) {
        this.selectedEvent = selectedEvent;
    }

    public SessionBean getSessionBean() {
        return sessionBean;
    }

    public void setSessionBean(SessionBean sessionBean) {
        this.sessionBean = sessionBean;
    }

    public Event getEditEvent() {
        return editEvent;
    }

    public void setEditEvent(Event editEvent) {
        this.editEvent = editEvent;
    }

}
