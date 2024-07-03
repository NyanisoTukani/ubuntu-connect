package com.ubuntuconnect.ubuntu_connect.Controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;

import com.ubuntuconnect.ubuntu_connect.doctorservice.DoctorService;
import com.ubuntuconnect.ubuntu_connect.model.Doctor;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;








@Controller
public class UbuntuConnectController {
    
    @Autowired
    private DoctorService doctorService;

    
    
    @GetMapping("/")
    public String welcomePage() {
        return  "index";
    }
    

    @GetMapping("/doctors")
    public String goToDoctors(Model model) {
        List<Doctor> doctors = doctorService.getAllDoctors();
        model.addAttribute("doctors", doctors);
        return  "doctors";
    }
    

    @PostMapping("/search")
    public String searchDoctor(@RequestParam("search") String doctorname,Model model) {
        Doctor doc = new Doctor();
        doc = doctorService.getDoctor(doctorname);
        model.addAttribute("doctor", doc);
        return "search-doctor";
    }
    
    
    @GetMapping("/appointment")
    public String appointmentPage(Model model) {
        List<Doctor> doctors = doctorService.getAllDoctors();
        model.addAttribute("doctors", doctors);
        return  "appointment";
    }

    
    @GetMapping("/adddoctor")
    public String addDocotorPage() {
        return "add_doctors";
    }
    
    @PostMapping("/adddoctor")
    public String addDoctors(@RequestParam("doctorname") String doctorName,
                                 @RequestParam("doctoraddress") String doctorAddress,
                                 @RequestParam("doctorspecializes") String doctorSpecializes,
                                 @RequestParam("doctorimage") MultipartFile doctorImage,
                                 RedirectAttributes redirectAttributes)  {

                                  Doctor doctor =new Doctor();
                                  doctor.setDoctorName(doctorName);
                                  doctor.setDoctorAddress(doctorAddress);
                                  doctor.setDoctorSpecialize(doctorSpecializes);
                                  
                                  try {
                                    doctorService.saveDoctor(doctor,doctorImage);
                                    System.out.println("DOCTOR HAS BEEN  ADDED TO DATABASE");
                                } catch (IOException e) {
                                    
                                    System.out.println("DOCTOR NOT ADDED TO DATABASE");
                                    e.printStackTrace();
                                }
                                return "redirect:/adddoctor"; 
                            }

    @ExceptionHandler(MaxUploadSizeExceededException.class)
    public String handleMaxSizeException(RedirectAttributes redirectAttributes) {
    redirectAttributes.addFlashAttribute("message", "File too large!");
    return "redirect:/adddoctor";

    }

    
    
    
   
    
}
