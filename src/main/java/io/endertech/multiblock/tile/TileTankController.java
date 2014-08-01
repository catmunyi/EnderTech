package io.endertech.multiblock.tile;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import io.endertech.multiblock.MultiblockValidationException;
import io.endertech.multiblock.controller.ControllerTank;
import io.endertech.reference.Strings;
import io.endertech.util.BlockCoord;
import net.minecraft.util.AxisAlignedBB;

public class TileTankController extends TileTankPart
{
    public static void init()
    {
        GameRegistry.registerTileEntity(TileTankController.class, "tile." + Strings.Blocks.TANK_CONTROLLER_NAME);
    }

    @Override
    public void isGoodForFrame() throws MultiblockValidationException
    {

    }

    @Override
    public void isGoodForSides() throws MultiblockValidationException
    {
        throw new MultiblockValidationException("Controllers cannot be used for tank sides (only the frame).");
    }

    @Override
    public void isGoodForTop() throws MultiblockValidationException
    {
        throw new MultiblockValidationException("Controllers cannot be used for tank top (only the frame).");
    }

    @Override
    public void isGoodForBottom() throws MultiblockValidationException
    {
        throw new MultiblockValidationException("Controllers cannot be used for tank bottom (only the frame).");
    }

    @Override
    public void isGoodForInterior() throws MultiblockValidationException
    {
        throw new MultiblockValidationException("Controllers cannot be used for tank interior (only the frame).");
    }

    @Override
    public void onMachineActivated()
    {

    }

    @Override
    public void onMachineDeactivated()
    {

    }

    @Override
    @SideOnly(Side.CLIENT)
    public AxisAlignedBB getRenderBoundingBox()
    {
        if (!this.isConnected()) return INFINITE_EXTENT_AABB;
        else
        {
            ControllerTank controller = this.getTankController();
            BlockCoord min = controller.getMinimumCoord();
            BlockCoord max = controller.getMaximumCoord();

            return AxisAlignedBB.getBoundingBox(min.x, min.y, min.z, max.x, max.y, max.z);
        }
    }
}
