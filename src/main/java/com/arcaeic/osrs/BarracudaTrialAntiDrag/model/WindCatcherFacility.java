package com.arcaeic.osrs.BarracudaTrialAntiDrag.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import net.runelite.api.gameval.ObjectID;

@RequiredArgsConstructor
@Getter
public enum WindCatcherFacility
{

	WIND_CATCHER_ACTIVATED(
		new int[]{
			ObjectID.SAILING_WIND_CATCHER_ACTIVATED,
		}
	),
	WIND_CATCHER_DEACTIVATED(
		new int[]{
			ObjectID.SAILING_WIND_CATCHER_DEACTIVATED,
		}
	);

	private final int[] gameObjectIds;

}
