package com.divinetowers;

import java.util.function.Function;

import net.fabricmc.fabric.api.registry.FuelRegistryEvents;
import net.minecraft.item.Item;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item MAGENTA_CONCRETE_POWDER = register(
		"magenta_concrete_powder",
		Item::new,
		new Item.Settings()
	);

	public static final Item LONG_FALL_BOOTS = register(
		"long_fall_boots",
		Item::new,
		new Item.Settings().armor(LongFallBoots.MATERIAL_INSTANCE, EquipmentType.BOOTS)
	);

    public static void initialize() {
		FuelRegistryEvents.BUILD.register((builder, context) -> {
			builder.add(MAGENTA_CONCRETE_POWDER, 30 * 20);
		});
    }

	public static Item register(String name, Function<Item.Settings, Item> itemFactory, Item.Settings settings) {
		// Create the item key.
		RegistryKey<Item> itemKey = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(DivineTowers.MOD_ID, name));

		// Create the item instance.
		Item item = itemFactory.apply(settings.registryKey(itemKey));

		// Register the item.
		Registry.register(Registries.ITEM, itemKey, item);

		return item;
	}
}