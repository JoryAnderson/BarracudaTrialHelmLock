package com.arcaeic.osrs.BarracudaTrialHelmLock;

import com.arcaeic.osrs.BarracudaTrialHelmLock.features.BarracudaTrialHelmLock;

import javax.inject.Inject;

import com.google.inject.Provides;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.EventBus;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;

@SuppressWarnings("unused")
@Slf4j
@PluginDescriptor(
	name = "Barracuda Trial Helm Lock"
)
public class BarracudaTrialHelmLockPlugin extends Plugin
{

	@Inject
	private Client _client;

	@Inject
	private BarracudaTrialHelmLockConfig _config;

	@Inject
	private BarracudaTrialHelmLock _helmLock;

	@Inject
	private EventBus _eventBus;

	@Override
	protected void startUp()
	{
		log.info("Barracuda Trial Helm Lock Started!");
		_eventBus.register(_helmLock);
	}

	@Override
	protected void shutDown()
	{
		_eventBus.unregister(_helmLock);
		log.info("Barracuda Trial Helm Lock Stopped!");
	}

	@Provides
	BarracudaTrialHelmLockConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(BarracudaTrialHelmLockConfig.class);
	}
}
