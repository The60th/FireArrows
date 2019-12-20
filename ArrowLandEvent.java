package main.events;

import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LightningStrike;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.util.BlockIterator;

import java.util.Random;

public class ArrowLandEvent implements Listener {
    @EventHandler
    public void onProjectileHitEvent(ProjectileHitEvent event) {
        Entity entity = event.getEntity();

        if (entity instanceof Arrow) {

            BlockIterator iterator = new BlockIterator(event.getEntity().getWorld(), event.getEntity().getLocation().toVector(), event.getEntity().getVelocity().normalize(), 0.0D, 4);
            Block hitBlock = null;
            while (iterator.hasNext()) {
                hitBlock = iterator.next();

                if (hitBlock.getTypeId() != 0) {
                    break;
                }
            }

            Arrow arrow = (Arrow) event.getEntity(); //Cast the entity to an arrow.

            if (arrow.getFireTicks() > 10) { //The arrow is on fire.

                Location location = hitBlock.getLocation();
                Block block = hitBlock.getRelative(BlockFace.UP);

                if (block.getType() == Material.AIR) { //The block above where the arrow hit is air, so we can set that block to fire.
                    if(fireChance()) location.getWorld().getBlockAt(location).getRelative(BlockFace.UP).setType(Material.FIRE);
                } else { //We need to see where the arrow hit if its the side of a block.

                    Block block1 = location.getWorld().getBlockAt(arrow.getLocation());

                    if(block1.getType() == Material.AIR) { //Just a safety check to make sure we are only setting air to fire.
                        if(fireChance()) block1.setType(Material.FIRE);
                    }

                }
            }

        }

    }

    public boolean fireChance(){
        return Math.random() > .25;
    }
}
