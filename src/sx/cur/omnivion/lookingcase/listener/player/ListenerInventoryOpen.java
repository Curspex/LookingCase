package sx.cur.omnivion.lookingcase.listener.player;

import org.bukkit.Bukkit;
import org.bukkit.block.BlockState;
import org.bukkit.event.Event;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.metadata.FixedMetadataValue;

import sx.cur.omnivion.lookingcase.LookingCase;
import sx.cur.omnivion.lookingcase.event.LookingCaseOpenEvent;
import sx.cur.omnivion.lookingcase.lang.Meta;
import sx.cur.omnivion.lookingcase.listener.LCListener;
import sx.cur.omnivion.lookingcase.util.CaseUtil;

public class ListenerInventoryOpen extends LCListener {


	public ListenerInventoryOpen(LookingCase i)
	{
		super(i, InventoryOpenEvent.class);
	}

	@Override
	public void dispatch(Event mevent)
	{
		final InventoryOpenEvent event = (InventoryOpenEvent) mevent;

		final InventoryHolder holder = event.getInventory().getHolder();

		if (holder == null || !(holder instanceof BlockState)) return;

		final BlockState holderblock = (BlockState) holder;

		if (!CaseUtil.isCase(holderblock.getLocation())) return;

		LookingCaseOpenEvent callevent = new LookingCaseOpenEvent(event.getView());
		Bukkit.getPluginManager().callEvent(callevent);
		if (callevent.isCancelled()) return;

		event.getPlayer().setMetadata(Meta.VIEWING.toString(), new FixedMetadataValue(super.i, true));
	}





}