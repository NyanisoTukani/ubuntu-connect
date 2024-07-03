package com.ubuntuconnect.ubuntu_connect.model;

import com.ubuntuconnect.ubuntu_connect.ImageUtils;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Doctor {
    
    
    @Id
    private String doctorName;
    
    @Lob
    @Column(columnDefinition = "LONGBLOB")
    private byte[] doctorImage;


    @Column
    private String doctorAddress;

    @Column
    private String doctorSpecialize; 


    public String getDoctorImageAsBase64() {
        return ImageUtils.convertToBase64(this.doctorImage);
    }

}
