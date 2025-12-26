package com.nali.ui.mixin;

import com.nali.C;
import com.nali.ui.Ui;
import net.minecraft.client.Minecraft;
import org.lwjgl.opengl.GL11;
import org.spongepowered.asm.mixin.*;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.io.File;

@Mixin(Minecraft.class)
public abstract class MixinMinecraft
{
	@Inject(method = "init", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/renderer/OpenGlHelper;initializeTextures()V", shift = At.Shift.AFTER))
	private void Minit(CallbackInfo Vc)
	{
		//System.loadLibrary("SmallPointer");
		System.load(new File("libSmallPointer.so").getAbsolutePath());
		C.Mgl();
	}

//	@Inject(method = "runGameLoop", at = @At("TAIL"))
//	private void Mrun_game_loop(CallbackInfo Vc)
//	{
//		Ui.Mdelta();
//	}
}