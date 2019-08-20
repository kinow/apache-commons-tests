package br.eti.kinoshita.tests.imaging;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.sanselan.Sanselan;


public class Fuzz1 {

    public static void main(String[] args) throws Exception {
        Path path = Paths.get("/tmp/timeout-60d8a7dc3b0a1c34ce05f388e6fb7eb0f1a1c0f6");
        byte[] data = Files.readAllBytes(path);
        Sanselan.getBufferedImage(data);
    }
}
