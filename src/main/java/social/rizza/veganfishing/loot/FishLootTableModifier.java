package social.rizza.veganfishing.loot;

import net.fabricmc.fabric.api.loot.v3.LootTableEvents;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.entries.LootPoolSingletonContainer;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.NumberProvider;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

public class FishLootTableModifier {

    private static final Identifier fishingLootTableId = Identifier.fromNamespaceAndPath("minecraft", "gameplay/fishing/fish");

    public static void modifyLootTable() {
        LootTableEvents.REPLACE.register((key, original, source, registries) -> {
            if (!key.identifier().equals(fishingLootTableId)) {
                return null;
            }

            LootPool.Builder lootPool = LootPool.lootPool();
            addItemsToLootPool(lootPool);

            return LootTable.lootTable()
                    .pool(lootPool.build())
                    .build();
        });
    }

    private static void addItemsToLootPool(LootPool.Builder lootPool) {
        addItemToLootPool(Items.KELP, lootPool, 60, ConstantValue.exactly(1f));
        addItemToLootPool(Items.CLAY_BALL, lootPool, 25, UniformGenerator.between(2f, 5f));
        addItemToLootPool(Items.SEA_PICKLE, lootPool, 13, ConstantValue.exactly(1f));
        addItemToLootPool(Items.PRISMARINE_SHARD, lootPool, 1, UniformGenerator.between(1f, 2f));
        addItemToLootPool(Items.PRISMARINE_CRYSTALS, lootPool, 1, UniformGenerator.between(1f, 2f));
    }

    private static void addItemToLootPool(Item item, LootPool.Builder lootPool, int weight, NumberProvider countProvider) {
        LootPoolSingletonContainer.Builder<?> lootPoolItemBuilder = LootItem.lootTableItem(item)
                .setWeight(weight)
                .apply(SetItemCountFunction.setCount(countProvider));

        lootPool.add(lootPoolItemBuilder);
    }
}
