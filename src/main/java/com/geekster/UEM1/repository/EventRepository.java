package com.geekster.UEM1.repository;

import com.geekster.UEM1.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<Event, Integer> {
    List<Event> findAllByDate(LocalDate date);

    List<Event> findByDate(LocalDate date);

}