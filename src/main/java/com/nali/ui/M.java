package com.nali.ui;

public class M
{
	public static float Mwarp(float v, float min, float max)
	{
		return min + ((((v - min) % (max - min)) + (max - min)) % (max - min));
	}
}
