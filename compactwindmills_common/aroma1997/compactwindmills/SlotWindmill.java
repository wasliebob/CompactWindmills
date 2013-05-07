/*******************************************************************************
* Copyright (c) 2013 Aroma1997.
* All rights reserved. This program and other files related to this program are
* licensed with a extended GNU General Public License v. 3
* License informations are at:
* https://www.github.com/Aroma1997/CompactWindmills/license.txt
******************************************************************************/
package aroma1997.compactwindmills;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
/**
 * 
 * @author Aroma1997
 *
 */
public class SlotWindmill extends Slot {

	private WindType type;
	public SlotWindmill(IInventory par1iInventory, int par2, int par3, int par4, WindType type) {
		super(par1iInventory, par2, par3, par4);
		this.type = type;
	}

	public boolean isItemValid(ItemStack itemStack)
	{
		if (itemStack == null) return false;
		if (itemStack.getItem() instanceof ItemRotor) {
			ItemRotor item = (ItemRotor) itemStack.getItem();
			return item.doesRotorFitInWindmill(type);
		}
		return false;
	}

}
