package com.ubuntuconnect.ubuntu_connect.doctorservice;

import java.io.IOException;
import java.util.List;
import java.util.Optional;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ubuntuconnect.ubuntu_connect.model.Doctor;
import com.ubuntuconnect.ubuntu_connect.repository.DoctorRepo;
@Service
public class DoctorService {

    @Autowired
    private DoctorRepo doctorRepo;

    public List<Doctor> getAllDoctors(){
            return doctorRepo.findAll();
    }
    public Doctor saveDoctor(Doctor doctor,MultipartFile file) throws IOException{
        if(file != null && !file.isEmpty())
        {
            doctor.setDoctorImage(file.getBytes());
        }
        return doctorRepo.save(doctor);
    }
    

    public Doctor getDoctor(String doctorname){
      
        Optional<Doctor> optionalDoctor = doctorRepo.findById(doctorname);
        if(optionalDoctor.isPresent()){
            return optionalDoctor.get();
        }else{
            throw new RuntimeException("Doctor with name "+doctorname+" not found");
        }
    }
    public void deleteDoctor(String doctorname){
        doctorRepo.deleteById(doctorname);;
    }
}
