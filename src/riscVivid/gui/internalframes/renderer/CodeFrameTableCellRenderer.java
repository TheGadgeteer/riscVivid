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
package riscVivid.gui.internalframes.renderer;

import java.awt.*;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.table.TableCellRenderer;

import riscVivid.asm.DLXAssembler;
import riscVivid.gui.GUI_CONST;
import riscVivid.gui.command.userLevel.CommandDisplayTooltips;

public final class CodeFrameTableCellRenderer implements TableCellRenderer, GUI_CONST
{

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value,
            boolean isSelected, boolean hasFocus, int row, int column)
    {
        //set defaults
        JLabel label = new JLabel(value.toString());
        label.setOpaque(true);
        Border b = BorderFactory.createEmptyBorder(1, 1, 1, 1);
        label.setBorder(b);
        label.setFont(table.getFont());
        label.setForeground(table.getForeground());
        label.setBackground(table.getBackground());

        if (CommandDisplayTooltips.isTooltipsEnabled())
        {
            DLXAssembler dlx = new DLXAssembler();
            label.setToolTipText(dlx.InstrDescription(
                    table.getModel().getValueAt(row, 2).toString().split(" ")[0]));
        }

        if (isSelected)
            label.setBackground(new Color(0xBAD2E4));
        //FETCH
        if (label.getText().contains(FETCH))
            label.setBackground(GUI_CONST.IF_COLOR);
        //DECODE
        else if (label.getText().contains(DECODE))
            label.setBackground(GUI_CONST.ID_COLOR);
        //EXECUTE
        else if (label.getText().contains(EXECUTE))
            label.setBackground(GUI_CONST.EX_COLOR);
        //MEMORY
        else if (label.getText().contains(MEMORY))
            label.setBackground(GUI_CONST.MEM_COLOR);
        //WRITEBACK
        else if (label.getText().contains(WRITEBACK))
            label.setBackground(GUI_CONST.WB_COLOR);

        return label;
    }

}
