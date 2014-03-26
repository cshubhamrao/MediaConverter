/*
 * Copyright (C) 2014 Shubham Rao <cshubhamrao@gmail.com>
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

import org.apache.commons.exec.OS;

/** This class contains various utilities to deal with OS Dependent issues like 
 * OS Name, location of JAR file etc.
 *
 * @version 1.0.2
 * @author Shubham Rao
 */
public class OSUtils {
    
    /** This enumeration contains a list of popular Operating Systems
     * 
     * @version 1.0.1
     * @since 1.0.0
     */
    public static enum OperatingSystem {
        /** This constant represents Linux and/or any of its derivatives like
         * Debian, Fedora, Ubuntu, openSUSE etc
         * @version 1.0.0
         * @since 1.0.0
         */
        LINUX,
        
        /** This constant represents MacOS and Mac OSX and any of its versions
         * @version 1.0.0
         * @since 1.0.0
         */
        MAC,

        /** This constant represents Windows operating System and any of its
         * versions. It excludes old versions such as WindowsNT and MS-DOS
         * @version 1.0.0
         * @since 1.0.0
         */
        WINDOWS,

        /** This constant represents and OS which is not any one of the above or
         * cannot be ascertained.
         * @version 1.0.0
         * @since 1.0.1
         */
        UNKNOWN
    }
    
    /** This method returns a member of {@link #OperatingSystem} representing
     * the Operating System this JAR is running from.
     *
     * @version 1.0.0
     * @since 1.0.2
     * @return The current Operating System
     */
    public static OperatingSystem getCurrentOS() {
        OperatingSystem currentOS = OperatingSystem.UNKNOWN;
        if (OS.isFamilyUnix()) currentOS = OperatingSystem.LINUX;
        if (OS.isFamilyMac()) currentOS = OperatingSystem.MAC;
        if (OS.isFamilyWindows()) currentOS = OperatingSystem.WINDOWS;
        return currentOS;
    }
}