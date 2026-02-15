package com.arcaeic.osrs.BarracudaTrialAntiDrag.features;

import com.arcaeic.osrs.BarracudaTrialAntiDrag.model.*;
import com.arcaeic.osrs.BarracudaTrialAntiDrag.module.PluginLifecycleComponent;
import com.arcaeic.osrs.BarracudaTrialAntiDrag.util.BarracudaTrialUtil;
import com.arcaeic.osrs.BarracudaTrialAntiDrag.BarracudaTrialAntiDragConfig;

import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.MenuAction;
import net.runelite.api.events.MenuEntryAdded;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.events.ConfigChanged;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.inject.Inject;
import javax.inject.Singleton;

@Slf4j
@Singleton
public class BarracudaTrialAntiDrag
	implements PluginLifecycleComponent
{

	private final Client client;
	private final BarracudaTrialAntiDragConfig config;

	private Set<Integer> clickableObjects;

	@Inject
	public BarracudaTrialAntiDrag(Client client, BarracudaTrialAntiDragConfig config)
	{
		this.client = client;
		this.config = config;
		clickableObjects = reloadClickableObjects();
	}

	private Set<Integer> reloadClickableObjects()
	{
		return Stream.of(
			Arrays.stream(BarracudaTrial.values())
				.map(BarracudaTrial::getGameObjectIds),
			Arrays.stream(SailFacility.values())
				.map(SailFacility::getGameObjectIds),
			Arrays.stream(WindCatcherFacility.values())
				.filter(s -> config.isClickableWindCatcher())
				.map(WindCatcherFacility::getGameObjectIds),
			Arrays.stream(GaleCatcherFacility.values())
				.filter(s -> config.isClickableGaleCatcher())
				.map(GaleCatcherFacility::getGameObjectIds),
			Arrays.stream(CrystalExtractorFacility.values())
				.filter(s -> config.isClickableCrystalExtractor())
				.map(CrystalExtractorFacility::getGameObjectIds)
		)
		.flatMap(s -> s)
		.flatMapToInt(Arrays::stream)
		.boxed()
		.collect(Collectors.toUnmodifiableSet());
	}

	@Subscribe(priority = -99)
	@SuppressWarnings("unused")
	public void onMenuEntryAdded(MenuEntryAdded e)
	{
		if (!BarracudaTrialUtil.isInBarracudaTrialAndAtHelm(client))
		{
			return;
		}

		if (e.getMenuEntry().getType() != MenuAction.SET_HEADING)
		{
			if (!clickableObjects.contains(e.getIdentifier()))
			{
				e.getMenuEntry().setDeprioritized(true);
			}
		}
	}

	@Override
	public void onConfigChanged(ConfigChanged e)
	{
		log.info("Config change detected: {}: {} -> {}", e.getKey(), e.getOldValue(), e.getNewValue());
		clickableObjects = reloadClickableObjects();
	}
}
