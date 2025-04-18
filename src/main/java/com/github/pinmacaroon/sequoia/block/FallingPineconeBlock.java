package com.github.pinmacaroon.sequoia.block;

import net.minecraft.block.BlockState;
import net.minecraft.block.FallingBlock;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.FallingBlockEntity;
import net.minecraft.entity.mob.SilverfishEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;

public class FallingPineconeBlock extends FallingBlock {
    public FallingPineconeBlock(Settings settings) {
        super(settings);
    }

    @Override
    public void scheduledTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        if (
                canFallThrough(world.getBlockState(pos.down())) && pos.getY()
                        >= world.getBottomY() && !world.getBlockState(pos.up()).isOf(ModBlocks.SEQUOIA_LEAVES)) {
            FallingBlockEntity fallingBlockEntity = FallingBlockEntity.spawnFromBlock(world, pos, state);
            this.configureFallingBlockEntity(fallingBlockEntity);
        }
    }

    @Override
    public void onLanding(World world, BlockPos pos, BlockState fallingBlockState, BlockState currentStateInPos, FallingBlockEntity fallingBlockEntity) {
        if(fallingBlockEntity.timeFalling >= 13 && world.getBlockState(pos).isOf(this)){
            world.breakBlock(pos, false);
            dropStack(world, pos, new ItemStack(ModBlocks.SEQUOIA_SAPLING, world.random.nextInt(2)));
            world.playSound(null, pos, SoundEvents.ENTITY_ZOMBIE_ATTACK_WOODEN_DOOR, SoundCategory.BLOCKS, 1.0F, 0.8F + world.random.nextFloat() * 0.4F);
            if(world.random.nextInt(6) >= 5){
                SilverfishEntity silverfishEntity = EntityType.SILVERFISH.create(world);
                if (silverfishEntity != null) {
                    silverfishEntity.refreshPositionAndAngles(pos.getX() + 0.5, pos.getY(), pos.getZ() + 0.5, 0.0F, 0.0F);
                    world.spawnEntity(silverfishEntity);
                    silverfishEntity.playSpawnEffects();
                }
            }
        }
    }

    @Override
    protected void configureFallingBlockEntity(FallingBlockEntity entity) {
        entity.setHurtEntities(2f, 4);
    }
}
