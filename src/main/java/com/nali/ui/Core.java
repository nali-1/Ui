package com.nali.ui;

import net.minecraftforge.fml.relauncher.IFMLLoadingPlugin;
import zone.rong.mixinbooter.IEarlyMixinLoader;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public class Core implements IEarlyMixinLoader, IFMLLoadingPlugin
{
	@Override
	public List<String> getMixinConfigs()
	{
		return Collections.singletonList("mixins." + Tags.MOD_ID + ".json");
	}

	@Override
	public String[] getASMTransformerClass()
	{
		return null;
	}

	@Override
	public String getModContainerClass()
	{
		return null;
	}

	@Override
	public String getSetupClass()
	{
		return null;
	}

	@Override
	public void injectData(Map<String, Object> Vdata)
	{
	}

	@Override
	public String getAccessTransformerClass()
	{
		return null;
	}
}