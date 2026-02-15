package com.arcaeic.osrs.BarracudaTrialAntiDrag;


import com.arcaeic.osrs.BarracudaTrialAntiDrag.module.ComponentManager;
import com.arcaeic.osrs.BarracudaTrialAntiDrag.module.BarracudaTrialModule;

import com.google.inject.Binder;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;

@Slf4j
@PluginDescriptor(
	name = "Barracuda Trial Anti-Drag"
)
public class BarracudaTrialAntiDragPlugin extends Plugin
{
	@Inject
	private ComponentManager componentManager;

	@Override
	public void configure(Binder binder)
	{
		binder.install(new BarracudaTrialModule());
	}

	@Override
	protected void startUp()
	{
		log.info("Barracuda Trial Anti-Drag Started!");
		componentManager.onPluginStart();
	}

	@Override
	protected void shutDown()
	{
		log.info("Barracuda Trial Anti-Drag Stopped!");
		componentManager.onPluginStop();
	}
}
