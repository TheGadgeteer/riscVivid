/*******************************************************************************
 * riscVivid - A RISC-V processor simulator.
 * (C)opyright 2013-2016 The riscVivid project, University of Augsburg, Germany
 * https://github.com/unia-sik/riscVivid
 *
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program, see <LICENSE>. If not, see
 * <http://www.gnu.org/licenses/>.
 ******************************************************************************/
package riscVivid.util;

import java.io.File;
import java.io.FileFilter;

public class FileFinder implements FileFilter
{

    /**
     * returns an ArrayList of Directories within an other Directory, specified
     * by a parameter. *
     *
     * @param sourcePath the directories full path
     * @return an ArrayList<File> of Subfolders or nul if the File described by
     * path does not exist, or is no directory
     *
     */
    public File[] loadFiles(String sourcePath)
    {
        File dir = new File(sourcePath);
        if (dir.exists() && dir.isDirectory())
        {           
            return dir.listFiles(this);
        }
        return null;

    }

    @Override
    public boolean accept(File pathname)
    {
		// FIXME -> here a static string is used for path validation -> change this
        if (pathname.isFile() && pathname.getName().contains("riscVivid"))
        {
            return true;
        }
        return false;
    }

}
