package com.ubuntuconnect.ubuntu_connect.Controller;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ubuntuconnect.ubuntu_connect.doctorservice.PatientService;
import com.ubuntuconnect.ubuntu_connect.model.Patient;

@Controller
public class PatientController {

    @Autowired
    PatientService patientService;

    @PostMapping("/book")
    public String postPatient(@RequestParam("city") String city,
                                @RequestParam("hospital") String hospital,
                                @RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date,
                                @RequestParam("doctorname") String doctorname,
                                @RequestParam(value = "consultation", required = false) String services,
                                @RequestParam("firstname") String firstname,
                                @RequestParam("lastname") String lastname,
                                @RequestParam("email") String email,
                                @RequestParam("phonenumber") long phonenumber,
                              @RequestParam("time") LocalTime time)
                               {

                                Patient patient = new Patient();
                                patient.setCity(city);
                                patient.setHospital(hospital);
                                patient.setDate(date);
                                patient.setDoctorName(doctorname);
                                patient.setService(services);
                                patient.setFirstName(firstname);
                                patient.setLastName(lastname);
                                patient.setEmail(email);
                                patient.setPhonenumber(phonenumber);
                                patient.setTime(time);

                                patientService.addPatient(patient);
                                System.out.println("Booking Submitted");

                                return "booking-submitted";




       
    }

}
