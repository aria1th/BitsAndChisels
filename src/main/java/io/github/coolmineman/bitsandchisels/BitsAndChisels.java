package io.github.coolmineman.bitsandchisels;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import io.github.coolmineman.bitsandchisels.chisel.DiamondChisel;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Material;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class BitsAndChisels implements ModInitializer {

	public static final Logger LOGGER = LogManager.getLogger("BitsAndChisels");

	public static final BitsBlock BITS_BLOCK = new BitsBlock(FabricBlockSettings.of(Material.METAL).nonOpaque().hardness(4.0f));
	public static final DiamondChisel DIAMOND_CHISEL = new DiamondChisel(new Item.Settings());
	public static BlockEntityType<BitsBlockEntity> BITS_BLOCK_ENTITY;

	public static final BitItem BIT_ITEM = new BitItem(new Item.Settings());

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.
		Registry.register(Registry.BLOCK, new Identifier("bitsandchisels", "bits_block"), BITS_BLOCK);
		BITS_BLOCK_ENTITY = Registry.register(Registry.BLOCK_ENTITY_TYPE, "bitsandchisels:bits_block_entity", BlockEntityType.Builder.create(BitsBlockEntity::new, BITS_BLOCK).build(null));
		Registry.register(Registry.ITEM, new Identifier("bitsandchisels", "bits_block"), new BlockItem(BITS_BLOCK, new Item.Settings()));
		Registry.register(Registry.ITEM, new Identifier("bitsandchisels", "diamond_chisel"), DIAMOND_CHISEL);
		DIAMOND_CHISEL.init();
		Registry.register(Registry.ITEM, new Identifier("bitsandchisels", "bit_item"), BIT_ITEM);
		BIT_ITEM.init();
	}
	
}
