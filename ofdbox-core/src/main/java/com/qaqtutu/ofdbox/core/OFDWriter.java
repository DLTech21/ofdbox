package com.qaqtutu.ofdbox.core;

import org.apache.tools.zip.ZipEntry;
import org.apache.tools.zip.ZipFile;
import org.apache.tools.zip.ZipOutputStream;

import java.io.*;

public class OFDWriter {

    public static void write(OFD ofd,File file){
        System.out.println(file);

        try {
            OutputStream out = new FileOutputStream(file);
            BufferedOutputStream bos = new BufferedOutputStream(out);
            ZipOutputStream zipOutputStream = new ZipOutputStream(bos);
            ofd.getFileManager().files().forEach(f->{
                String path=f.substring(f.indexOf("/")+1);
                ZipEntry zipEntry=new ZipEntry(path);

//                System.out.println(path);
                try {
                    zipOutputStream.putNextEntry(zipEntry);
                    zipOutputStream.write(ofd.getFileManager().readBytes(f));
                } catch (IOException e) {
                    e.printStackTrace();
                }
//                System.out.println(f);
            });

            zipOutputStream.closeEntry();
            zipOutputStream.close();
            bos.close();
            out.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        ofd.getFileManager().files().forEach(f->{
//            System.out.println(f);
        });
    }
}
