# GrassAlign
Forge version of Earthcomputer's GrassAlign Fabric mod to work with 1.19.2.  This mod changes how grass renders such that it takes the Y block coordinate into account.  As of Minecraft release 1.8, grass only uses the X and Z block coordinates to determine the offset within the block and computed as if the grass was at Y level 0.
Earthcomputer's mod includes an additional -0.1 z offset in a render call.  This mod was designed to emulate screenshots taken in 1.2.5 and does not include it.  I'm not sure when this offset was removed, but I know it will match grass in versions as old as 1.2.5 up to 1.7.10.

Earthcomputer's original mod: https://github.com/Earthcomputer/GrassAlign
