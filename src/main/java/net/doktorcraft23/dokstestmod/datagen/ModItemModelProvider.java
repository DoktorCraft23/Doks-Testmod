package net.doktorcraft23.dokstestmod.datagen;

import net.doktorcraft23.dokstestmod.DoksTestMod;
import net.doktorcraft23.dokstestmod.item.ModItems;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, DoksTestMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(ModItems.MECHANIUM_FRAGMENT.get());
        basicItem(ModItems.STEEL_INGOT.get());
        basicItem(ModItems.COIN.get());
        basicItem(ModItems.URANIUM_INGOT.get());
    }
}
