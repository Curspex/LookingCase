package sx.cur.omnivion.lookingcase.listener.player;

import org.bukkit.event.Event;
import org.bukkit.event.inventory.InventoryCloseEvent;

import sx.cur.omnivion.lookingcase.LookingCase;
import sx.cur.omnivion.lookingcase.lang.Meta;
import sx.cur.omnivion.lookingcase.listener.LCListener;

public class ListenerInventoryClose extends LCListener {


	public ListenerInventoryClose(LookingCase i)
	{
		super(i, InventoryCloseEvent.class);
	}

	@Override
	public void dispatch(Event mevent)
	{
		final InventoryCloseEvent event = (InventoryCloseEvent) mevent;

		if (!event.getPlayer().hasMetadata(Meta.VIEWING.toString())) return;

		event.getPlayer().removeMetadata(Meta.VIEWING.toString(), super.i);
	}


}