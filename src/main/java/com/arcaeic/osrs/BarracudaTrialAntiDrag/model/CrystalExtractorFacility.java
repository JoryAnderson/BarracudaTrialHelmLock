package com.arcaeic.osrs.BarracudaTrialAntiDrag.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import net.runelite.api.gameval.ObjectID;

@RequiredArgsConstructor
@Getter
public enum CrystalExtractorFacility
{

	CRYSTAL_EXTRACTOR_ACTIVATED(
		new int[]{
			ObjectID.SAILING_CRYSTAL_EXTRACTOR_ACTIVATED,
		}
	),
	CRYSTAL_EXTRACTOR_DEACTIVATED(
		new int[]{
			ObjectID.SAILING_CRYSTAL_EXTRACTOR_DEACTIVATED,
		}
	);

	private final int[] gameObjectIds;

}
