package com.nali.ui.entity;

import com.google.common.base.Predicate;
import com.nali.Ekf;
import com.nali.ui.M;
import com.nali.ui.Ui;
import com.nali.ui.mixin.IMixinEntityCreeper;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.passive.*;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;
import net.minecraftforge.event.ForgeEventFactory;

import javax.annotation.Nullable;

//! EntityLivingBase
public class EntityUi extends EntityTameable
{
//	private final static byte uHOME = 1;
//	//private final static byte uST = 2;
//	private final static byte uSKILL = 4;
//	private final static byte uTAKE = 8;
//	private final static byte uKILL = 16;
//	private final static byte uMINE = 32;
//	private byte Ustate = uHOME + uSKILL + uTAKE + uMINE;
	public EntityUi(World Vw)
	{
		super(Vw);
		this.setSize(1.0F, 2.0F);
	}

	//.i server
	public float Fkf2;
	public byte Ba0;
	public byte Ba1;
	//.i client
	public float Fkf0;
	public float Fkf1;
	public static final DataParameter<Float> vKF = EntityDataManager.<Float>createKey(EntityUi.class, DataSerializers.FLOAT);
	public static final DataParameter<Byte> vK = EntityDataManager.<Byte>createKey(EntityUi.class, DataSerializers.BYTE);
	public static final DataParameter<Byte> vA0 = EntityDataManager.<Byte>createKey(EntityUi.class, DataSerializers.BYTE);
	public static final DataParameter<Byte> vA1 = EntityDataManager.<Byte>createKey(EntityUi.class, DataSerializers.BYTE);
	@Override
	protected void entityInit()
	{
		super.entityInit();
		this.dataManager.register(vKF, 0.0F);
		this.dataManager.register(vK, (byte)0);
		this.dataManager.register(vA0, (byte)0);
		this.dataManager.register(vA1, (byte)0);
	}

//	private final static ITextComponent vACTION = new TextComponentString("Action").setStyle(new Style().setUnderlined(true));
//	private final static ITextComponent vPHOME = new TextComponentString("⌂✓").setStyle(new Style().setColor(TextFormatting.GREEN));
//	private final static ITextComponent vNHOME = new TextComponentString("⌂✗").setStyle(new Style().setColor(TextFormatting.RED));
//	//private final static ITextComponent vPST = new TextComponentString("☺✓").setStyle(new Style().setColor(TextFormatting.GREEN));
//	//private final static ITextComponent vNST = new TextComponentString("☺✗").setStyle(new Style().setColor(TextFormatting.RED));
//	private final static ITextComponent vPSKILL = new TextComponentString("♪✓").setStyle(new Style().setColor(TextFormatting.GREEN));
//	private final static ITextComponent vNSKILL = new TextComponentString("♪✗").setStyle(new Style().setColor(TextFormatting.RED));
//	private final static ITextComponent vPTAKE = new TextComponentString("☼✓").setStyle(new Style().setColor(TextFormatting.GREEN));
//	private final static ITextComponent vNTAKE = new TextComponentString("☼✗").setStyle(new Style().setColor(TextFormatting.RED));
//	private final static ITextComponent vPKILL = new TextComponentString("☻✓").setStyle(new Style().setColor(TextFormatting.GREEN));
//	private final static ITextComponent vNKILL = new TextComponentString("☻✗").setStyle(new Style().setColor(TextFormatting.RED));
//	private final static ITextComponent vPMINE = new TextComponentString("♦✓").setStyle(new Style().setColor(TextFormatting.GREEN));
//	private final static ITextComponent vNMINE = new TextComponentString("♦✗").setStyle(new Style().setColor(TextFormatting.RED));
//	public static void Mact(EntityPlayer Vp, EntityUi Ve)
//	{
//		if (Ve.isOwner(Vp))
//		{
//			TextComponentString V1 = new TextComponentString(" +");
//			V1.setStyle
//			(
//				new Style().setColor(TextFormatting.RED)
//				.setClickEvent
//				(
//					new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/ui " + Ve.getUniqueID() + " 0 0")
//				)
//				.setHoverEvent
//				(
//					new HoverEvent(HoverEvent.Action.SHOW_TEXT, new TextComponentString("▲0.05/▼1"))
//				)
//			);
//
//			Vp.sendMessage(Ve.getDisplayName().setStyle(new Style().setUnderlined(true)));
//			Vp.sendMessage
//			(
//				new TextComponentString(SharedMonsterAttributes.MAX_HEALTH.getName()).appendSibling(new TextComponentString(" " + String.format("%.2f", Ve.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).getAttributeValue())).setStyle(new Style().setColor(TextFormatting.GOLD))).appendSibling(V1)
//			);
//			Vp.sendMessage(new TextComponentString(SharedMonsterAttributes.MOVEMENT_SPEED.getName()).appendSibling(new TextComponentString(" " + String.format("%.2f", Ve.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).getAttributeValue())).setStyle(new Style().setColor(TextFormatting.GOLD))));
//			Vp.sendMessage(new TextComponentString(SharedMonsterAttributes.ATTACK_DAMAGE.getName()).appendSibling(new TextComponentString(" " + String.format("%.2f", Ve.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).getAttributeValue())).setStyle(new Style().setColor(TextFormatting.GOLD))));
//
//			Vp.sendMessage(vACTION);
//			Vp.sendMessage();
//			Vp.sendMessage();
//		}
//	}

	@Override
	protected void initEntityAI()
	{
		this.aiSit = new EntityAISit(this);
		this.tasks.addTask(1, new EntityAISwimming(this));
		this.tasks.addTask(2, this.aiSit);
		this.tasks.addTask(3, new EntityAILeapAtTarget(this, 0.4F));
		this.tasks.addTask(4, new EntityAIAttackMelee(this, 1.0D, true)
		{
			@Override
			protected double getAttackReachSqr(EntityLivingBase attackTarget)
			{
				return (double)(this.attacker.width * 10.0F * this.attacker.width * 10.0F + attackTarget.width);
			}

			@Override
			public void updateTask()
			{
				EntityLivingBase entitylivingbase = this.attacker.getAttackTarget();
				this.attacker.getLookHelper().setLookPositionWithEntity(entitylivingbase, 30.0F, 30.0F);
				double d0 = this.attacker.getDistanceSq(entitylivingbase.posX, entitylivingbase.getEntityBoundingBox().minY, entitylivingbase.posZ);

				if (d0 <= this.getAttackReachSqr(entitylivingbase))
				{
					((EntityUi)this.attacker).Battack0 = true;
					if (((EntityUi)this.attacker).Battack)
					{
						entitylivingbase.hurtTime = 0;
						entitylivingbase.hurtResistantTime = 0;
						if (entitylivingbase instanceof EntityCreeper)
						{
							((IMixinEntityCreeper)entitylivingbase).Mtime_since_ignited(0);
						}
						this.attacker.swingArm(EnumHand.MAIN_HAND);
						this.attacker.attackEntityAsMob(entitylivingbase);
						((EntityUi)this.attacker).Battack = false;
					}
					this.attacker.getNavigator().clearPath();
				}
				else
				{
					this.attacker.getNavigator().tryMoveToEntityLiving(entitylivingbase, 1.0D);
				}
			}
		});
		this.tasks.addTask(5, new EntityAIFollowOwner(this, 1.0D, 10.0F, 2.0F));
		this.tasks.addTask(6, new EntityAIMate(this, 1.0D));
		this.tasks.addTask(7, new EntityAIWanderAvoidWater(this, 1.0D));
		this.tasks.addTask(8, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
		this.tasks.addTask(8, new EntityAILookIdle(this));
		this.targetTasks.addTask(1, new EntityAIOwnerHurtByTarget(this));
		this.targetTasks.addTask(2, new EntityAIOwnerHurtTarget(this));
		this.targetTasks.addTask(3, new EntityAIHurtByTarget(this, true, new Class[0]));
		this.targetTasks.addTask(4, new EntityAINearestAttackableTarget<EntityLiving>(this, EntityLiving.class, 10, true, true, new Predicate<EntityLiving>()
		{
			public boolean apply(@Nullable EntityLiving Ve)
			{
				return Ve != null && IMob.VISIBLE_MOB_SELECTOR.apply(Ve);
			}
		}));
	}

	@Override
	protected void applyEntityAttributes()
	{
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.30000001192092896D);
		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(20.0D);
		this.getAttributeMap().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(4.0D);
	}

	@Override
	public boolean processInteract(EntityPlayer Vp, EnumHand Eh)
	{
		ItemStack itemstack = Vp.getHeldItem(Eh);
		if (itemstack.isEmpty())
		{
			if (!this.world.isRemote)
			{
//				if (Vp.isSneaking())
//				{
//					Mact(Vp, this);
//				}
//				else
				if (this.isOwner(Vp))
				{
					this.aiSit.setSitting(!this.isSitting());
					this.isJumping = false;
					this.navigator.clearPath();
					this.setAttackTarget(null);
				}
			}
			return true;
		}
		else if (itemstack.getItem() == Items.SUGAR)
		{
			if (!this.world.isRemote)
			{
				if (!Vp.capabilities.isCreativeMode)
				{
					itemstack.shrink(1);
				}
				this.heal(10.0F);

				if (!ForgeEventFactory.onAnimalTame(this, Vp))
				{
					this.setTamedBy(Vp);
					this.navigator.clearPath();
					this.setAttackTarget(null);
					this.aiSit.setSitting(true);
					this.playTameEffect(true);
					this.world.setEntityState(this, (byte) 7);
				}
			}
			return true;
		}
		return super.processInteract(Vp, Eh);
	}

	@Override
	public int getMaxSpawnedInChunk()
	{
		return 8;
	}

	@Override
	public boolean attackEntityFrom(DamageSource Vd, float amount)
	{
		if (this.isEntityInvulnerable(Vd))
		{
			return false;
		}
		else
		{
			if (this.aiSit != null)
			{
				this.aiSit.setSitting(false);
			}

			return super.attackEntityFrom(Vd, amount);
		}
	}

	@Override
	public boolean attackEntityAsMob(Entity entityIn)
	{
		boolean Bflag = entityIn.attackEntityFrom(DamageSource.causeMobDamage(this), (float)((int)this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).getAttributeValue()));
		if (Bflag)
		{
			this.applyEnchantments(this, entityIn);
		}
		return Bflag;
	}

	//.i server
	public boolean Battack0;
	public boolean Battack;
	public boolean Mis_move()
	{
		double dx = this.posX - this.prevPosX;
		double dz = this.posZ - this.prevPosZ;
		return (dx * dx + dz * dz) > 1.0E-4;
	}

	@Override
	public void onUpdate()
	{
		super.onUpdate();
//		if (this.world.isRemote)
//			this.rotationYaw += 45.0F / Ui.bTICK;

		if (!this.world.isRemote)
		{
			byte Bk_ui;
			if (this.Mis_move())
			{
				this.Fkf2 += 5.0F / Ui.bTICK;
				this.Fkf2 = M.Mwarp(this.Fkf2, Ekf.UI_WALK.start, Ekf.UI_WALK.end);
				Bk_ui = (byte)Ekf.UI_WALK.ordinal();
			}
			else if (this.Battack0)
			{
				float Fkf = this.Fkf2;
				this.Fkf2 += 2.0F / Ui.bTICK;
				this.Fkf2 = M.Mwarp(this.Fkf2, Ekf.UI_ATTACK.start, Ekf.UI_ATTACK.end);
				Bk_ui = (byte)Ekf.UI_ATTACK.ordinal();
				if (Fkf > this.Fkf2)
					this.Battack = true;
				this.Battack0 = false;
			}
			else if (!this.isSitting())
			{
				//Ui.LOGGER.info("this.Fkf2 " + this.Fkf2);
				this.Fkf2 += 1.0F / Ui.bTICK;
				this.Fkf2 = M.Mwarp(this.Fkf2, Ekf.UI_IDLE1.start, Ekf.UI_IDLE1.end);
				Bk_ui = (byte)Ekf.UI_IDLE1.ordinal();
			}
			else
			{
				this.Fkf2 += 1.0F / Ui.bTICK;
				this.Fkf2 = M.Mwarp(this.Fkf2, Ekf.UI_IDLE.start, Ekf.UI_IDLE.end);
				Bk_ui = (byte)Ekf.UI_IDLE.ordinal();
			}

			if ((this.ticksExisted & 20) == 0)
			{
				if (this.Ba0 > 0)
				{
					--this.Ba0;
				}
				else
				{
					this.Ba0 = (byte)(this.rand.nextInt(100) + 20);
				}

				if (this.Ba1 > 0)
				{
					--this.Ba1;
				}
				else
				{
					this.Ba1 = (byte)(this.rand.nextInt(100) + 20);
				}
			}

			this.dataManager.set(vKF, this.Fkf2);
			this.dataManager.set(vK, Bk_ui);
			this.dataManager.set(vA0, this.Ba0);
			this.dataManager.set(vA1, this.Ba1);
//			this.Fkf2 += 1.0F / Ui.bTICK;
//			this.Fkf2 = M.Mwarp(this.Fkf2, Ekf.UI_IDLE1.start, Ekf.UI_IDLE1.end);
//			this.dataManager.set(vKF, this.Fkf2);
//			this.dataManager.set(vK, (byte)Ekf.UI_IDLE1.ordinal());
		}
	}

	@Nullable
	@Override
	public EntityAgeable createChild(EntityAgeable Ve)
	{
		return null;
	}
}