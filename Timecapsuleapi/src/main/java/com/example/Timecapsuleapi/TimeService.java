package com.example.Timecapsuleapi;

import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class TimeService {
    private  final TimeRepository repo;

    public TimeService(TimeRepository repo)
    {
        this.repo=repo;
    }
    public Time add(Time time)
    {
        return repo.save(time);
    }
    public List<Time> getAll()
    {
        return repo.findAll();
    }
    public Time getOne(Long Id)
    {
        return repo.findById(Id).orElse(null);
    }
    public void delete(Long Id)
    {
        repo.deleteById(Id);
    }
}
