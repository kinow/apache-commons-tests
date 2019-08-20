package br.eti.kinoshita.tests.imaging;

import java.io.File;
import java.util.Collections;

import org.apache.commons.imaging.common.bytesource.ByteSourceFile;
import org.apache.commons.imaging.formats.rgbe.RgbeImageParser;

public class Error3 {

    // Hangs in Imaging
    public static void main(String[] args) throws Exception {
        new RgbeImageParser().getBufferedImage(
                new ByteSourceFile(new File("/home/kinow/Downloads/timeout-9713502c9c371f1654b493650c16ab17c0444369")),
                Collections.<String, Object>emptyMap());
    }
}
