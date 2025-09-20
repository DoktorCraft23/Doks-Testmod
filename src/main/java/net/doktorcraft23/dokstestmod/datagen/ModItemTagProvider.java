package net.doktorcraft23.dokstestmod.datagen;

import net.doktorcraft23.dokstestmod.DoksTestMod;
import net.doktorcraft23.dokstestmod.item.ModItems;
import net.doktorcraft23.dokstestmod.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends ItemTagsProvider {
    public ModItemTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider,
                              CompletableFuture<TagLookup<Block>> blockTags, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, blockTags, DoksTestMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(ModTags.Items.TRANSFORMABLE_ITEM)
                .add(ModItems.MECHANIUM_FRAGMENT.get())
                .add(ModItems.COIN.get())
                .add(Items.DIAMOND)
                .add(Items.ANCIENT_DEBRIS)
                .add(Items.EMERALD);

    }
}