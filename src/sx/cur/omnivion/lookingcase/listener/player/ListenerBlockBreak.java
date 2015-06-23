package sx.cur.omnivion.lookingcase.listener.player;

import org.bukkit.event.Event;
import org.bukkit.event.block.BlockBreakEvent;

import sx.cur.omnivion.lookingcase.LookingCase;
import sx.cur.omnivion.lookingcase.lang.TL;
import sx.cur.omnivion.lookingcase.listener.LCListener;
import sx.cur.omnivion.lookingcase.util.CaseUtil;

public class ListenerBlockBreak extends LCListener {

	public ListenerBlockBreak(LookingCase i)
	{
		super(i, BlockBreakEvent.class);
	}

	@Override
	public void dispatch(Event mevent)
	{
		final BlockBreakEvent event = (BlockBreakEvent) mevent;

		if (event.getPlayer().hasPermission("lookingcase.delete")) return;

		if (!CaseUtil.isCase(event.getBlock().getLocation())) return;

		CaseUtil.deleteCase(event.getBlock().getLocation());
		event.getPlayer().sendMessage(TL.REMOVED_CONTAINER.toString());
	}

}