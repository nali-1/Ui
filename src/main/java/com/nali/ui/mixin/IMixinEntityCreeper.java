package com.nali.ui.mixin;

import net.minecraft.entity.monster.EntityCreeper;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(EntityCreeper.class)
public interface IMixinEntityCreeper
{
	@Accessor("timeSinceIgnited")
	void Mtime_since_ignited(int I);
}
