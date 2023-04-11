package com.hojun.sg.bus.repository;

import com.hojun.sg.bus.repository.entity.Station;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StationRepository  extends JpaRepository<Station, String>
{}
