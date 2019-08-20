package br.eti.kinoshita.tests.sanselan;

import java.io.File;

import org.apache.sanselan.common.byteSources.ByteSourceFile;
import org.apache.sanselan.formats.jpeg.JpegImageParser;
import org.apache.sanselan.formats.jpeg.JpegUtils;

public class Error2 {

    // OK in Sanselan
    public static void main(String[] args) throws Exception {
        new JpegImageParser().dumpImageFile(
                new ByteSourceFile(new File("/home/kinow/Downloads/timeout-48eb4251935b4ca8b26d1859ea525c1b42ae0c78")));
        new JpegUtils().dumpJFIF(
                new ByteSourceFile(new File("/home/kinow/Downloads/timeout-48eb4251935b4ca8b26d1859ea525c1b42ae0c78"))
        );
        System.out.println("OK!");
    }
}
