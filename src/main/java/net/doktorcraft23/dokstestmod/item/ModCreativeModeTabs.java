package net.doktorcraft23.dokstestmod.item;

import net.doktorcraft23.dokstestmod.DoksTestMod;
import net.doktorcraft23.dokstestmod.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, DoksTestMod.MOD_ID);

    public static final Supplier<CreativeModeTab> DOKSTESTMODITEMS = CREATIVE_MODE_TAB.register("dokstestmoditems_tab",
            () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(ModItems.MECHANIUM_FRAGMENT.get()))
                    .title(Component.translatable("creativetab.dokstestmod.dokstestmoditems"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.MECHANIUM_FRAGMENT);
                        output.accept(ModItems.STEEL_INGOT);
                        output.accept(ModItems.COIN);
                    })
                    .build());

        public static final Supplier<CreativeModeTab> DOKSTESTMODBLOCKS = CREATIVE_MODE_TAB.register("dokstestmodblocks_tab",
            () -> CreativeModeTab.builder()
                    .withTabsBefore(ResourceLocation.fromNamespaceAndPath(DoksTestMod.MOD_ID, "dokstestmoditems_tab"))
                    .icon(() -> new ItemStack(ModBlocks.MECHANIUM_BLOCK.get()))
                    .title(Component.translatable("creativetab.dokstestmod.dokstestmodblocks"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModBlocks.MECHANIUM_BLOCK);
                        output.accept(ModBlocks.STEEL_BLOCK);
                        output.accept(ModBlocks.LEON_BLOCK);
                        output.accept(ModBlocks.HD_LEON_BLOCK);
                    })
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }
}
