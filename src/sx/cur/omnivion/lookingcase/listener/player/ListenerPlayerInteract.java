package sx.cur.omnivion.lookingcase.listener.player;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.InventoryHolder;

import sx.cur.omnivion.lookingcase.LookingCase;
import sx.cur.omnivion.lookingcase.lang.Meta;
import sx.cur.omnivion.lookingcase.lang.TL;
import sx.cur.omnivion.lookingcase.listener.LCListener;
import sx.cur.omnivion.lookingcase.util.CaseUtil;

public class ListenerPlayerInteract extends LCListener {


	public ListenerPlayerInteract(LookingCase i)
	{
		super(i, PlayerInteractEvent.class);
	}

	@Override
	public void dispatch(Event mevent)
	{
		final PlayerInteractEvent event = (PlayerInteractEvent) mevent;

		if (!(event.getClickedBlock().getState() instanceof InventoryHolder)) return;

		final Player player = event.getPlayer();

		if (!player.hasMetadata(Meta.SELECTION.toString())) return;

		if (player.isSneaking() && !i.getConfigRegistrar().getConfig().getRegisterOnSneak()) return;

		final Location location = event.getClickedBlock().getLocation();
		
		if (event.getAction().equals(Action.RIGHT_CLICK_BLOCK))
		{
			if (CaseUtil.isCase(location)) return;
			CaseUtil.registerCase(location);
			player.sendMessage(TL.ADDED_CONTAINER.toString());
			event.setCancelled(true);
		}
		else if (event.getAction().equals(Action.LEFT_CLICK_BLOCK))
		{
			if (!CaseUtil.isCase(location)) return;
			CaseUtil.deleteCase(location);
			player.sendMessage(TL.REMOVED_CONTAINER.toString());
			event.setCancelled(true);
		}
	}


}