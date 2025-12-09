package com.nali.ui.mixin;

import com.nali.C;
import net.minecraft.client.Minecraft;
import org.spongepowered.asm.mixin.*;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.io.File;

@Mixin(Minecraft.class)
public abstract class MixinMinecraft
{
	@Inject(method = "init", at = @At("TAIL"))
	private void Minit(CallbackInfo Vc)
	{
		System.load(new File("libSmallPointer.so").getAbsolutePath());
		C.Mgl();
	}
}