package com.nali;

public enum Ekf
{
	UI_IDLE((byte)0, (byte)2),
	UI_IDLE1((byte)2, (byte)4),
	UI_ATTACK((byte)4, (byte)6),
	UI_WALK((byte)6, (byte)8),
	CROAKIE_IDLE((byte)0, (byte)2),
	CROAKIE_WALK((byte)2, (byte)4);

	public final byte
		start,
		end;

	Ekf(byte start, byte end)
	{
		this.start = start;
		this.end = end;
	}
}