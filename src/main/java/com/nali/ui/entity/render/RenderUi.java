package com.nali.ui.entity.render;

import com.nali.C;
import com.nali.Ekf;
import com.nali.Em;
import com.nali.ui.entity.EntityUi;
import com.nali.ui.mixin.IMixinEntityRenderer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nullable;

public class RenderUi extends Render<EntityUi>
{
	public RenderUi(RenderManager Vr)
	{
		super(Vr);
	}

	@Nullable
	@Override
	protected ResourceLocation getEntityTexture(EntityUi Ve)
	{
		return null;
	}

	@Override
	public void doRender(EntityUi Ve, double Dx, double Dy, double Dz, float Fyaw, float Fpartialticks)
	{
		GlStateManager.pushMatrix();
		GlStateManager.translate(Dx, Dy, Dz);
		GlStateManager.scale(0.5F, 0.5F, 0.5F);
		int Ic = Ve.getEntityWorld().getCombinedLight(Ve.getPosition(), 0);
		int Icb = (Ic >> 4) & 0xF;
		int Ics = (Ic >> 20) & 0xF;
		int Ick = (Ics << 4) | Icb;
		//.i Um8 Ukf8 Ukf16 Uc32
		C.Mdraw((long)Em.UI_RAIN.ordinal() << (8*7) | (long)Ekf.UI_IDLE.ordinal() << (8*6) | ((long)Ve.Ukf << (8*5)) | ((IMixinEntityRenderer)Minecraft.getMinecraft().entityRenderer).Mlightmap_colors()[Ick] & 0xFFFFFFFFL);
		C.Mdraw((long)Em.CROAKIE_RAIN.ordinal() << (8*7) | (long)Ekf.UI_IDLE.ordinal() << (8*6) | ((long)Ve.Ukf << (8*5)) | ((IMixinEntityRenderer)Minecraft.getMinecraft().entityRenderer).Mlightmap_colors()[Ick] & 0xFFFFFFFFL);
		GlStateManager.popMatrix();
		super.doRender(Ve, Dx, Dy, Dz, Fyaw, Fpartialticks);
	}
}
