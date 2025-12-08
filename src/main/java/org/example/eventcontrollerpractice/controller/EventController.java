package org.example.eventcontrollerpractice.controller;

import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.example.eventcontrollerpractice.model.Event;

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
    public List<Event> getAllEvents() {
        return events;
    }

    @GetMapping("/{id}")
    public Event getEventById(@PathVariable Long id) {
        for (Event event : events) {
            if (event.getId().equals(id)) {
                return event;
            }
        }
        return null;
    }

    @PostMapping
    public Event createEvent(@RequestBody Event event) {
        events.add(event);
        return event;
    }
}