package com.darkona.adventurebackpack.config;

import com.darkona.adventurebackpack.reference.ModInfo;
import cpw.mods.fml.client.event.ConfigChangedEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.common.config.Configuration;

import java.io.File;

/**
 * Created by Darkona on 10/10/2014.
 */
public class ConfigHandler
{

    public static boolean IS_BUILDCRAFT = false;
    public static boolean IS_BAUBLES = false;
    public static boolean IS_TINKERS = false;
    public static boolean IS_THAUM = false;
    public static boolean IS_INVTWEAKS = false;
    public static boolean IS_TWILIGHT = false;
    public static boolean IS_ENVIROMINE = false;

    public static Configuration config;
    public static boolean BACKPACK_SLOT = false;
    public static int GUI_TANK_RENDER = 2;
    public static boolean BONUS_CHEST_ALLOWED = false;
    public static boolean PIGMAN_ALLOWED = false;

    public static boolean BACKPACK_ABILITIES = true;

    public static boolean ALLOW_COPTER_SOUND = true;

    public static void init(File configFile)
    {
        if (config == null)
        {
            config = new Configuration(configFile);
            loadConfiguration();
        }
    }


    private static void loadConfiguration()
    {
        BACKPACK_SLOT = config.getBoolean("testValue", config.CATEGORY_GENERAL, false, "Use backpacks in armor slot?");
        GUI_TANK_RENDER = config.getInt("TankRenderType", config.CATEGORY_GENERAL, 3, 1, 3, "1,2 or 3 for different rendering of fluids in the Backpack GUI");
        BONUS_CHEST_ALLOWED = config.getBoolean("BonusBackpack", config.CATEGORY_GENERAL, false, "Include a Standard Adventure Backpack in bonus chest?");
        PIGMAN_ALLOWED = config.getBoolean("PigmanBackpacks", config.CATEGORY_GENERAL, false, "Allow generation of Pigman Backpacks in dungeon loot and villager trades");
        ALLOW_COPTER_SOUND = config.getBoolean("CopterPackSound",config.CATEGORY_GENERAL,true, "Allow playing the CopterPack sound (Client Only, other players may hear it)");
        BACKPACK_ABILITIES = config.getBoolean("BackpackAbilities",config.CATEGORY_GENERAL,true,"Allow the backpacks to execute their special abilities, or be only cosmetic (Doesn't affect lightning transformation) Must be " +
                "disabled in both Client and Server to work properly");
        if (config.hasChanged())
        {
            config.save();
        }
    }

    @SubscribeEvent
    public void onConfigChangeEvent(ConfigChangedEvent.OnConfigChangedEvent event)
    {
        if (event.modID.equalsIgnoreCase(ModInfo.MOD_ID))
        {
            loadConfiguration();
        }
    }


}
