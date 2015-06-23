package sx.cur.omnivion.lookingcase.util;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Event.Result;
import org.bukkit.event.inventory.InventoryClickEvent;

import sx.cur.omnivion.lookingcase.LookingCase;

@SuppressWarnings("deprecation")
public class InventoryUtil {


	public static void restore(final InventoryClickEvent event)
	{
		event.setResult(Result.DENY);
		event.setCancelled(true);
		if (event.getCursor() != null)
			event.getCursor().setAmount(0);
		Bukkit.getScheduler().runTaskLater(LookingCase.i, new Runnable()
		{

			@Override
			public void run()
			{
				((Player) event.getWhoClicked()).updateInventory();
			}

		}, LookingCase.i.getConfigRegistrar().getConfig().getRefreshTickDelay());
	}


}