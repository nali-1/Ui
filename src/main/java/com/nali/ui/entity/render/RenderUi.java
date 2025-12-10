package com.nali.ui.entity.render;

import com.nali.C;
import com.nali.Ekf;
import com.nali.Em;
import com.nali.ui.Ui;
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
		GlStateManager.rotate(-Fyaw + 90.0F, 0.0F, 1.0F, 0.0F);
		int Ic = Ve.getEntityWorld().getCombinedLight(Ve.getPosition(), 0);
		int Icb = (Ic >> 4) & 0xF;
		int Ics = (Ic >> 20) & 0xF;
		int Ick = (Ics << 4) | Icb;
		C.Mdraw((byte)Em.UI_RAIN.ordinal(), (byte)Ekf.UI_IDLE.ordinal(), Ve.Fkf, ((IMixinEntityRenderer)Minecraft.getMinecraft().entityRenderer).Mlightmap_colors()[Ick]);
		C.Mdraw((byte)Em.CROAKIE_RAIN.ordinal(), (byte)Ekf.CROAKIE_IDLE.ordinal(), Ve.Fkf, ((IMixinEntityRenderer)Minecraft.getMinecraft().entityRenderer).Mlightmap_colors()[Ick]);
		//! fix
		Ve.Fkf += Ui.fDelta;
		GlStateManager.popMatrix();
		super.doRender(Ve, Dx, Dy, Dz, Fyaw, Fpartialticks);
	}
}
