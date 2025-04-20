package net.wetnoodle.blahaj;

import net.fabricmc.api.ClientModInitializer;
import net.wetnoodle.blahaj.model.BlModelLayers;

public class BlahajClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		BlModelLayers.init();
	}
}