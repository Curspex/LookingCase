package sx.cur.omnivion.lookingcase.event;

import org.bukkit.entity.HumanEntity;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.bukkit.event.inventory.InventoryEvent;
import org.bukkit.inventory.InventoryView;

public class LookingCaseOpenEvent extends InventoryEvent implements Cancellable {


	public LookingCaseOpenEvent(InventoryView transaction)
	{
		super(transaction);
	}

	private boolean cancelled;
	private static final HandlerList handlers = new HandlerList();

	public final HumanEntity getPlayer()
	{
		return this.transaction.getPlayer();
	}

	public boolean isLocked()
	{
		return !this.getPlayer().hasPermission("lookingcase.modify");
	}

	@Override
	public boolean isCancelled()
	{
		return cancelled;
	}

	@Override
	public void setCancelled(boolean cancelled)
	{
		this.cancelled = cancelled;
	}

	@Override
	public HandlerList getHandlers()
	{
		return LookingCaseOpenEvent.handlers;
	}


}