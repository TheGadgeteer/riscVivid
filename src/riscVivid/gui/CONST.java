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
package riscVivid.gui;

import java.awt.Color;

public interface CONST
{
	static final String FETCH = "IF";
    static final String DECODE = "ID";
    static final String EXECUTE = "EX";
    static final String MEMORY = "MEM";
    static final String WRITEBACK = "WB";
    static final Color IF_COLOR = new Color(250, 251, 119);
    static final Color EX_COLOR = Color.RED;
    static final Color ID_COLOR = new Color(182, 115, 8);
    static final Color WB_COLOR = Color.LIGHT_GRAY;
    static final Color MEM_COLOR = Color.GREEN;

    /*current state of the program
     LAZY = no riscVividSim loaded
     EXECUTING = riscVividSim loaded 
     RUNNING = riscVividSim in step through loop */
    public enum OpenDLXSimulatorState
    {

        RUNNING, LAZY, EXECUTING
    }
}
