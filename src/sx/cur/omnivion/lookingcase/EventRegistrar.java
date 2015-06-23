package sx.cur.omnivion.lookingcase;

import org.bukkit.event.EventPriority;
import org.bukkit.event.HandlerList;
import org.bukkit.plugin.PluginManager;

import sx.cur.omnivion.lookingcase.listener.LCListener;

public class EventRegistrar implements IAnnihilate {


	private final LookingCase i;
	private final EventPriority defaultPriority;
	private final boolean defaultIgnoreCancelled;
	private final PluginManager manager;
	public EventRegistrar(final LookingCase i, final PluginManager manager, final boolean defaultIgnoreCancelled, final EventPriority defaultPriority)
	{
		this.i = i;
		this.manager = manager;
		this.defaultIgnoreCancelled = defaultIgnoreCancelled;
		this.defaultPriority = defaultPriority;
	}

	protected void registerEvent(LCListener obj)
	{
		this.registerEvent(obj, this.defaultPriority, this.defaultIgnoreCancelled);
	}

	protected void registerEvent(LCListener obj, EventPriority priority, boolean ignoreCancelled)
	{
		this.manager.registerEvent(obj.getClazz(), obj, priority, obj, this.i, ignoreCancelled);
	}

	@Override
	public void annihilate()
	{
		HandlerList.unregisterAll(i);
		manager.disablePlugin(i);
	}


}