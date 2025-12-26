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
import net.minecraft.network.datasync.EntityDataManager;
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
		//! own rotate
		float Frender_yaw_offset = this.interpolateRotation(Ve.prevRenderYawOffset, Ve.renderYawOffset, Fpartialticks);
		float Frotation_yaw_head = this.interpolateRotation(Ve.prevRotationYawHead, Ve.rotationYawHead, Fpartialticks);
		float Fnet_head_yaw = Frotation_yaw_head - Frender_yaw_offset;
		float Fhead_pitch = Ve.prevRotationPitch + (Ve.rotationPitch - Ve.prevRotationPitch) * Fpartialticks;
		//Ui.LOGGER.info("Fhead_pitch " + Fhead_pitch);
		//Ui.LOGGER.info("Fnet_head_yaw " + Fnet_head_yaw);
		GlStateManager.rotate(-Fyaw, 0.0F, 1.0F, 0.0F);
		GlStateManager.rotate(-Fnet_head_yaw, 0.0F, 1.0F, 0.0F);
		//GlStateManager.rotate(Fnet_head_yaw, 0.0F, 1.0F, 0.0F);
		int Ic = Ve.getEntityWorld().getCombinedLight(Ve.getPosition(), 0);
		int Icb = (Ic >> 4) & 0xF;
		int Ics = (Ic >> 20) & 0xF;
		int Ick = (Ics << 4) | Icb;
		EntityDataManager Ventitydatamanager = Ve.getDataManager();
		Ve.Fkf1 = Ventitydatamanager.get(EntityUi.vKF);
		//Ui.LOGGER.info("Ve.Fkf1 " + Ve.Fkf1);
		byte Bk_ui = Ventitydatamanager.get(EntityUi.vK);
		byte Ba0 = Ventitydatamanager.get(EntityUi.vA0);
		byte Ba1 = Ventitydatamanager.get(EntityUi.vA1);
		float Fkf = Ve.Fkf1;

//		Ekf[] Vekf = Ekf.values();
//		byte Bstart = Vekf[Bk_ui].start;
//		byte Bend = Vekf[Bk_ui].end;
//		float Fkf;
//		if (Ve.Fkf0 == Ve.Fkf1)
//			Fkf = Ve.Fkf0;
//		else
//			Fkf = M.Mwarp(Ve.Fkf0 + M.Mwarp(Ve.Fkf1 - Ve.Fkf0, Bstart, Bend) * Fpartialticks, Bstart, Bend);
//		Ve.Fkf0 = Ve.Fkf1;

//		Ve.Fkf0 += Ui.fDelta;
		//float Fkf_croakie = Fkf;
		byte Bk_croakie;
		if (Bk_ui == Ekf.UI_WALK.ordinal())
		{
//			Fkf_croakie -= Ekf.UI_WALK.start;
//			Fkf_croakie += Ekf.CROAKIE_WALK.start;
			Bk_croakie = (byte)Ekf.CROAKIE_WALK.ordinal();
		}
		else
		{
			Bk_croakie = (byte)Ekf.CROAKIE_IDLE.ordinal();
		}
		//Ui.LOGGER.info("Fkf " + Fkf);
		byte Bm_ui = (byte)Em.UI_RAIN2.ordinal();
		if (Bk_ui == Ekf.UI_IDLE.ordinal())
			Bm_ui = (byte)Em.UI_RAIN0.ordinal();
		C.Mdraw(Ba0 > 0 ? Bm_ui : (byte)Em.UI_RAIN1.ordinal(), Bk_ui, Fkf, ((IMixinEntityRenderer)Minecraft.getMinecraft().entityRenderer).Mlightmap_colors()[Ick]);
		C.Mdraw(Ba1 > 0 ? (byte)Em.CROAKIE_RAIN0.ordinal() : (byte)Em.CROAKIE_RAIN1.ordinal(), Bk_croakie, Fkf, ((IMixinEntityRenderer)Minecraft.getMinecraft().entityRenderer).Mlightmap_colors()[Ick]);

		//C.Mdraw((byte)Em.UI_RAIN0.ordinal(), Bk_ui, Fkf, ((IMixinEntityRenderer)Minecraft.getMinecraft().entityRenderer).Mlightmap_colors()[Ick]);
		//C.Mdraw((byte)Em.CROAKIE_RAIN0.ordinal(), Bk_croakie, Fkf, ((IMixinEntityRenderer)Minecraft.getMinecraft().entityRenderer).Mlightmap_colors()[Ick]);
		GlStateManager.popMatrix();
		super.doRender(Ve, Dx, Dy, Dz, Fyaw, Fpartialticks);
	}

	protected float interpolateRotation(float prevYawOffset, float yawOffset, float partialTicks)
	{
		float f;

		for (f = yawOffset - prevYawOffset; f < -180.0F; f += 360.0F)
		{
			;
		}

		while (f >= 180.0F)
		{
			f -= 360.0F;
		}

		return prevYawOffset + partialTicks * f;
	}
}
