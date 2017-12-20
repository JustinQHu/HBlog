package com.huqijun.blog.util;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by huqijun on 11/22/2017.
 * Read/Write File Tools
 */
public class FileUtil {

    /**
     * read file content to a String  given a specified fileName
     * @param fileName
     * @return
     */
    public static String readToStr(String fileName) throws IOException {
        File file = new File(fileName);
        BufferedReader reader = null;

        try {
            reader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        String content = "";
        //read by line
        try {
            String tempString;
            while( (tempString = reader.readLine() ) != null)
            {
                content += tempString;
                content += "\n";
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        //System.out.println(content);
        reader.close();

        return content;
    }

    /**
     * read all files in the given path one by one,  each file content is put in a String
     * @param path
     * @return
     */
    public static List<String> readAll(String path) throws IOException {
        File file = new File(path);
        File[] array = file.listFiles();
        if(array.length == 0)
        {
            System.out.print( path + " has 0 file! ");
            return null;
        }

        List<String> ret = new ArrayList<String>();

        for(File f : array)
        {
            if(f.isFile())
            {
                ret.add( readToStr(f.getPath()) );
            }
            else if(f.isDirectory())
            {
                List<String> ls = readAll(f.getPath());
                ret.addAll(ls);
            }
        }
        return ret;
    }

}
