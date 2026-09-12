package com.mintiestkitkat.kkspelltags.item;

import com.mintiestkitkat.kkspelltags.SpellTagsMod;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(SpellTagsMod.MODID);

    public static final DeferredItem<Item> ENCHANTED_PAPER = ITEMS.register("enchanted_paper",
            ()-> new Item(new Item.Properties()));
    public static final DeferredItem<Item> SPELL_TAG = ITEMS.register("spell_tag",
            ()-> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
