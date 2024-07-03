 package com.ubuntuconnect.ubuntu_connect.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ubuntuconnect.ubuntu_connect.model.Patient;

public interface PatientRepo extends JpaRepository<Patient,Integer>{

}
