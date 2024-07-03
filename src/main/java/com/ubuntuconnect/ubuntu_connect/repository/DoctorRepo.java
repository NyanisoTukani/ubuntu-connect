package com.ubuntuconnect.ubuntu_connect.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ubuntuconnect.ubuntu_connect.model.Doctor;

public interface DoctorRepo extends JpaRepository<Doctor,String>{

}
