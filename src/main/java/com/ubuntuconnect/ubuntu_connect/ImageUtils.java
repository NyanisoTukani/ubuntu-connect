package com.ubuntuconnect.ubuntu_connect;

import java.util.Base64;

public class ImageUtils {
    public static String convertToBase64(byte[] doctorImage) {
        return Base64.getEncoder().encodeToString(doctorImage);
    }
}