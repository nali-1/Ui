package com.nali.ui;

public class M
{
	public static float Mwarp(float v, float min, float max)
	{
		return min + ((((v - min) % (max - min)) + (max - min)) % (max - min));
	}

	public static float Mlerp_wrap(float prev, float curr, float min, float max, float t)
	{
		float range = max - min;

		float a = prev;
		float b = curr;

		float diff = b - a;

		if (diff > range * 0.5F)
			b -= range;
		if (diff < -range * 0.5F)
			b += range;

		float v = a + (b - a) * t;

		return Mwarp(v, min, max);
	}
}
