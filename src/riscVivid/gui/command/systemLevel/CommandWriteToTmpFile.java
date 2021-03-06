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
package riscVivid.gui.command.systemLevel;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

import riscVivid.gui.command.Command;

public class CommandWriteToTmpFile implements Command
{

    private String txt; //in
    private File tmpFile; //out

    public File getTmpFile()
    {
        return tmpFile;
    }

    public CommandWriteToTmpFile(String txt)
    {
        this.txt = txt;
    }

    @Override
    public void execute()
    {
        try
        {
            tmpFile = File.createTempFile("_riscVividFile", ".s");
            BufferedWriter bw = new BufferedWriter(new FileWriter(tmpFile));
            bw.write(txt);
            bw.close();
        }
        catch (Exception e)
        {
            System.err.println(e.toString());
            e.printStackTrace();

        }
    }

}
