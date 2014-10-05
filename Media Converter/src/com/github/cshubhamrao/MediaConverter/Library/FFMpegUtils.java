/*
 * Copyright (C) 2014 Shubham Rao
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

import java.io.File;
import java.util.HashMap;
import org.apache.commons.exec.CommandLine;

/**
 * This class contains various methods and fields dealing with FFMpeg and its
 * executable
 *
 * @version 1.1.1
 * @author Shubham Rao
 */
public class FFMpegUtils {

    /**
     * This field contains the {@link java.io.File} object representing the path
     * to the executable of FFMpeg. Its default value (ie. the value unaltered
     * by any statement or method) represents the folder where architecture
     * dependent FFMpeg executables are stored.
     *
     * @since 1.0.0
     */
    public static File FFMPEG_EXECUTABLE = new File(OSUtils.getJarLocation()
            .getParent(), "FFMpeg/");

    /**
     * This method sets {@code FFMPEG_EXECUTABLE} based on the value of {@code
     * currentOS}
     *
     * @since 1.0.1
     * @param OS The OS for which to set the executable.
     * @return The {@code File} object for {@code FFMPEG_EXECUTABLE}
     */
    public static File setFFMpegExecutable(OSUtils.OperatingSystem OS) {
        File ffmpegExecutable = FFMpegUtils.FFMPEG_EXECUTABLE;
        switch (OS) {
            case LINUX:
                ffmpegExecutable = new File(FFMPEG_EXECUTABLE, "/ffmpeg.bin");
                break;
            case MAC:
                ffmpegExecutable = new File(FFMPEG_EXECUTABLE, "/ffmpeg");
                break;
            case WINDOWS:
                ffmpegExecutable = new File(FFMPEG_EXECUTABLE, "/ffmpeg.exe");
                break;
        }
        return ffmpegExecutable;
    }

    /**
     * This method sets {@code FFMPEG_EXECUTABLE} based on the current Operating
     * System.
     *
     * @since 1.0.1
     * @return The {@code File} object for {@code FFMPEG_EXECUTABLE}
     */
    public static File setFFMpegExecutable() {
        FFMPEG_EXECUTABLE = FFMpegUtils.setFFMpegExecutable(OSUtils
                .getCurrentOS());
        return FFMpegUtils.FFMPEG_EXECUTABLE;
    }

    /**
     * Builds a {@link org.apache.commons.exec#CommandLine} based on the
     * parameters.
     *
     * @param inputFile The source File;
     * @param outputFile The output File
     * @param overwrite Whether or not to overwrite the file if it already
     * exists
     * @return The complete CommandLine
     *
     * @since 1.1.1
     */
    public static CommandLine buildFFMpegExecutable(File inputFile,
            File outputFile, boolean overwrite) {
        CommandLine commandLine = new CommandLine(
                "C:/Users/Shubham/Documents/GitHub/MediaConverter/FFMpeg/ffmpeg.exe");
        if (overwrite) {
            commandLine.addArgument("-y");
        }
        String[] arguments = {
            "-i",
            "${INPUT}",
            "${OUTPUT}"
        };
        HashMap<String, String> map = new HashMap<>();
        map.put("INPUT", inputFile.getPath());
        map.put("OUTPUT", outputFile.getPath());
        commandLine.addArguments(arguments, false);
        commandLine.setSubstitutionMap(map);
        return commandLine;
    }

    /**
     * Builds a {@link org.apache.commons.exec#CommandLine} based on the
     * parameters.
     *
     * @param inputFile The source File;
     * @param outputFile The output File
     * @return The complete CommandLine
     *
     * @since 1.1.1
     */
    public static CommandLine buildFFMpegExecutable(File inputFile,
            File outputFile) {
        return FFMpegUtils.buildFFMpegExecutable(inputFile, outputFile, true);
    }
}
