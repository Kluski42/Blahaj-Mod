package net.wetnoodle.blahaj;

import net.fabricmc.api.ModInitializer;

import net.wetnoodle.blahaj.block.entity.BlBannerPatterns;
import net.wetnoodle.blahaj.registry.BlEntityTypes;
import net.wetnoodle.blahaj.registry.BlInventorySorting;
import net.wetnoodle.blahaj.registry.BlItems;

public class BlahajMod implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.

	@Override
	public void onInitialize() {
		BlItems.init();
		BlInventorySorting.init();
		BlBannerPatterns.init();
		BlEntityTypes.init();
	}
}