package com.nali.ui.entity.render;

import com.nali.C;
import com.nali.ui.entity.EntityUi;
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
		C.Mdraw();
		GlStateManager.popMatrix();
		super.doRender(Ve, Dx, Dy, Dz, Fyaw, Fpartialticks);
	}
}
