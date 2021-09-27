package com.theishiopian.parrying.Registration;

import com.theishiopian.parrying.Items.APItem;
import com.theishiopian.parrying.Items.DaggerItem;
import com.theishiopian.parrying.Items.FlailItem;
import com.theishiopian.parrying.Items.SpearItem;
import com.theishiopian.parrying.ParryingMod;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemModelsProperties;
import net.minecraft.item.ItemTier;
import net.minecraft.util.Hand;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

/**
 * This class is used to register custom items. Mostly weapons.
 */
@SuppressWarnings("unused")//yes, they are, just not here. trust me
public class ModItems
{
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, ParryingMod.MOD_ID);
    public static final float MACE_AP = 0.35f;
    public static final float HAMMER_AP = 0.65f;
    public static final float FLAIL_AP = 0.15f;

    public static final float MACE_SPEED = -2.7f;
    public static final float HAMMER_SPEED = -3f;
    public static final float FLAIL_SPEED = -2.3f;
    public static final float SPEAR_SPEED = -2.8f;
    public static final float DAGGER_SPEED = -1f;

    public static final RegistryObject<Item> WOODEN_MACE = ITEMS.register("wooden_mace", () -> new APItem(ItemTier.WOOD, 3, MACE_SPEED, MACE_AP, (new Item.Properties()).tab(ItemGroup.TAB_COMBAT)));
    public static final RegistryObject<Item> STONE_MACE = ITEMS.register("stone_mace", () -> new APItem(ItemTier.STONE, 3, MACE_SPEED, MACE_AP, (new Item.Properties()).tab(ItemGroup.TAB_COMBAT)));
    public static final RegistryObject<Item> IRON_MACE = ITEMS.register("iron_mace", () -> new APItem(ItemTier.IRON, 3, MACE_SPEED, MACE_AP, (new Item.Properties()).tab(ItemGroup.TAB_COMBAT)));
    public static final RegistryObject<Item> GOLDEN_MACE = ITEMS.register("golden_mace", () -> new APItem(ItemTier.GOLD, 3, MACE_SPEED, MACE_AP, (new Item.Properties()).tab(ItemGroup.TAB_COMBAT)));
    public static final RegistryObject<Item> DIAMOND_MACE = ITEMS.register("diamond_mace", () -> new APItem(ItemTier.DIAMOND, 3, MACE_SPEED, MACE_AP, (new Item.Properties()).tab(ItemGroup.TAB_COMBAT)));
    public static final RegistryObject<Item> NETHERITE_MACE = ITEMS.register("netherite_mace", () -> new APItem(ItemTier.NETHERITE, 3, MACE_SPEED, MACE_AP, (new Item.Properties()).tab(ItemGroup.TAB_COMBAT)));

    public static final RegistryObject<Item> WOODEN_HAMMER = ITEMS.register("wooden_hammer", () -> new APItem(ItemTier.WOOD, 6, HAMMER_SPEED, HAMMER_AP, (new Item.Properties()).tab(ItemGroup.TAB_COMBAT)));
    public static final RegistryObject<Item> STONE_HAMMER = ITEMS.register("stone_hammer", () -> new APItem(ItemTier.STONE, 6, HAMMER_SPEED, HAMMER_AP, (new Item.Properties()).tab(ItemGroup.TAB_COMBAT)));
    public static final RegistryObject<Item> IRON_HAMMER = ITEMS.register("iron_hammer", () -> new APItem(ItemTier.IRON, 6, HAMMER_SPEED, HAMMER_AP, (new Item.Properties()).tab(ItemGroup.TAB_COMBAT)));
    public static final RegistryObject<Item> GOLDEN_HAMMER = ITEMS.register("golden_hammer", () -> new APItem(ItemTier.GOLD, 6, HAMMER_SPEED, HAMMER_AP, (new Item.Properties()).tab(ItemGroup.TAB_COMBAT)));
    public static final RegistryObject<Item> DIAMOND_HAMMER = ITEMS.register("diamond_hammer", () -> new APItem(ItemTier.DIAMOND, 6, HAMMER_SPEED, HAMMER_AP, (new Item.Properties()).tab(ItemGroup.TAB_COMBAT)));
    public static final RegistryObject<Item> NETHERITE_HAMMER = ITEMS.register("netherite_hammer", () -> new APItem(ItemTier.NETHERITE, 6, HAMMER_SPEED, HAMMER_AP, (new Item.Properties()).tab(ItemGroup.TAB_COMBAT)));

    public static final RegistryObject<Item> WOODEN_DAGGER = ITEMS.register("wooden_dagger", () -> new DaggerItem(ItemTier.WOOD, 2, DAGGER_SPEED, (new Item.Properties()).tab(ItemGroup.TAB_COMBAT)));
    public static final RegistryObject<Item> STONE_DAGGER = ITEMS.register("stone_dagger", () -> new DaggerItem(ItemTier.STONE, 2, DAGGER_SPEED, (new Item.Properties()).tab(ItemGroup.TAB_COMBAT)));
    public static final RegistryObject<Item> IRON_DAGGER = ITEMS.register("iron_dagger", () -> new DaggerItem(ItemTier.IRON, 2, DAGGER_SPEED, (new Item.Properties()).tab(ItemGroup.TAB_COMBAT)));
    public static final RegistryObject<Item> GOLDEN_DAGGER = ITEMS.register("golden_dagger", () -> new DaggerItem(ItemTier.GOLD, 2, DAGGER_SPEED, (new Item.Properties()).tab(ItemGroup.TAB_COMBAT)));
    public static final RegistryObject<Item> DIAMOND_DAGGER = ITEMS.register("diamond_dagger", () -> new DaggerItem(ItemTier.DIAMOND, 2, DAGGER_SPEED, (new Item.Properties()).tab(ItemGroup.TAB_COMBAT)));
    public static final RegistryObject<Item> NETHERITE_DAGGER = ITEMS.register("netherite_dagger", () -> new DaggerItem(ItemTier.NETHERITE, 2, DAGGER_SPEED, (new Item.Properties()).tab(ItemGroup.TAB_COMBAT)));

    private static final FlailItem WoodFlail = new FlailItem(ItemTier.WOOD, 2, FLAIL_SPEED, FLAIL_AP, 0.5f, (new Item.Properties()).tab(ItemGroup.TAB_COMBAT));
    private static final FlailItem StoneFlail = new FlailItem(ItemTier.STONE, 2, FLAIL_SPEED, FLAIL_AP, 0.5f, (new Item.Properties()).tab(ItemGroup.TAB_COMBAT));
    private static final FlailItem IronFlail = new FlailItem(ItemTier.IRON, 2, FLAIL_SPEED, FLAIL_AP, 0.5f, (new Item.Properties()).tab(ItemGroup.TAB_COMBAT));
    private static final FlailItem GoldFlail = new FlailItem(ItemTier.GOLD, 2, FLAIL_SPEED, FLAIL_AP, 0.5f, (new Item.Properties()).tab(ItemGroup.TAB_COMBAT));
    private static final FlailItem DiamondFlail = new FlailItem(ItemTier.DIAMOND, 2, FLAIL_SPEED, FLAIL_AP, 0.5f, (new Item.Properties()).tab(ItemGroup.TAB_COMBAT));
    private static final FlailItem NetheriteFlail = new FlailItem(ItemTier.NETHERITE, 2, FLAIL_SPEED, FLAIL_AP, 0.5f, (new Item.Properties()).tab(ItemGroup.TAB_COMBAT));

    public static final RegistryObject<Item> WOOD_FLAIL = ITEMS.register("wood_flail", () -> WoodFlail);
    public static final RegistryObject<Item> STONE_FLAIL = ITEMS.register("stone_flail", () -> StoneFlail);
    public static final RegistryObject<Item> IRON_FLAIL = ITEMS.register("iron_flail", () -> IronFlail);
    public static final RegistryObject<Item> GOLD_FLAIL = ITEMS.register("gold_flail", () -> GoldFlail);
    public static final RegistryObject<Item> DIAMOND_FLAIL = ITEMS.register("diamond_flail", () -> DiamondFlail);
    public static final RegistryObject<Item> NETHERITE_FLAIL = ITEMS.register("netherite_flail", () -> NetheriteFlail);

    //I wish I could make these private, but the model loader needs them public for some reason. is .get() not good enough for you?! shameful
    public static final SpearItem WoodSpear = new SpearItem(ItemTier.WOOD, 2, SPEAR_SPEED, 1, (new Item.Properties().tab(ItemGroup.TAB_COMBAT)), "wood");
    public static final SpearItem StoneSpear = new SpearItem(ItemTier.STONE, 2, SPEAR_SPEED, 1, (new Item.Properties().tab(ItemGroup.TAB_COMBAT)), "stone");
    public static final SpearItem IronSpear = new SpearItem(ItemTier.IRON, 2, SPEAR_SPEED, 1,  (new Item.Properties().tab(ItemGroup.TAB_COMBAT)), "iron");
    public static final SpearItem GoldSpear = new SpearItem(ItemTier.GOLD, 2, SPEAR_SPEED, 1, (new Item.Properties().tab(ItemGroup.TAB_COMBAT)), "gold");
    public static final SpearItem DiamondSpear = new SpearItem(ItemTier.DIAMOND, 2, SPEAR_SPEED, 1, (new Item.Properties().tab(ItemGroup.TAB_COMBAT)), "diamond");
    public static final SpearItem NetheriteSpear = new SpearItem(ItemTier.NETHERITE, 2, SPEAR_SPEED, 1, (new Item.Properties().tab(ItemGroup.TAB_COMBAT)), "netherite");

    public static final RegistryObject<SpearItem> WOOD_SPEAR = ITEMS.register("wood_spear", () -> WoodSpear);
    public static final RegistryObject<SpearItem> STONE_SPEAR = ITEMS.register("stone_spear", () -> StoneSpear);
    public static final RegistryObject<SpearItem> IRON_SPEAR = ITEMS.register("iron_spear", () -> IronSpear);
    public static final RegistryObject<SpearItem> GOLD_SPEAR = ITEMS.register("gold_spear", () -> GoldSpear);
    public static final RegistryObject<SpearItem> DIAMOND_SPEAR = ITEMS.register("diamond_spear", () -> DiamondSpear);
    public static final RegistryObject<SpearItem> NETHERITE_SPEAR = ITEMS.register("netherite_spear", () -> NetheriteSpear);

    //spears may be able to use this system too, investigate in the future
    public static void RegisterFlailOverrides()
    {
        FlailItem[] flails =
        {
            WoodFlail,
            StoneFlail,
            IronFlail,
            GoldFlail,
            DiamondFlail,
            NetheriteFlail
        };

        //if null pointers get thrown in the item render, look at these rascals
        for (FlailItem flail:flails)
        {
            ItemModelsProperties.register(flail, new ResourceLocation("swing"), (stack, world, user)-> user != null ? user.attackAnim : 0);
            ItemModelsProperties.register(flail, new ResourceLocation("swinging"), (stack, world, user)->
            {
                boolean mainHand = false;
                boolean offHand = false;

                if(user != null)
                {
                    mainHand = user.getMainHandItem().equals(stack) && user.swingingArm == Hand.MAIN_HAND;
                    offHand = user.getOffhandItem().equals(stack) && user.swingingArm == Hand.OFF_HAND;
                }
                return (user != null && user.attackAnim > 0 && (mainHand || offHand)) ? 1 : 0;
            });
        }
    }
}