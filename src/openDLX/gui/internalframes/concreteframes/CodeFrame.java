/*******************************************************************************
 * openDLX - A DLX/MIPS processor simulator.
 * Copyright (C) 2013 The openDLX project, University of Augsburg, Germany
 * Project URL: <https://sourceforge.net/projects/opendlx>
 * Development branch: <https://github.com/smetzlaff/openDLX>
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
package openDLX.gui.internalframes.concreteframes;

import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableModel;
import openDLX.gui.MainFrame;
import openDLX.gui.internalframes.factories.tableFactories.CodeTableFactory;
import openDLX.gui.internalframes.OpenDLXSimInternalFrame;
import openDLX.gui.internalframes.util.TableSizeCalculator;
import openDLX.OpenDLXSimulator;

@SuppressWarnings("serial")
public final class CodeFrame extends OpenDLXSimInternalFrame
{

    private OpenDLXSimulator openDLXSim;
    private JTable codeTable;
    private String IFValue = "";
    private String IDValue = "";
    private String EXValue = "";
    private String MEMValue = "";
    private String WBValue = "";

    public CodeFrame(String title)
    {
        super(title, false);
        this.openDLXSim = MainFrame.getInstance().getOpenDLXSim();
        initialize();
    }

    @Override
    public void update()
    {
        IFValue = openDLXSim.getPipeline().getFetchDecodeLatch().element().getPc().getHex();
        IDValue = openDLXSim.getPipeline().getDecodeExecuteLatch().element().getPc().getHex();
        EXValue = openDLXSim.getPipeline().getExecuteMemoryLatch().element().getPc().getHex();
        MEMValue = openDLXSim.getPipeline().getMemoryWriteBackLatch().element().getPc().getHex();
        WBValue = openDLXSim.getPipeline().getWriteBackLatch().element().getPc().getHex();

        TableModel model = codeTable.getModel();
        for (int row = 0; row < model.getRowCount(); ++row)
        {
            String addr = model.getValueAt(row, 0).toString().substring(0, 10);


            if (addr.contains(IFValue))
            {
                model.setValueAt(addr + "  " + "IF", row, 0);
                if (codeTable.getParent() != null)
                {
                    // move IF row into focus - i.e. scroll to IF-row
                    codeTable.scrollRectToVisible(codeTable.getCellRect(row, 0, true));

                }
            }
            else if (addr.contains(IDValue))
            {
                model.setValueAt(addr + "  " + "ID", row, 0);
            }
            else if (addr.contains(EXValue))
            {
                model.setValueAt(addr + "  " + "EX", row, 0);
            }
            else if (addr.contains(MEMValue))
            {
                model.setValueAt(addr + "  " + "MEM", row, 0);
            }
            else if (addr.contains(WBValue))
            {
                model.setValueAt(addr + "  " + "WB", row, 0);
            }
            else
            {
                model.setValueAt(model.getValueAt(row, 0).toString().substring(0, 10), row, 0);
            }
        }
    }

    @Override
    protected void initialize()
    {
        super.initialize();
        //make the scrollpane 
        codeTable = new CodeTableFactory(openDLXSim).createTable();
        JScrollPane scrollpane = new JScrollPane(codeTable);
        scrollpane.setFocusable(false);
        codeTable.setFillsViewportHeight(true);
        TableSizeCalculator.setDefaultMaxTableSize(scrollpane, codeTable, TableSizeCalculator.SET_SIZE_WIDTH);
        //config internal frame
        setLayout(new BorderLayout());
        add(scrollpane, BorderLayout.CENTER);
        pack();
        setVisible(true);
    }

    @Override
    public void clean()
    {
        setVisible(false);
        dispose();
    }

}
