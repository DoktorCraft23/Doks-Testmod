package net.doktorcraft23.dokstestmod.datagen;

import net.doktorcraft23.dokstestmod.DoksTestMod;
import net.doktorcraft23.dokstestmod.block.ModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends BlockTagsProvider {
    public ModBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, DoksTestMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.MAGIC_BLOCK.get())
                .add(ModBlocks.URANIUM_BLOCK.get())
                .add(ModBlocks.STEEL_BLOCK.get())
                .add(ModBlocks.MECHANIUM_BLOCK.get());

        tag(BlockTags.MINEABLE_WITH_HOE)
                .add(ModBlocks.HD_LEON_BLOCK.get())
                .add(ModBlocks.LEON_BLOCK.get());

        tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.MAGIC_BLOCK.get())
                .add(ModBlocks.URANIUM_BLOCK.get())
                .add(ModBlocks.STEEL_BLOCK.get())
                .add(ModBlocks.HD_LEON_BLOCK.get())
                .add(ModBlocks.LEON_BLOCK.get())
                .add(ModBlocks.MECHANIUM_BLOCK.get());
    }
}
