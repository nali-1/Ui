//package com.nali.ui;
//
//import com.nali.ui.entity.EntityUi;
//import net.minecraft.command.CommandBase;
//import net.minecraft.command.CommandException;
//import net.minecraft.command.ICommandSender;
//import net.minecraft.entity.Entity;
//import net.minecraft.entity.player.EntityPlayer;
//import net.minecraft.server.MinecraftServer;
//import net.minecraft.util.text.TextComponentString;
//import net.minecraft.world.WorldServer;
//
//import java.util.UUID;
//
//public class Command extends CommandBase
//{
//	@Override
//	public String getName()
//	{
//		return "ui";
//	}
//
//	@Override
//	public String getUsage(ICommandSender Vs)
//	{
//		return "/ui - byte action";
//	}
//
//	@Override
//	public void execute(MinecraftServer Vm, ICommandSender Vs, String[] Pargs) throws CommandException
//	{
//		Entity Ves = Vs.getCommandSenderEntity();
//		if (Ves != null)
//		{
//			Entity Vui = ((WorldServer)Ves.world).getEntityFromUuid(UUID.fromString(Pargs[0]));
//			if (Vui instanceof EntityUi)
//				EntityUi.Mact((EntityPlayer)Ves, (EntityUi)Vui);
//		}
//	}
//
//	@Override
//	public int getRequiredPermissionLevel()
//	{
//		return 0;
//	}
//}