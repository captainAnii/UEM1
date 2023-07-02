package com.geekster.UEM1.controller;

import com.geekster.UEM1.model.Event;
import com.geekster.UEM1.service.EventService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/events")
public class EventController {
    @Autowired
    private EventService eventService;

    @PostMapping(value = "/addEvent")
    public ResponseEntity<Event> addEvent(@Valid @RequestBody Event event) {
        Event savedEvent = eventService.addEvent(event);
        return ResponseEntity.ok(savedEvent);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateEvent(@PathVariable Integer id, @Valid @RequestBody Event event) {
        eventService.updateEvent(id, event);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEvent(@PathVariable Integer id) {
        eventService.deleteEvent(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping(value = "/getAllEvents")
    public ResponseEntity<List<Event>> getAllEvents() {
        List<Event> events = eventService.getAllEvents();
        return ResponseEntity.ok(events);
    }

    @GetMapping("/by-date")
    public ResponseEntity<List<Event>> getAllEventsByDate(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        List<Event> events = eventService.getAllEventsByDate(date);
        return ResponseEntity.ok(events);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Event> getEventById(@PathVariable Integer id) {
        Event event = eventService.getEventById(id);
        if (event == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(event);
        }
    }
}