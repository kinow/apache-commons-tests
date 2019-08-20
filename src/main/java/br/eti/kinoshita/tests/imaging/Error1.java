package br.eti.kinoshita.tests.imaging;

import java.io.File;

import org.apache.commons.imaging.common.bytesource.ByteSourceFile;
import org.apache.commons.imaging.formats.bmp.BmpImageParser;

public class Error1 {

    // Hangs in Imaging
    public static void main(String[] args) throws Exception {
        new BmpImageParser().dumpImageFile(
                new ByteSourceFile(new File("/home/kinow/Downloads/timeout-bd15dbfa26b4e88070de540c6603039e8a88626f")));
    }
}
