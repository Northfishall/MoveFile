package Service;


import android.content.Context;
import android.os.Environment;

import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

public class service {

    public static boolean saveMsg(Context context, String msg, String filename) {
        File file = new File(context.getFilesDir(), filename);
        try {
            FileOutputStream fos = new FileOutputStream(file);
            fos.write(msg.getBytes());
            fos.flush();
            fos.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean copyMsg(Context context, String filename, String sdfilename) {
        File file = new File(context.getFilesDir(), filename);
        try {
            FileInputStream fis = new FileInputStream(file);
            BufferedReader br = new BufferedReader(new InputStreamReader(fis));
            if (Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())) {
                File sdfile = new File(Environment.getExternalStorageDirectory(), sdfilename);
                FileOutputStream fos = new FileOutputStream(sdfile);
                String ln = br.readLine();
                //Toast.makeText(context, "111", Toast.LENGTH_SHORT).show();
                while (ln != null) {
                    //Toast.makeText(context, ln, Toast.LENGTH_SHORT).show();
                    fos.write(ln.getBytes());
                    ln = br.readLine();
                }
                fos.flush();
                fos.close();
                return true;
            } else {
                Toast.makeText(context, "sdcard被卸载", Toast.LENGTH_SHORT).show();
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(context, "出现异常", Toast.LENGTH_SHORT).show();
            return false;
        }
    }
}
