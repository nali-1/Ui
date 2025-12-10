package com.nali.ui;

import com.nali.ui.entity.EntityR;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(modid = Tags.MOD_ID, name = Tags.MOD_NAME, version = Tags.VERSION)
public class Ui
{
	@Mod.Instance
	public static Ui UI;

	public static float fDelta;
	private static long Llast_time = System.nanoTime();
	public static void Mdelta()
	{
		long now = System.nanoTime();
		fDelta = (now - Llast_time) / 1_000_000_000F;
		Llast_time = now;
	}

	public static final Logger LOGGER = LogManager.getLogger(Tags.MOD_NAME);

	@Mod.EventHandler
	public void M0(FMLPreInitializationEvent Ve)
	{
		EntityR.M0();
	}

	@Mod.EventHandler
	public void M1(FMLInitializationEvent Ve)
	{
		EntityR.M1();
	}

//	@Mod.EventHandler
//	public void Ms(FMLServerStartingEvent fmlserverstartingevent)
//	{
//		fmlserverstartingevent.registerServerCommand(new Command());
//	}
}