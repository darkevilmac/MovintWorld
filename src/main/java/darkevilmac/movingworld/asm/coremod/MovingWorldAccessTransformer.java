package darkevilmac.movingworld.asm.coremod;

import net.minecraftforge.fml.common.asm.transformers.AccessTransformer;

import java.io.IOException;

public class MovingWorldAccessTransformer extends AccessTransformer {
    public MovingWorldAccessTransformer() throws IOException {
        super("movingworld_at.cfg");
    }
}
