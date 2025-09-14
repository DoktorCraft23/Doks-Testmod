package net.doktorcraft23.dokstestmod.item.custom;

import net.doktorcraft23.dokstestmod.block.ModBlocks;
import net.minecraft.server.commands.SummonCommand;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

import java.util.Map;

public class CoinItem extends Item {
    private static final Map<Block, Block> COIN_MAP =
            Map.of(
                    Blocks.DIRT, ModBlocks.LEON_BLOCK.get(),
                    ModBlocks.LEON_BLOCK.get(), ModBlocks.HD_LEON_BLOCK.get(),
                    ModBlocks.HD_LEON_BLOCK.get(), Blocks.IRON_BLOCK
            );

    public CoinItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        Level level = context.getLevel();
        Block clickedBlock = level.getBlockState(context.getClickedPos()).getBlock();

        if (COIN_MAP.containsKey(clickedBlock)) {
            if (!level.isClientSide()) {
                level.setBlockAndUpdate(context.getClickedPos(), COIN_MAP.get(clickedBlock).defaultBlockState());

                context.getItemInHand().hurtAndBreak(1, ((ServerLevel) level), context.getPlayer(),
                        item -> context.getPlayer().onEquippedItemBroken(item, EquipmentSlot.MAINHAND));

                level.playSound(null, context.getClickedPos(), SoundEvents.MOOSHROOM_CONVERT, SoundSource.BLOCKS);
            }
        }
        return InteractionResult.SUCCESS;
    }
}
