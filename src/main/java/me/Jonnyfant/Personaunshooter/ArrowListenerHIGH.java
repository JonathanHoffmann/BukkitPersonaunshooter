package me.Jonnyfant.Personaunshooter;

import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.projectiles.ProjectileSource;


public class ArrowListenerHIGH implements Listener {

    @EventHandler(priority = EventPriority.HIGH)
    public void onArrowHitSelf(EntityDamageByEntityEvent event) {

//https://stackoverflow.com/questions/43194090/bukkit-spigot-entitydamagebyentityevent-cast-the-shooter
        // Is target a player, if not stop
        if (!(event.getEntity() instanceof Player))
            return;

        Player damagee = (Player) event.getEntity();

        // Is damager an arrow, if not stop
        if (!(event.getDamager() instanceof Arrow))
            return;

        // Is shooter a player, if not stop
        ProjectileSource src = ((Arrow) event.getDamager()).getShooter();
        if (!(src instanceof Player))
            return;

        Player damager = (Player) src;

        if (damagee.equals(damager)) ;

        {
            event.setCancelled(true);
        }
    }
}