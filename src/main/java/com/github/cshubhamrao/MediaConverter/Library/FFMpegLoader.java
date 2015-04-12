/*
 * Copyright (C) 2015 Shubham
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

import com.github.cshubhamrao.MediaConverter.Library.OSUtils.OperatingSystem;
import com.github.cshubhamrao.MediaConverter.MainUI;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.tukaani.xz.XZInputStream;

/**
 * This class extracts the compressed ffmpeg executable, decompresses it 
 * and stores it in %temp%
 *
 * @author Shubham
 * @version 1.0.0
 */
public class FFMpegLoader implements Runnable {
    
    /* Filenames of executables to use for each platform. Edit here if file 
       renamed/moved
    */
    static final String WINDOWS_FFMPEG = "ffmpeg.exe.xz";
    static final String LINUX_FFMPEG = "ffmpeg.xz";

    static File ffmpegExecutable;

    @Override
    public void run() {
        
        String ffmpegResource = "";
        
        switch(OSUtils.getCurrentOS())
        {
            case WINDOWS:
                ffmpegResource = WINDOWS_FFMPEG;
                break;
                
            case LINUX:
                ffmpegResource = LINUX_FFMPEG;
                break;
        }
        
        try {
            // Created file will be MediaConverter<some numbers>.exe
            ffmpegExecutable = File.createTempFile("MediaConverter", ".exe");
            ffmpegExecutable.deleteOnExit();
        } catch (IOException ex) {
            Logger.getLogger(FFMpegLoader.class.getName()).log(Level.SEVERE, null, ex);
        }

        try (
                OutputStream decompressedFFMpeg = new FileOutputStream(ffmpegExecutable);
                InputStream rawFFMpeg = MainUI.class.getClassLoader()
                        .getResourceAsStream(ffmpegResource);
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
    
    /**
     *  
     *
     * @return a {@link java.io.File} object for the executable, <code>null</code>
     *         if executable couldn't be created.
     */
    public static File getFFMpegExecutable() {
        if (ffmpegExecutable != null) return ffmpegExecutable;
        else return null;
    }
    
}
