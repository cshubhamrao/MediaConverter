/*
 * Copyright (C) 2014 Shubham
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.github.cshubhamrao.MediaConverter.Library;

import com.github.cshubhamrao.MediaConverter.MainUI;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.tukaani.xz.XZInputStream;

/**
 * This class extracts the ffmpeg executable from .jar file and stores it in
 * %temp%
 *
 * @author Shubham
 */
public class FFMpegLoader implements Runnable {

    File ffmpegExecutable;
    private final String ffmpegRoot = "com/github/cshubhamrao/MediaConverter/FFMpeg/";

    @Override
    public void run() {
        try {
            ffmpegExecutable = File.createTempFile("MediaConverter", ".exe");
            ffmpegExecutable.deleteOnExit();
        } catch (IOException ex) {
            Logger.getLogger(FFMpegLoader.class.getName()).log(Level.SEVERE, null, ex);
        }

        try (
                OutputStream decompressedFFMpeg = new FileOutputStream(ffmpegExecutable);
                InputStream rawFFMpeg = MainUI.class.getClassLoader()
                        .getResourceAsStream(ffmpegRoot + "ffmpeg.exe.xz");
                XZInputStream compressedFFMpeg = 
                        new XZInputStream(rawFFMpeg) 
            ) {
            int read = 0;
            byte[] bytes = new byte[1024];
            while ((read = compressedFFMpeg.read(bytes)) != -1) {
                decompressedFFMpeg.write(bytes, 0, read);
            }
        } catch (IOException e) {
            System.out.println(e.getLocalizedMessage());
        }

    }
}
