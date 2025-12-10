package org.example.eventcontrollerpractice.controller;

import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.example.eventcontrollerpractice.model.Event;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;


@RestController
@RequestMapping("/api/events")
public class EventController {
    private List<Event> events = new ArrayList<>();

    //example database
    public EventController() {
        events.add(
                new Event(1L, "Spring Boot Workshop", "Online", LocalDate.of(2025, 1, 10))
        );

        events.add(
                new Event(2L, "Java Study Jam", "Istanbul", LocalDate.of(2025, 2, 5))
        );

        events.add(
                new Event(3L, "COMP301 Event", "Campus", LocalDate.of(2025, 3, 15))
        );
    }

    @GetMapping
    public ResponseEntity<List<Event>> getAllEvents() {
        return ResponseEntity.ok(events);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Event> getEventById(@PathVariable Long id) {
        for (Event event : events) {
            if (event.getId().equals(id)) {
                return ResponseEntity.ok(event);
            }
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Event> createEvent(@RequestBody Event event) {
        events.add(event);
        return ResponseEntity.status(HttpStatus.CREATED).body(event);
    }

    @DeleteMapping("/{id}")
    public void deleteEvent(@PathVariable Long id) {
        for (Event event : events) {
            if (event.getId().equals(id)) {
                events.remove(event);
                return;
            }
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Event> updateEvent(@PathVariable Long id, @RequestBody Event updatedEvent) {
        for (Event event : events) {
            if (event.getId().equals(id)) {
                event.setName(updatedEvent.getName());
                event.setLocation(updatedEvent.getLocation());
                event.setDate(updatedEvent.getDate());
                return ResponseEntity.ok(event);
            }
        }
        return ResponseEntity.notFound().build();

    }

}