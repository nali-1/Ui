//package com.nali.ui.mixin;
//
//import com.nali.ui.Ui;
//import net.minecraft.client.renderer.BufferBuilder;
//import org.spongepowered.asm.mixin.Mixin;
//import org.spongepowered.asm.mixin.injection.At;
//import org.spongepowered.asm.mixin.injection.Inject;
//import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
//
////.t check
//@Mixin(BufferBuilder.class)
//public abstract class MixinBufferBuilder
//{
//	@Inject(method = "normal", at = @At("HEAD"))
//	public void Mnormal(float x, float y, float z, CallbackInfoReturnable<BufferBuilder> Vc)
//	{
//		if (x == 0 && y == 0 && z == 0)
//		{
//			Ui.LOGGER.error("Mnormal", new Throwable());
//		}
//	}
//}