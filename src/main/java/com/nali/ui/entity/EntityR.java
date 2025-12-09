package com.nali.ui.entity;

import com.nali.ui.Tags;
import com.nali.ui.Ui;
import com.nali.ui.entity.render.RenderUi;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntitySpawnPlacementRegistry;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.init.Biomes;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@Mod.EventBusSubscriber(modid = Tags.MOD_ID)
public class EntityR
{
	public static void Madd()
	{
		EntityRegistry.registerModEntity(new ResourceLocation(Tags.MOD_ID, "ui"), EntityUi.class, "ui", 0, Ui.UI, 64, 1, true, 0xCEDDC8, 0xA4D97F);
	}

	public static void Mspawn()
	{
		EntityRegistry.addSpawn(EntityUi.class, 16, 1, 4, EnumCreatureType.CREATURE, Biomes.RIVER, Biomes.SWAMPLAND);
		EntitySpawnPlacementRegistry.setPlacementType(EntityUi.class, EntityLiving.SpawnPlacementType.ON_GROUND);
	}

	public static void M0()
	{
		Madd();
	}

	public static void M1()
	{
		Mspawn();
	}

	@SubscribeEvent
	@SideOnly(Side.CLIENT)
	public static void onModelRegistryEvent(ModelRegistryEvent Ve)
	{
		RenderingRegistry.registerEntityRenderingHandler(EntityUi.class, new IRenderFactory<EntityUi>()
		{
			@Override
			public RenderUi createRenderFor(RenderManager Vr)
			{
				return new RenderUi(Vr);
			}
		});
	}
}