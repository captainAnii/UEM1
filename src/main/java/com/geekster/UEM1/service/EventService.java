package com.geekster.UEM1.service;

import com.geekster.UEM1.model.Event;
import com.geekster.UEM1.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class EventService {
    @Autowired
    private EventRepository eventRepository;

    public Event addEvent(Event event) {
        return eventRepository.save(event);
    }

    public void updateEvent(Integer id, Event event) {
        Optional<Event> optionalEvent = eventRepository.findById(id);
        if (optionalEvent.isPresent()) {
            Event existingEvent = optionalEvent.get();
            existingEvent.setName(event.getName());
            existingEvent.setLocation(event.getLocation());
            existingEvent.setDate(event.getDate());
            existingEvent.setStartTime(event.getStartTime());
            existingEvent.setEndTime(event.getEndTime());
            eventRepository.save(existingEvent);
        }
    }

    public void deleteEvent(Integer id) {
        eventRepository.deleteById(id);
    }

    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    public List<Event> getAllEventsByDate(LocalDate date) {
        return eventRepository.findByDate(date);
    }

    public Event getEventById(Integer id) {
        Optional<Event> optionalEvent = eventRepository.findById(id);
        if (optionalEvent.isPresent()) {
            return optionalEvent.get();
        } else {
            return null;
        }
    }
}