package com.minecraftdimensions.babyeggs;

import org.bukkit.Material;
import org.bukkit.entity.Chicken;
import org.bukkit.entity.Cow;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Horse;
import org.bukkit.entity.MushroomCow;
import org.bukkit.entity.Ocelot;
import org.bukkit.entity.Pig;
import org.bukkit.entity.Sheep;
import org.bukkit.entity.Villager;
import org.bukkit.entity.Wolf;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.CreatureSpawnEvent.SpawnReason;
import org.bukkit.inventory.ItemStack;


public class BabyEggsListener implements Listener {



	@EventHandler
	public void creatureSpawn(CreatureSpawnEvent e) {
		if(e.getSpawnReason().equals(SpawnReason.BREEDING)){
			e.setCancelled(true);
			EntityType type = e.getEntityType();
			if(type.equals(EntityType.HORSE)){
			e.getLocation().getWorld().dropItemNaturally(e.getLocation(), new ItemStack(Material.MONSTER_EGG, 1, (short) 100));
			}else if(type.equals(EntityType.SHEEP)){
				e.getLocation().getWorld().dropItemNaturally(e.getLocation(), new ItemStack(Material.MONSTER_EGG, 1, (short) 91));	
			}else if(type.equals(EntityType.COW)){
				e.getLocation().getWorld().dropItemNaturally(e.getLocation(), new ItemStack(Material.MONSTER_EGG, 1, (short) 92));	
			}else if(type.equals(EntityType.MUSHROOM_COW)){
				e.getLocation().getWorld().dropItemNaturally(e.getLocation(), new ItemStack(Material.MONSTER_EGG, 1, (short) 96));	
			}else if(type.equals(EntityType.PIG)){
				e.getLocation().getWorld().dropItemNaturally(e.getLocation(), new ItemStack(Material.MONSTER_EGG, 1, (short) 90));	
			}else if(type.equals(EntityType.CHICKEN)){
				e.getLocation().getWorld().dropItemNaturally(e.getLocation(), new ItemStack(Material.MONSTER_EGG, 1, (short) 93));	
			}else if(type.equals(EntityType.WOLF)){
				e.getLocation().getWorld().dropItemNaturally(e.getLocation(), new ItemStack(Material.MONSTER_EGG, 1, (short) 95));	
			}else if(type.equals(EntityType.OCELOT)){
				e.getLocation().getWorld().dropItemNaturally(e.getLocation(), new ItemStack(Material.MONSTER_EGG, 1, (short) 98));	
			}else if(type.equals(EntityType.VILLAGER)){
				e.getLocation().getWorld().dropItemNaturally(e.getLocation(), new ItemStack(Material.MONSTER_EGG, 1, (short) 120));	
			}
		}
		if(e.getSpawnReason().equals(SpawnReason.SPAWNER_EGG)){
			EntityType type = e.getEntityType();
			if(type.equals(EntityType.HORSE)){
				Horse horse = (Horse)e.getEntity();
				horse.setBaby();
				}else if(type.equals(EntityType.SHEEP)){
					Sheep sheep = (Sheep)e.getEntity();
					sheep.setBaby();	
				}else if(type.equals(EntityType.COW)){
					Cow cow = (Cow)e.getEntity();
					cow.setBaby();	
				}else if(type.equals(EntityType.MUSHROOM_COW)){
					MushroomCow cow = (MushroomCow)e.getEntity();
					cow.setBaby();	
				}else if(type.equals(EntityType.PIG)){
					Pig pig = (Pig)e.getEntity();
					pig.setBaby();	
				}else if(type.equals(EntityType.CHICKEN)){
					Chicken chicken = (Chicken)e.getEntity();
					chicken.setBaby();	
				}else if(type.equals(EntityType.WOLF)){
					Wolf wolf = (Wolf)e.getEntity();
					wolf.setBaby();	
				}else if(type.equals(EntityType.OCELOT)){
					Ocelot cat = (Ocelot)e.getEntity();
					cat.setBaby();	
				}else if(type.equals(EntityType.VILLAGER)){
					Villager villager = (Villager)e.getEntity();
					villager.setBaby();	
				}
		}
	}
}
