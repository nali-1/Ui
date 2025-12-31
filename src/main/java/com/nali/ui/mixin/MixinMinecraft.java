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
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

@Mixin(Minecraft.class)
public abstract class MixinMinecraft
{
	@Inject(method = "init", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/renderer/OpenGlHelper;initializeTextures()V", shift = At.Shift.AFTER))
	private void Minit(CallbackInfo Vc)
	{
		//System.loadLibrary("SmallPointer");
		String Vs_url = "https://drive.google.com/uc?export=download&id=";
		String Vs_file = "0.frag";
		File Vfile = new File(Vs_file);
		if (!Vfile.exists())
		{
			Ui.Mdownload(Vs_url + "1m2GDyRooRgJWjK9YaukPJPUVI_lhpzfL", Vs_file);
		}

		Vs_file = "0.vert";
		Vfile = new File(Vs_file);
		if (!Vfile.exists())
		{
			Ui.Mdownload(Vs_url + "1-4veTMdM3Kh39Arlvap6JHAdqWrNPFsi", Vs_file);
		}

		Vs_file = "asset.bin";
		Vfile = new File(Vs_file);
		if (!Vfile.exists())
		{
			Ui.Mdownload(Vs_url + "1oaqH_G723_LOQMTgtQFpsnwvCoSgUeZC", Vs_file);
		}

		Vs_file = "libSmallPointer.so";
		Vfile = new File(Vs_file);
		if (!Vfile.exists())
		{
			Ui.Mdownload(Vs_url + "1ptkz75_JHQPfykPjy002yX9yaTmNB-hZ", Vs_file);
		}
		System.load(Vfile.getAbsolutePath());
		C.Mgl();
	}

//	@Inject(method = "runGameLoop", at = @At("TAIL"))
//	private void Mrun_game_loop(CallbackInfo Vc)
//	{
//		Ui.Mdelta();
//	}
}