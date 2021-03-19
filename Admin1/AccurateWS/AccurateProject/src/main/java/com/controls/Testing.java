package com.controls;

import java.io.File;

public class Testing
{
    public static void main(String[] args) {
        File file = new File(System.getProperty("user.dir")+"\\downloads\\documents.zip");

        if (file.exists() && file.isFile()) {
            System.out.println("file downloaded successfully");
            double fileSize = file.length() / 1024;
            System.out.println("file size  " + fileSize);
            System.out.println(file.getName());
        }
//            if (fileSize>50)
//                present = true;
//            else
//                present=false;
//            file.delete();
    }
}
