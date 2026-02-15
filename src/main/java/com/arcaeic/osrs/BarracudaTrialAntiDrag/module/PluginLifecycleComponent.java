package com.arcaeic.osrs.BarracudaTrialAntiDrag.module;

import com.arcaeic.osrs.BarracudaTrialAntiDrag.BarracudaTrialAntiDragConfig;
import net.runelite.client.events.ConfigChanged;

public interface PluginLifecycleComponent
{
	@SuppressWarnings("unused")
	default boolean isEnabled(BarracudaTrialAntiDragConfig config)
	{
		return true;
	}

	default void startUp()
	{
	}

	default void shutDown()
	{
	}

	default void onConfigChanged(ConfigChanged e)
	{
	}

}
