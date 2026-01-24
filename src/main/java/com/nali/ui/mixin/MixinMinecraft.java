package com.nali.ui.mixin;

import com.nali.C;
import com.nali.ui.Ui;
import net.minecraft.client.Minecraft;
import org.spongepowered.asm.mixin.*;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import sun.misc.Unsafe;

import java.io.File;
import java.lang.reflect.Field;

@Mixin(Minecraft.class)
public abstract class MixinMinecraft
{
	@Inject(method = "init", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/renderer/OpenGlHelper;initializeTextures()V", shift = At.Shift.AFTER))
	private void Minit(CallbackInfo Vc)
	{
		//Ui.vUS = Unsafe.getUnsafe();
		try
		{
			Field Vf = Unsafe.class.getDeclaredField("theUnsafe");
			Vf.setAccessible(true);
			Ui.vUS = (Unsafe)Vf.get(null);
		}
		catch (Exception e)
		{
			Ui.LOGGER.error(e);
		}

		//System.loadLibrary("SmallPointer");
		String Pc = "SmallPointer";
		System.load(new File(System.mapLibraryName(Pc)).getAbsolutePath());
		Ui.lP = C.Mp();
		C.Mgl();
	}
}