package com.arcaeic.osrs.BarracudaTrialHelmLock;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;
import net.runelite.client.config.ConfigSection;

@ConfigGroup(BarracudaTrialHelmLockConfig.BARRACUDA_TRIAL_HELM_LOCK)
public interface BarracudaTrialHelmLockConfig extends Config
{
	String BARRACUDA_TRIAL_HELM_LOCK = "BarracudaTrialHelmLock";

	@ConfigSection(
		name = "Boat Facilities",
		description = "Menu swap options for boat facilities",
		position = 100
	)
	String SECTION_BOAT_FACILITIES = "menuSwaps";

	@ConfigItem(
		keyName = "isClickableWindCatcher",
		name = "Wind Catcher",
		description = "Enables wind catcher menu entries",
		section = SECTION_BOAT_FACILITIES,
		position = 1

	)
	default boolean isClickableWindCatcher()
	{
		return true;
	}

	@ConfigItem(
		keyName = "isClickableGaleCatcher",
		name = "Gale Catcher",
		description = "Enables gale catcher menu entries",
		section = SECTION_BOAT_FACILITIES,
		position = 2
	)
	default boolean isClickableGaleCatcher()
	{
		return true;
	}

	@ConfigItem(
		keyName = "isClickableCrystalExtractor",
		name = "Crystal Extractor",
		description = "Enables crystal extractor menu entries",
		section = SECTION_BOAT_FACILITIES,
		position = 3
	)
	default boolean isClickableCrystalExtractor()
	{
		return false;
	}
}
