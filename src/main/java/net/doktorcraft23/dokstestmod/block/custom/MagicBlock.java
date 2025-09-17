package net.doktorcraft23.dokstestmod.block.custom;

import net.doktorcraft23.dokstestmod.item.ModItems;
import net.doktorcraft23.dokstestmod.util.ModTags;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

import java.util.List;

public class MagicBlock extends Block {
    public MagicBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hitResult) {
        level.playSound(player, pos, SoundEvents.AMETHYST_BLOCK_RESONATE, SoundSource.BLOCKS, 1f, 1f);
        return InteractionResult.SUCCESS;
    }

    @Override
    public void stepOn(Level level, BlockPos pos, BlockState state, Entity entity) {
        if (entity instanceof ItemEntity itemEntity) {
            if (isValidItem(itemEntity.getItem())) {
                itemEntity.setItem(new ItemStack(Items.NETHER_STAR, itemEntity.getItem().getCount()));
                level.playSound(itemEntity, pos, SoundEvents.MOOSHROOM_CONVERT, SoundSource.BLOCKS, 1f, 1f);
            }
            if (itemEntity.getItem().getItem() == ModItems.MECHANIUM_FRAGMENT.get()) {
                itemEntity.setItem(new ItemStack(Items.DIAMOND_BLOCK, itemEntity.getItem().getCount()));
                level.playSound(itemEntity, pos, SoundEvents.MOOSHROOM_CONVERT, SoundSource.BLOCKS, 1f, 1f);
            }
        }
        super.stepOn(level, pos, state, entity);
    }

    private boolean isValidItem(ItemStack item) {
        return item.is(ModTags.Items.TRANSFORMABLE_ITEM);
    }

    @Override
    public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        tooltipComponents.add(Component.translatable("tooltip.dokstestmod.magic_block_tooltip"));
        super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
    }
}
