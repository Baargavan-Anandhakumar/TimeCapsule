package com.example.Timecapsuleapi;

import org.springframework.web.bind.annotation.*;
import java.util.*;
@RestController
@RequestMapping("/Time")
public class TimeController {

    private final TimeService service;

    public TimeController(TimeService service) {
        this.service = service;
    }

    @PostMapping
    public Time add(@RequestBody Time time) {
        return service.add(time);
    }
    @PostMapping("/form")
    public Time add(@RequestParam String title,@RequestParam int year,@RequestParam String message,@RequestParam String createdBy){
        Time time = new Time();
        time.setTitle(title);
        time.setMessage(message);
        time.setYear(year);
        time.setCreatedBy(createdBy);
        return service.add(time);

    }
    @GetMapping
    public List<Time> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Time getOne(@PathVariable Long id) {
        return service.getOne(id);
    }

    @DeleteMapping("/del/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
