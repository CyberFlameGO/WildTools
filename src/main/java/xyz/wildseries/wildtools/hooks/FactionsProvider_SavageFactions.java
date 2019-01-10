package xyz.wildseries.wildtools.hooks;

import com.massivecraft.factions.FPlayer;
import com.massivecraft.factions.FPlayers;
import com.massivecraft.factions.struct.Role;

import org.bukkit.entity.Player;

import xyz.wildseries.wildtools.WildToolsPlugin;

public final class FactionsProvider_SavageFactions implements FactionsProvider {

    public FactionsProvider_SavageFactions(){
        WildToolsPlugin.log(" - Using SavageFactions as FactionsProvider.");
    }

    @Override
    public int getTNTAmountFromBank(Player player) {
        FPlayer fPlayer = FPlayers.getInstance().getByPlayer(player);
        return !fPlayer.hasFaction() || !fPlayer.getRole().isAtLeast(Role.MODERATOR) ? 0 : fPlayer.getFaction().getTnt();
    }

    @Override
    public void takeTNTFromBank(Player player, int amount) {
        FPlayer fPlayer = FPlayers.getInstance().getByPlayer(player);

        if(fPlayer.hasFaction() && fPlayer.getRole().isAtLeast(Role.MODERATOR))
            fPlayer.getFaction().takeTnt(amount);
    }
}
