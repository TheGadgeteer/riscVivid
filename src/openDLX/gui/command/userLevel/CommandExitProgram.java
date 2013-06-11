/*******************************************************************************
 * openDLX - A DLX/MIPS processor simulator.
 * Copyright (C) 2013 The openDLX project, University of Augsburg, Germany
 * Project URL: <http://sourceforge.net/projects/opendlx>
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
package openDLX.gui.command.userLevel;

import java.io.File;
import java.util.prefs.BackingStoreException;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import openDLX.config.GlobalConfig;
import openDLX.gui.MainFrame;
import openDLX.gui.Preference;
import openDLX.gui.command.Command;
import openDLX.gui.command.systemLevel.CommandSaveFrameConfigurationSysLevel;

public class CommandExitProgram implements Command
{

    private MainFrame mf;

    public CommandExitProgram(MainFrame mf)
    {
        this.mf = mf;
    }
    
    @Override
    public void execute()
    {
    	if(close())
    	{
    		System.exit(0);
    	}
    }
    
    public boolean close()
    {

   		System.out.println("ShowExit is: " + Preference.pref.getBoolean(Preference.showExitMessage, true));
    	if(Preference.pref.getBoolean(Preference.showExitMessage, true))
    	{
    		String exit_message = "Are you sure you want to exit?";
    		JCheckBox exit_checkbox = new JCheckBox("Do not show this message again.");
    		Object content[] = {exit_message, exit_checkbox};
    		int result = JOptionPane.showConfirmDialog(
    				mf,
    				content,
    				"Exit openDLX "+ GlobalConfig.VERSION,
    				JOptionPane.YES_NO_OPTION);
    		
    		if (result != JOptionPane.YES_OPTION)
    		{
    			return false;
    		}
    		
    		Preference.pref.putBoolean(Preference.showExitMessage, !exit_checkbox.isSelected());
    	}

    	try
		{
    		// push preferences to persistent store
			Preference.pref.flush();
		} catch (BackingStoreException e)
		{
			System.err.println("Could not save preferences.");
			e.printStackTrace();
		}

    	// delete temporary files
    	String tmp = System.getProperty("java.io.tmpdir");
    	File f = new File(tmp);
    	File allFiles[] = f.listFiles();
    	for (int i = 0; i < allFiles.length; ++i)
    	{
    		// FIXME -> static name used!
    		if (allFiles[i].getName().contains("openDLX"))
    		{
    			allFiles[i].deleteOnExit();
    		}
    	}

    	//save current window position
    	CommandSaveFrameConfigurationSysLevel c11 = new CommandSaveFrameConfigurationSysLevel(mf);
    	c11.execute();

    	System.out.println("java.io.tmpdir = " + f.getAbsolutePath());
    	return true;
    }
}
