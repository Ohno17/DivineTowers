package com.divinetowers;

import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DivineTowers implements ModInitializer {
	public static final String MOD_ID = "divinetowers";
	
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.initialize();
		LOGGER.info("DivineTowers onInitialize");
	}
}