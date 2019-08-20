package br.eti.kinoshita.tests.sanselan;

import java.io.File;

import org.apache.sanselan.common.byteSources.ByteSourceFile;
import org.apache.sanselan.formats.bmp.BmpImageParser;

public class Error1 {

    // Hangs in Sanselan
    public static void main(String[] args) throws Exception {
        new BmpImageParser().dumpImageFile(
                new ByteSourceFile(new File("/home/kinow/Downloads/timeout-bd15dbfa26b4e88070de540c6603039e8a88626f")));
    }
}
