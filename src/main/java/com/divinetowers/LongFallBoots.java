package com.divinetowers;

import java.util.Map;

import net.minecraft.item.Item;
import net.minecraft.item.equipment.ArmorMaterial;
import net.minecraft.item.equipment.EquipmentAsset;
import net.minecraft.item.equipment.EquipmentAssetKeys;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;

public class LongFallBoots {
    public static final RegistryKey<EquipmentAsset> ARMOR_MATERIAL_KEY = RegistryKey.of(EquipmentAssetKeys.REGISTRY_KEY, Identifier.of(DivineTowers.MOD_ID, "long_fall_boots"));

    public static final int BASE_DURABILITY = Integer.MAX_VALUE;

    public static final TagKey<Item> REPAIRS_LONG_FALL_BOOTS = null;

    public static final ArmorMaterial MATERIAL_INSTANCE = new ArmorMaterial(
		BASE_DURABILITY,
		Map.of(
			EquipmentType.BOOTS, 3
		),
		5,
		SoundEvents.ITEM_ARMOR_EQUIP_IRON,
		0.0F,
		0.0F,
		REPAIRS_LONG_FALL_BOOTS,
		ARMOR_MATERIAL_KEY
    );
}
