/*******************************************************************************
 * Copyright (c) 2013 Aroma1997.
 * All rights reserved. This program and other files related to this program are
 * licensed with a extended GNU General Public License v. 3
 * License informations are at:
 * https://github.com/Aroma1997/CompactWindmills/blob/master/license.txt
 ******************************************************************************/

package aroma1997.compactwindmills;


import net.minecraft.util.StatCollector;

import net.minecraft.util.StatCollector;

import org.apache.logging.log4j.Level;

import aroma1997.core.log.LogHelper;

import com.google.common.base.Throwables;

/**
 * 
 * @author Aroma1997
 * 
 */
public enum WindType {
	ELV(8, TileEntityWindmill.class, 3),
	LV(32, TileEntityLV.class, 6),
	MV(128, TileEntityMV.class, 8),
	HV(512, TileEntityHV.class, 10),
	EV(2048, TileEntityEV.class, 12);
	
	public static TileEntityWindmill makeTileEntity(int metadata) {
		try {
			TileEntityWindmill tileEntity = values()[metadata].claSS.newInstance();
			return tileEntity;
		}
		catch (Exception e) {
			CompactWindmills.instance.windMillLog.log(Level.WARN, "Failed to Register Windmill: "
				+ WindType.values()[metadata].name());
			throw Throwables.propagate(e);
		}
	}
	
	public int output;
	
	public Class<? extends TileEntityWindmill> claSS;
	
	public int checkRadius;
	
	private WindType(int output,
		Class<? extends TileEntityWindmill> claSS, int checkRadius) {
		this.output = output;
		this.claSS = claSS;
		this.checkRadius = checkRadius;
	}
	
	public String tileEntityName() {
		return "WindType." + name();
	}
	
	public String getUnlocalizedName() {
		return "tile.compactwindmills:windmill.name." + name();
	}
	
}
