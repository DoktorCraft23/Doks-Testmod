package net.doktorcraft23.dokstestmod.item;

import net.doktorcraft23.dokstestmod.DoksTestMod;
import net.doktorcraft23.dokstestmod.item.custom.CoinItem;
import net.doktorcraft23.dokstestmod.item.custom.UraniumIngotItem;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(DoksTestMod.MOD_ID);

    public static final DeferredItem<Item> STEEL_INGOT = ITEMS.register("steel_ingot",
            ()-> new Item(new Item.Properties()));

    public static final DeferredItem<Item> MECHANIUM_FRAGMENT = ITEMS.register("mechanium_fragment",
            ()-> new Item(new Item.Properties()));

    public static final DeferredItem<Item> COIN = ITEMS.register("coin",
            ()-> new CoinItem(new Item.Properties().durability(64)));

    public static final DeferredItem<Item> URANIUM_INGOT = ITEMS.register("uranium_ingot",
            ()-> new Item(new Item.Properties().food(UraniumIngotItem.URANIUM)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
