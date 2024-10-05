package net.anonymoushex.grassalign.mixins;

import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.core.BlockPos;
import net.minecraft.world.phys.Vec3;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(BlockBehaviour.BlockStateBase.class)
public abstract class MixinBlockBehaviour
{
    @Inject(method = "getOffset", at = @At("HEAD"), cancellable = true)
    private void getGrassOffset(BlockGetter getter, BlockPos pos, CallbackInfoReturnable<Vec3> ci)
    {
        BlockBehaviour.BlockStateBase _this = (BlockBehaviour.BlockStateBase) (Object) this;
        BlockBehaviour.OffsetType offsetType = _this.getOffsetType();

        if (offsetType == BlockBehaviour.OffsetType.XYZ && _this.getBlock() == Blocks.GRASS)
        {
            long var17 = (pos.getX() * 3129871L) ^ (pos.getZ() * 116129781L) ^ (long)pos.getY();
            var17 = var17 * var17 * 42317861L + var17 * 11L;
            double dx = ((double)((float)(var17 >> 16 & 15L) / 15.0F) - 0.5D) * 0.5D;
            double dy = ((double)((float)(var17 >> 20 & 15L) / 15.0F) - 1.0D) * 0.2D;
            double dz = ((double)((float)(var17 >> 24 & 15L) / 15.0F) - 0.5D) * 0.5D;
            ci.setReturnValue(new Vec3(dx, dy, dz));
        }
    }
}