package br.eti.kinoshita.tests.sanselan;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.sanselan.Sanselan;

public class Error0 {

    // Hangs in Sanselan
    public static void main(String[] args) throws Exception {
        Path path = Paths.get("/home/kinow/Downloads/timeout-60d8a7dc3b0a1c34ce05f388e6fb7eb0f1a1c0f6");
        byte[] data = Files.readAllBytes(path);
        Sanselan.getBufferedImage(data);
    }
}
