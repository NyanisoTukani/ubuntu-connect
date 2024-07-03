package com.ubuntuconnect.ubuntu_connect.doctorservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ubuntuconnect.ubuntu_connect.model.Patient;
import com.ubuntuconnect.ubuntu_connect.repository.PatientRepo;

@Service
public class PatientService {

    @Autowired
    PatientRepo patientRepo;

    public void addPatient(Patient patient){
        patientRepo.save(patient);
    }

}
