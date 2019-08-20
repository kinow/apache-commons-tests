package br.eti.kinoshita.tests.imaging;

import java.io.File;

import org.apache.commons.imaging.common.bytesource.ByteSourceFile;
import org.apache.commons.imaging.formats.jpeg.decoder.JpegDecoder;

public class Error2 {

    // Takes a bit long in Imaging
    public static void main(String[] args) throws Exception {
        new JpegDecoder().decode(
                new ByteSourceFile(new File("/home/kinow/Downloads/timeout-48eb4251935b4ca8b26d1859ea525c1b42ae0c78")));
    }
}
