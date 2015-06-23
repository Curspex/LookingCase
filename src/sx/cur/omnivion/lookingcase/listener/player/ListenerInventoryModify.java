package sx.cur.omnivion.lookingcase.listener.player;

import org.bukkit.event.Event;
import org.bukkit.event.inventory.InventoryClickEvent;
import sx.cur.omnivion.lookingcase.LookingCase;
import sx.cur.omnivion.lookingcase.lang.Meta;
import sx.cur.omnivion.lookingcase.listener.LCListener;
import sx.cur.omnivion.lookingcase.util.InventoryUtil;

public class ListenerInventoryModify extends LCListener {


	public ListenerInventoryModify(LookingCase i)
	{
		super(i, InventoryClickEvent.class);
	}

	@Override
	public void dispatch(Event mevent)
	{
		final InventoryClickEvent event = (InventoryClickEvent) mevent;

		if (!event.getWhoClicked().hasMetadata(Meta.VIEWING.toString())) return;

		if (event.getWhoClicked().hasPermission("lookingcase.modify")) return;

		InventoryUtil.restore(event);
	}


}