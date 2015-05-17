package darkevilmac.movingworld.block;

import darkevilmac.movingworld.tile.TileMovingWorldMarkingBlock;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;

public abstract class BlockMovingWorldMarker extends BlockContainer {

    protected BlockMovingWorldMarker(Material material) {
        super(material);
    }

    public static void onPlacedBy(World world, BlockPos pos, IBlockState state, EntityLivingBase entity, ItemStack itemStack) {
        if (world != null && !world.isRemote && entity != null && entity instanceof EntityPlayer) {
            if (world.getTileEntity(pos) != null && world.getTileEntity(pos) instanceof TileMovingWorldMarkingBlock) {
                TileMovingWorldMarkingBlock tile = (TileMovingWorldMarkingBlock) world.getTileEntity(pos);
                tile.getInfo().setOwner(((EntityPlayer) entity).getGameProfile().getId());
            }
        }
    }

    @Override
    public void onBlockPlacedBy(World world, BlockPos pos, IBlockState state, EntityLivingBase entity, ItemStack itemStack) {
        super.onBlockPlacedBy(world, pos, state, entity, itemStack);

        if (world != null && !world.isRemote && entity != null && entity instanceof EntityPlayer) {
            if (world.getTileEntity(pos) != null && world.getTileEntity(pos) instanceof TileMovingWorldMarkingBlock) {
                TileMovingWorldMarkingBlock tile = (TileMovingWorldMarkingBlock) world.getTileEntity(pos);
                tile.getInfo().setOwner(((EntityPlayer) entity).getGameProfile().getId());
            }
        }
    }
}
